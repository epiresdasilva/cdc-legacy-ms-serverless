#!/usr/bin/env bash

JBOSS_CLI=/opt/jboss/wildfly/bin/jboss-cli.sh

function wait_for_server() {
  until `$JBOSS_CLI -c ":read-attribute(name=server-state)" 2> /dev/null | grep -q running`; do
    sleep 1
  done
}

/opt/jboss/wildfly/bin/standalone.sh &
wait_for_server

$JBOSS_CLI --connect --file=/opt/jboss/wildfly/standalone/customization/commands.cli

cp /opt/jboss/wildfly/standalone/customization/banking-legacy.war /opt/jboss/wildfly/standalone/deployments/banking-legacy.war
FROM jboss/wildfly

ADD customization/* /opt/jboss/wildfly/standalone/customization/
ADD target/banking-legacy.war /opt/jboss/wildfly/standalone/customization/

RUN /opt/jboss/wildfly/standalone/customization/execute.sh
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
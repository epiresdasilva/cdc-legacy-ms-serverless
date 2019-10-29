# cdc-legacy-ms-serverless

That's a project using CDC (Change Data Capture) to extend your legacy system to new architectures.

## How?

First of all, you must start all services.
```
$ docker-compose up
```

After that, run the following command to add the connector.
```
$ curl -i -X POST -H "Accept:application/json" -H "Content-Type:application/json" localhost:8083/connectors/ -d '{ "name": "movement-connector", "config": { "connector.class": "io.debezium.connector.postgresql.PostgresConnector", "tasks.max": "1", "database.hostname": "postgres", "database.port": "5432",  "database.dbname": "postgres",  "database.user": "postgres", "database.password": "devfest", "database.server.id": "184054", "database.server.name": "postgres", "database.whitelist": "banking", "database.history.kafka.bootstrap.servers": "kafka:9092", "database.history.kafka.topic": "dbhistory.movement" } }'
```

Finally, run the command to create a new movement:

```
$ curl -X POST -H 'Content-Type: application/json' -d '{"value": 15, "competence": "2019-10-28", "accountId": 1}' http://localhost:8080/banking-legacy/api/movements
```
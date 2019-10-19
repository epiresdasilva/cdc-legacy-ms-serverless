import json
from time import sleep
import sys
import requests

from bs4 import BeautifulSoup
from kafka import KafkaConsumer, KafkaProducer
from threading import Thread


def kafkaConsumer():
    topic_name = 'postgres.banking.movements'
    consumer = KafkaConsumer(topic_name, 
                    bootstrap_servers=['kafka:9092'])
    print('Connected..')
    for message in consumer:
        movement = message.value.decode('utf-8')
        print("Python received: " + movement)
        headers = {"Content-Type": "application/json",
                    "Authorization": "Basic ZjA2YjNjNTMtNTkwYy00OTE1LTg2NGUtZGQ0OTAyNGEyMzU4OlpjeGVQanlFRW1WRjhJbk5vd3M1SVl0ajFOQ0dUUnVrOW41d2x3RG01cHM1SE41VU9OT09PWXc0bnhWYUVBTUw="}
        response = requests.post(url = "https://us-south.functions.cloud.ibm.com/api/v1/namespaces/evandro%40evandropires.com.br_dev/actions/debezium/movement-push?blocking=true",
                            headers=headers,
                            data=movement)
        print("Sended..")


if __name__ == '__main__':
    print('Running Consumer..')
    run_thread = Thread(target=kafkaConsumer())
    run_thread.daemon = True
    run_thread.start()
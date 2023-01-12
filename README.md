# ML Service

## Run the project
Using IntelliJ and directly run the mlserviceApplication main function should run the service.
The default port is 8081 which can be modified in application.properties.

Currently, we have set up a sentiment analysis service. To test the service, using the following request
```
curl -X POST localhost:8081/sentimentAnalysis -H 'Content-type:application/json' -d '{"requestId": "request_id_123", "content": "This is a good day"}'
```
The response should be the following
```
{"status":"200","requestId":"request_id_123","content":"{\"request\":{\"text\":\"This is a good day\"},\"response\":{\"word_num\":5,\"sentiment_score\":3.0}}"}
```

## Configs
The API gateway for ml services. Using [Spring initializer](https://start.spring.io) for initializing.
* Project: Gradle-Groovy
* Language: Java
* Spring Boot: 2.7.7
* Packaging: Jar
* Java: 11
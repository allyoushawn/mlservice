# ML Service

## Run the project
Using IntelliJ and directly run the mlserviceApplication main function should run the service.

To test the service, using the following request
```
curl -X POST localhost:8080/machineTranslation -H 'Content-type:application/json' -d '{"requestId": "request_id_123", "content": "This is a good day"}'
```
The response should be the following
```
{"status":"200","requestId":"request_id_123","content":"This is a good day"}
```

## Configs
The API gateway for ml services. Using [Spring initializer](https://start.spring.io) for initializing.
* Project: Gradle-Groovy
* Language: Java
* Spring Boot: 2.7.7
* Packaging: Jar
* Java: 11
# ML Service API Gateway
This repository is the api gateway for ml services like sentiment analysis and machine translation, etc. We implement a 
REST API gateway with Java and Spring framework. 


The mentioned ml services are separated in other repositories.
- [Sentiment Analysis](https://github.com/allyoushawn/sentiment_analysis_model_service)


## Run the project
With IntelliJ and directly run the mlserviceApplication main function.
The default port is 8081 which can be modified in [application.properties](https://github.com/allyoushawn/mlservice/blob/main/application.properties).

Currently, we have set up a sentiment analysis service. 
Follow the instruction in [sentiment analysis repository](https://github.com/allyoushawn/sentiment_analysis_model_service)
to set up and run the service.


To test the ml service, using the following request in terminal:
```
curl -X POST localhost:8081/sentimentAnalysis -H 'Content-type:application/json' -d '{"requestId": "request_id_123", "content": "This is a good day"}'
```
The response should be the following:
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
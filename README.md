# ML Service API Gateway
This repository is the api gateway for ml services like sentiment analysis and machine translation, etc. We implement a 
REST API gateway with Java and Spring framework. 


The mentioned ml services are separated in other repositories.
- [Sentiment Analysis](https://github.com/allyoushawn/ml_model_service/tree/main/sentiment_analysis_model_service)
- [Machine Translation](https://github.com/allyoushawn/ml_model_service/tree/main/mt_model_service)

We also implement a front-end service that 
could take users' requests from browsers.[[GitHubRepo]](https://github.com/allyoushawn/mlservicefrontend)
## Run the project
With IntelliJ and directly run the mlserviceApplication main function.
The default port is 8081 which can be modified in [application.properties](https://github.com/allyoushawn/mlservice/blob/main/application.properties).

Currently, we have set up a sentiment analysis service. 
Follow the instruction in [sentiment analysis repository](https://github.com/allyoushawn/sentiment_analysis_model_service)
to set up and run the service.


To test the ml service, using the following request in terminal:
```
curl -X POST localhost:8081/sentimentAnalysis -H 'Content-type:application/json' -d '{"requestId": "request_id_123", "content": "This is very good."}'
```
The response should be the following:
```
{"status":"200","requestId":"request_id_123","content":"{\"request\":{\"text\":\"This is very good.\"},\"response\":{\"word_num\":5,\"sentiment_score\":3.0}}"}
```

## Run the Gateway with Docker
To communicate with other containers, we have to put these containers into a user-defined bridge network.
We will use a user-defined bridge network named <em>allyoushawn-net</em> as an example.
Check out the [tutorial](https://www.tutorialworks.com/container-networking/) for more information.

Create the bridge network with the following
```
docker network create allyoushawn-net
```

Build image with Docker
```
docker build -t mlservice:base --target base -f deployment/Dockerfile .
```
Run with Docker, while using <em>--net</em> argument to put the container into the network.
```
docker run --name mlservice_local -it -p 8081:8081 --net=allyoushawn-net mlservice:base
```

Similarly, we have to make sure other containers we need to communicate with are put into the network, like
```
docker run --name sentiment_analysis_model_service_local -it -p 4460:4460 --net=allyoushawn-net sentiment_analysis_model_service:prod
```

We also have to make sure we are using the correct hostname in our code for communication.
For example, in [MLServiceController.java](https://github.com/allyoushawn/mlservice/blob/main/src/main/java/com/allyoushawn/mlservice/MLServiceController.java), the POST_URL has to be the following,
where <em>sentiment_analysis_model_service_local:4460</em> represents the target container's name and port. 
```
private static final String POST_URL = "http://sentiment_analysis_model_service_local:4460/sentiment_analysis";
```
The hostname used for docker should be specified in <em>application-docker.properties</em>.

Finally, to stop and remove the container.
```
docker container stop mlservice_local && docker container rm mlservice_local
```

## Configs
The API gateway for ml services. Using [Spring initializer](https://start.spring.io) for initializing.
* Project: Gradle-Groovy
* Language: Java
* Spring Boot: 2.7.7
* Packaging: Jar
* Java: 11

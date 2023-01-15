FROM adoptopenjdk/openjdk11:latest AS base

ARG BUILD_ENV_ARG=local
ARG SERVICE_NAME=MLService
ENV SERVICE_NAME $SERVICE_NAME

COPY ./src /$SERVICE_NAME/src
COPY ./gradle /$SERVICE_NAME/gradle
COPY ./application.properties /$SERVICE_NAME/application.properties
COPY ./build.gradle /$SERVICE_NAME/build.gradle
COPY ./gradlew /$SERVICE_NAME/gradlew
COPY ./gradlew.bat /$SERVICE_NAME/gradlew.bat
COPY ./settings.gradle /$SERVICE_NAME/settings.gradle

RUN cd $SERVICE_NAME && \
    ./gradlew clean build


CMD cd /$SERVICE_NAME && \
    java -jar build/libs/mlservice-1.0.jar





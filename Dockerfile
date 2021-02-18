# Build
FROM maven:3-openjdk-11 AS BUILD
MAINTAINER Lucas Bovolini lbovolini94@gmail.com

ENV APP_FOLDER=~/vaccine-api

WORKDIR ${APP_FOLDER}
COPY src src
COPY pom.xml .

RUN mvn -DskipTests clean package

# Run
FROM openjdk:11-jre-slim

ENV APP_NAME=vaccine-api
ENV APP_FOLDER=~/vaccine-api

WORKDIR ${APP_FOLDER}

COPY --from=BUILD "${APP_FOLDER}/target/${APP_NAME}*.jar" ${APP_NAME}.jar

ENTRYPOINT java -jar ${APP_NAME}.jar

EXPOSE 8080
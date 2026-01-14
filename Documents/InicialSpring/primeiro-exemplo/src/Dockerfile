FROM  ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-24-jdk -y
COPY . .

RUN apt-get- install marven -y
RUN mvn clean install

FROM openjdk:24-jdk-slim
EXPOSE 8081
COPY  --from=build /target/primeiro-exemplo-0.0.1-SNAPSHOT.jar  app.jar
ENTRYPOINT [ "java","-jar","app.jar" ]

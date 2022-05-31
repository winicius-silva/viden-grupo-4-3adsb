FROM openjdk:8-jdk-alpine
ARG JAR_FILE=./*.jar
COPY viden-ws-0.0.1-SNAPSHOT.jar /usr/share/home
ENTRYPOINT ["java","-jar","viden-ws-0.0.1-SNAPSHOT.jar"]
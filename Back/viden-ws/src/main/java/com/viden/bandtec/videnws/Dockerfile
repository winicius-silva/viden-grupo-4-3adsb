FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=./*.jar
COPY ./manifest.txt ./viden-ws.jar
COPY ./viden-ws.jar ./viden-ws.jar
ENTRYPOINT ["java","-jar","viden-ws.jar"]
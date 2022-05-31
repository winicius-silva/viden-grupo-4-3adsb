FROM alpine:latest
ADD VidenWsApplication.java VidenWsApplication.java
RUN apk --update add openjdk8-jre
COPY ${JAR_FILE} viden-ws.jar
ENTRYPOINT ["java","-jar","/viden-ws.jar"]
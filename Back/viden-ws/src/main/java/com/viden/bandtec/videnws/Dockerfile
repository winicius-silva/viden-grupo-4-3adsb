FROM alpine:latest
ADD  viden-ws-0.0.1-SNAPSHOT.jar viden-ws-0.0.1-SNAPSHOT.jar
RUN apk --update add openjdk8-jre
COPY viden-ws-0.0.1-SNAPSHOT.jar /usr/share/home
CMD java -jar /opt/iotruck/iotruck.jar --spring.profiles.active=local
ENTRYPOINT ["java","-jar","viden-ws-0.0.1-SNAPSHOT.jar"]
FROM openjdk:21-jdk-slim

COPY target/discovery-server-0.0.1-SNAPSHOT.jar /app/discovery-server.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "discovery-server.jar"]
FROM openjdk:21-jdk-slim

COPY target/server-config-0.0.1-SNAPSHOT.jar /app/server-config.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "server-config.jar"]
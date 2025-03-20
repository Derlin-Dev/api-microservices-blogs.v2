FROM openjdk:21-jdk-slim

COPY target/auth-servicie-0.0.1-SNAPSHOT.jar /app/auth-servicie.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "auth-servicie.jar"]
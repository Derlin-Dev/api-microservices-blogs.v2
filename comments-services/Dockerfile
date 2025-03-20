FROM openjdk:21-jdk-slim

COPY target/comments-services-0.0.1-SNAPSHOT.jar /app/comments-services.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "comments-services.jar"]
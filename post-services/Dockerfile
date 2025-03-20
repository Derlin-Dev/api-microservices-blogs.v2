FROM openjdk:21-jdk-slim

COPY target/post-services-0.0.1-SNAPSHOT.jar /app/post-services.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "post-services.jar"]
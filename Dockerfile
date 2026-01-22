FROM eclipse-temurin:21-jdk-alpine
LABEL maintainer="danilo.volles.com"
COPY target/notification-api-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
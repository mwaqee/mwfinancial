# Use Eclipse Temurin JDK as base image (recommended for Java 17+)
FROM eclipse-temurin:17-jdk-alpine

RUN apk update && apk add curl  # Pre-install curl

# Set environment variables
ENV APP_HOME=/app

# Create directory inside the container
WORKDIR $APP_HOME

# Copy built JAR from local machine to container
COPY target/account-service-1.0.0.jar app.jar

# Expose the port used by the Spring Boot application
EXPOSE 8081

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]

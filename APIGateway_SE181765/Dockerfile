# Use official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set working directory in container
WORKDIR /app

# Copy jar file to container
COPY target/cloud-gate-way-0.0.1-SNAPSHOT.jar app.jar

# Expose port app chạy (8082 trong file config)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
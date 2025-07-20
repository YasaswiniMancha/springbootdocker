# Use a slim OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file
COPY target/springbootdocker-0.0.1-SNAPSHOT.jar app.jar

# Expose the port (optional, for documentation)
EXPOSE 8081

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
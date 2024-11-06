# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file (make sure it's built first)
COPY target/OPCUA_class-1.0-SNAPSHOT.jar app.jar

# Expose the port that Spring Boot will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

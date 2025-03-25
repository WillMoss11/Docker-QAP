# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the target folder to the container
COPY target/golfclub-0.0.1-SNAPSHOT.jar /app/golfclub.jar

# Make the port 8080 available to the outside world
EXPOSE 8080

# Run the jar file when the container starts
ENTRYPOINT ["java", "-jar", "/app/golfclub.jar"]

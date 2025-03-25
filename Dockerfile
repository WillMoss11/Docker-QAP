# Use official openjdk base image for Spring Boot
FROM openjdk:17-jdk-slim as build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and install dependencies
COPY pom.xml .

# Build the Spring Boot application
RUN ./mvnw clean package -DskipTests

# Copy the packaged JAR file from target folder
COPY target/*.jar app.jar

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Expose port 8080 for the application
EXPOSE 8080

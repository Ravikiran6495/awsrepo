# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Expose the port the application runs on
EXPOSE 8088

# Copy the executable JAR file to the container
COPY target/ravikiran.jar ravikiran.jar

# Run the application
ENTRYPOINT ["java", "-jar", "ravikiran.jar"]

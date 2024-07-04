# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine


# Expose the port the application runs on
EXPOSE 8088

# Copy the executable JAR file to the container
COPY target/springboot-aws-deploy.jar springboot-aws-deploy.jar

# Run the application
ENTRYPOINT ["java", "-jar", "springboot-aws-deploy.jar"]

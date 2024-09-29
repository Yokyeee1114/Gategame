# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file into the container
COPY build/libs/gategame-1.0-all.jar /app/gategame.jar

# (Optional) If your application requires configuration files or other resources, copy them as well
COPY src/main/resources /app/resources

# Expose the port your application listens on (if applicable)
# For example, if your app runs on port 8080:
EXPOSE 8080

# Define the command to run your Java application
ENTRYPOINT ["java", "-jar", "gategame.jar"]

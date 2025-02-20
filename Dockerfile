# Use an official OpenJDK runtime as a parent image
FROM openjdk:18-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file to the container
COPY target/back-end-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
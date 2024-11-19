# Use a base image with JDK for the build stage
FROM openjdk:17-jdk-slim AS build

# Set the working directory for the build process
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle settings.gradle ./

# Copy the source code
COPY src/ ./src/

# Run the Gradle build to generate the JAR file
RUN ./gradlew clean build

# Use a smaller image with JDK for the runtime stage
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/booksmicroservice-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]


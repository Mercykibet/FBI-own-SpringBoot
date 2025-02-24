# Use a Maven image to build the project
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use a lightweight JDK image for runtime
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/FBI-own-0.0.1-SNAPSHOT.jar /app/FBI-own.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/FBI-own.jar"]

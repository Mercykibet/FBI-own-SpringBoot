FROM maven:3.8.5-openjdk-17 AS build
RUN mvn-clean package -D skipTests

FROM openjdk:17.0.1-jdk-slim
COPY build /target/FBI-own-0.0.1-SNAPSHOT.jar /app/FBI-own.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/FBI-own.jar"]
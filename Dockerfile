FROM openjdk:17.0.1-jdk-slim
COPY  FBI-own-0.0.1-SNAPSHOT.jar FBI-own.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","FBI-own.jar"]



##
## Build stage
##
#FROM maven:3.8.3-openjdk-17 AS build
#COPY . .
#RUN mvn clean install
#
##
## Package stage
##
#FROM eclipse-temurin:17-jdk
#COPY --from=build /target/your-build.jar demo.jar
## ENV PORT=8080
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","demo.jar"]
FROM maven:3.8.5-openjdk-17 AS build
RUN mvn clean package -DskipTests

COPY . .

WORKDIR /
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/FBI-own-0.0.1-SNAPSHOT.jar /FBI-own.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/FBI-own.jar"]
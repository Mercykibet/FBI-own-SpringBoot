FROM openjdk:17.0.1-jdk-slim
COPY  FBI-own-0.0.1-SNAPSHOT.jar FBI-own1.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","FBI-own1.jar"]
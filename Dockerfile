FROM openjdk:17.0.1-jdk-slim
COPY --from=build /FBI-own-0.0.1-SNAPSHOT.jar /FBI-own.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","FBI-own.jar"]
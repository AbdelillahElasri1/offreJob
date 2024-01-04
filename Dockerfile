FROM eclipse-temurin:17-jdk-alpine
VOLUME /temp
COPY build/libs/JobOffer-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
FROM openjdk:17-jdk-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8083:8083
ENTRYPOINT ["java", "-jar", "/app.jar"]
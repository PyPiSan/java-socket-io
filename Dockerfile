FROM openjdk:17-jdk-alpine
EXPOSE 8000
ARG JAR_FILE=target/my-application.jar
ADD ${JAR_FILE} socket-app.jar
ENTRYPOINT ["java","-jar","/socket-app.jar"]
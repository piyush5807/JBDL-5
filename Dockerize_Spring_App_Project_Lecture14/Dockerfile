FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /opt/my_app.jar
ENTRYPOINT ["java","-jar","/opt/my_app.jar"]
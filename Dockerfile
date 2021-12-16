FROM openjdk:11
ARG JAR_FILE=./build/libs/GpsMicroService-1.0.0.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]
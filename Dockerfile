FROM maven:3.8.1-jdk-8 as builder
COPY . .
RUN mvn clean package

FROM openjdk:8-jdk-alpine
COPY --from=builder target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
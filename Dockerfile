FROM gradle:jdk17-alpine AS builder
COPY . .
RUN ./gradlew clean build

FROM openjdk:17.0.1-jdk-slim
COPY --from=builder build/libs/coding-dashboard-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

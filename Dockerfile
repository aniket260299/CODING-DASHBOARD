FROM gradle:jdk17-alpine AS builder

ENV datasource_password=${datasource_password}
ENV datasource_username=${datasource_username}
ENV SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE}

WORKDIR /app
COPY . /app/
RUN ./gradlew clean build

FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=builder app/build/libs/coding-dashboard-0.0.1-SNAPSHOT.jar /app/coding-dashboard.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/coding-dashboard.jar"]
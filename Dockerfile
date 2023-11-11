FROM gradle:jdk17-alpine AS builder

ARG SPRING_PROFILES_ACTIVE
ARG jwt_key
ARG datasource_driver
ARG datasource_url
ARG datasource_password
ARG datasource_username
ARG PORT
ARG datasource_dependency

ENV SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE}
ENV PORT=${PORT}
ENV jwt_key=${jwt_key}
ENV datasource_driver=${datasource_driver}
ENV datasource_url=${datasource_url}
ENV datasource_password=${datasource_password}
ENV datasource_username=${datasource_username}
ENV datasource_dependency=${datasource_dependency}

WORKDIR /app
COPY . /app/
RUN ./gradlew clean build

FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=builder app/build/libs/*.jar /app/coding-dashboard.jar
EXPOSE ${PORT}
ENTRYPOINT ["java","-jar","/app/coding-dashboard.jar"]
# Backend: Spring Boot app
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY ./build/libs/TodoApi.jar /app/TodoApi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/TodoApi.jar", "--spring.profiles.active=dev"]

FROM maven:3.8.1-jdk-8 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/MiniRecruitmentApp-1.0-SNAPSHOT.jar /app.jar

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/rekrutment?currentSchema=rekrutment&useSSL=false
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=password12345678

CMD ["java", "-jar", "/app.jar"]
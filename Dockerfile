FROM maven:3.5.4-jdk-8-alpine as build 
COPY  src /app/src
WORKDIR /app/src
RUN mvn clean package

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/src/api/target/shop.jar /app
ENTRYPOINT ["java","-jar","/app/shop.jar"]
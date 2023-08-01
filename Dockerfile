FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/hm_mgt-0.0.1-SNAPSHOT.jar hm_mgt.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","hm_mgt.jar" ]
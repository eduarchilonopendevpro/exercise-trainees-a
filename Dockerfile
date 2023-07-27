#
# Build stage
#
FROM maven:3.8.4-openjdk-17-slim AS build
COPY src 
COPY pom.xml 
RUN mvn -f pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]

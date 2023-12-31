#FROM openjdk:17
#VOLUME /tmp
#ENV IMG_PATH=/img
#EXPOSE 8080
#RUN mkdir -p /img
#ADD ./target/exercise-trainees-a-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]

# Usar una imagen base con JDK 11 y Maven
FROM maven:3.6.3-openjdk-17 AS build

# Establecer un directorio de trabajo
WORKDIR /app

# Copiar archivos de tu proyecto al directorio de trabajo
COPY . /app

# Ejecutar Maven para construir el proyecto
RUN mvn -Dmaven.test.skip=true -DskipTests=true clean package

# Crear una nueva imagen basada en OpenJDK 11
FROM eclipse-temurin:17-jdk

# Exponer el puerto que utilizará la aplicación
EXPOSE 8080

# Copiar el archivo JAR construido desde la etapa anterior
COPY --from=build /app/target/exercise-trainees-a-0.0.1-SNAPSHOT.jar /app/exercise-trainees-a-0.0.1-SNAPSHOT.jar

# Establecer el punto de entrada para ejecutar la aplicación
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/exercise-trainees-a-0.0.1-SNAPSHOT.jar"]
# ENTRYPOINT ["java", "-jar", "/app/exercise-trainees-a-0.0.1-SNAPSHOT.jar"]

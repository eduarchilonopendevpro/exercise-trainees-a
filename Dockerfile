FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

# Use an official Maven runtime as a base image with OpenJDK 17
FROM maven:3.8.4-openjdk-17-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias de Maven de forma aislada
COPY pom.xml .

RUN mvn dependency:go-offline

# Copiar todo el código fuente al contenedor
COPY src/ ./src/

# Compilar la aplicación
RUN mvn package

# Comando para ejecutar la aplicación, ajusta esto según tu configuración
CMD ["java", "-jar", "target/tu-app.jar"]

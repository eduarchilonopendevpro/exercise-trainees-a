FROM openjdk:11

COPY target/exercise-trainees-a-0.0.1-SNAPSHOT.jar exercise-trainees-a-0.0.1-SNAPSHOT.jar.original

ENTRYPOINT ["java", "-jar", "/exercise-trainees-a-0.0.1-SNAPSHOT.jar"]

FROM openjdk:17

ARG JAR_URL=target/*.jar

COPY ${JAR_URL} demo.jar

ENTRYPOINT ["java", "-jar", "/demo.jar"]

EXPOSE 8600
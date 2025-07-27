#FROM openjdk:17-jdk-slim
#WORKDIR /app
#COPY target/springbootdocker-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8081
#ENTRYPOINT ["java", "-jar", "app.jar"]


FROM openjdk:17-jdk-slim
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .
COPY src/ src/
EXPOSE 8080
RUN ./mvnw clean package -DskipTests
COPY target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]

FROM openjdk:8-jdk-alpine

# 1. download gradle wrapper
COPY gradlew /gradle/src/
COPY gradle/wrapper/* /gradle/src/gradle/wrapper/
WORKDIR /gradle/src
ENV GRADLE_USER_HOME=/gradle
RUN ./gradlew --version

# 2. full gradle build
COPY build.gradle* settings.gradle* gradle.properties* /gradle/src/
COPY src /gradle/src/src
RUN ./gradlew --no-daemon build -x test
ENTRYPOINT ["java", "-jar","/gradle/src/build/libs/customer-service-0.0.1-SNAPSHOT.jar"]

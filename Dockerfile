FROM gradle:jdk11-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=build /home/gradle/src/build/libs/route-service-1.0.jar /route-service-1.0.jar
EXPOSE 8080
ENTRYPOINT java -jar /route-service-1.0.jar

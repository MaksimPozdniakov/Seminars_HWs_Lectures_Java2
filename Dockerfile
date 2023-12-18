FROM openjdk:21

COPY out/artifacts/java2_jar/java2.jar /tmp/java2.jar
WORKDIR /tmp
CMD ["java", "-jar", "/tmp/java2.jar"]
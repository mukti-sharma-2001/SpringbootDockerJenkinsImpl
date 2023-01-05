FROM openjdk:11
EXPOSE 8082
ADD target/docker-jenkins-sample-implementation.jar docker-jenkins-sample-implementation.jar
ENTRYPOINT ["java","-jar","/docker-jenkins-sample-implementation.jar"]
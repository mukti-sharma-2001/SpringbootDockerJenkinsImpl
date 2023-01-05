FROM openjdk:11
EXPOSE 8080
ADD target/docker-jenkins-sample-implementation.jar docker-jenkins-sample-implementation
ENTRYPOINT ["java","-jar","/docker-jenkins-sample-implementation.jar"]
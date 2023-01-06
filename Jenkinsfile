pipeline {
    agent any
    tools{
        maven 'M3'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mukti-sharma-2001/SpringbootDockerJenkinsImpl']])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t muktisharma/docker-jenkins-sample-implementation-pipeline .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   	withCredentials([usernameColonPassword(credentialsId: 'docker-id', variable: 'dockerhub-pass')]) {
                   		bat 'docker login -u muktisharma -p ${dockerhub-pass}'
					}
                   	bat 'docker push muktisharma/docker-jenkins-sample-implementation-pipeline'
                }
            }
        }
    }
}
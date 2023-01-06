pipeline {
    agent any
    environment{
    	DOCKERHUB_CREDENTIALS=credentials('docker-sec-pass')
    }
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
                   	bat 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                   	bat 'docker push muktisharma/docker-jenkins-sample-implementation-pipeline'
                }
            }
        }
    }
    post {
        always {
            bat 'docker logout'
        }
    }
}
pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'JDK 17'
    }

    environment {
        IMAGE_NAME = "${DOCKER_HUB_USER}/insertion-service:latest"
    }

    stages {

        stage('Build & Test') {
            steps {
                echo 'Build + Tests...'
                sh 'mvn clean verify'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Construction de l image Docker...'
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Push Docker Image') {
            steps {
                echo 'Push vers Docker Hub...'
                withCredentials([string(credentialsId: 'docker-hub-token', variable: 'TOKEN')]) {
                    sh 'echo $TOKEN | docker login -u $DOCKER_HUB_USER --password-stdin'
                }
                sh 'docker push $IMAGE_NAME'
            }
        }
    }

    post {
        success {
            echo 'Pipeline terminé avec succès !'
        }
        failure {
            echo 'Pipeline échoué !'
        }
    }
    stage('Test Docker') {
        steps {
            sh 'docker version'
        }
    }
}
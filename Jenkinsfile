pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'JDK 17'
    }

    environment {
        DOCKER_IMAGE = "insertion-service:latest"
    }

    stages {

        stage('Build & Test') {
            steps {
                echo 'Build + Tests...'
                sh 'mvn clean verify'
            }
        }

        stage('Docker Version Check') {
            steps {
                sh 'docker version'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Construction image Docker...'
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Login Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'docker-hub',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                sh 'docker tag $DOCKER_IMAGE $DOCKER_USER/insertion-service:latest'
                sh 'docker push $DOCKER_USER/insertion-service:latest'
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
}
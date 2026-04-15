pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'JDK 17'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Compilation du projet Spring Boot...'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo 'Lancement des tests...'
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Construction de l image Docker...'
                sh 'docker build -t $DOCKER_HUB_USER/insertion-service:latest .'
            }
        }

        stage('Push Docker Image') {
            steps {
                echo 'Push vers Docker Hub...'
                sh 'docker login -u $DOCKER_HUB_USER -p $DOCKER_HUB_TOKEN'
                sh 'docker push $DOCKER_HUB_USER/insertion-service:latest'
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

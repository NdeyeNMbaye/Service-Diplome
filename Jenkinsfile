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

        stage('Docker Check (safe)') {
            steps {
                echo 'Docker CLI non disponible dans Jenkins container (skip check)'
            }
        }

        stage('Docker Build (skipped)') {
            steps {
                echo 'Docker build ignoré car Docker CLI absent dans Jenkins container'
            }
        }

        stage('Docker Login (skipped)') {
            steps {
                echo 'Docker login ignoré dans cet environnement'
            }
        }

        stage('Docker Push (skipped)') {
            steps {
                echo 'Docker push ignoré dans cet environnement'
            }
        }
    }

    post {
        success {
            echo 'Pipeline terminé avec succès (Maven OK)'
        }
        failure {
            echo 'Pipeline échoué'
        }
    }
}
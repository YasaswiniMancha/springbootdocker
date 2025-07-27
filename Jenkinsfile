pipeline {
    agent any
    environment {
        DOCKER_IMAGE_APP = "yasaswinigayathrimancha/springbootdocker-app"
        DOCKER_IMAGE_DB1 = "yasaswinigayathrimancha/postgres"
        DOCKER_CREDENTIALS_ID = 'yash'   //we can place any unique identifier we wish to
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build and Test') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build App Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE_APP}:${env.BUILD_ID} ."
            }
        }
        stage('Build DB Images') {
            parallel {
                stage('Build DB1') {
                    steps {
                        sh "docker build -f Dockerfile.db1 -t ${DOCKER_IMAGE_DB1}:${env.BUILD_ID} ."
                    }
                }

            }
        }
        stage('Push Images to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${DOCKER_CREDENTIALS_ID}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh "echo ${DOCKER_PASS} | docker login -u ${DOCKER_USER} --password-stdin"
                    sh "docker push ${DOCKER_IMAGE_APP}:${env.BUILD_ID}"
                    sh "docker push ${DOCKER_IMAGE_DB1}:${env.BUILD_ID}"
                }
            }
        }
        stage('Deploy with Docker Compose') {
            steps {
                sh "sed -i 's/\${BUILD_ID}/${env.BUILD_ID}/g' docker-compose.yml"
                sh "docker-compose up -d"
            }
        }
    }
}
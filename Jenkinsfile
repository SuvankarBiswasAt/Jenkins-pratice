pipeline {
    agent any

    tools {
        maven 'Maven3'   // name from Jenkins Global Tool Configuration
        jdk 'JDK11'      // name from Jenkins Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/your-username/your-repo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished!'
        }
    }
}

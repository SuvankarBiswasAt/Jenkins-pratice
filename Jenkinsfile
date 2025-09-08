pipeline {
    agent any

    tools {
        maven 'Maven3'   // name from Jenkins Global Tool Configuration
        jdk 'JDK11'      // name from Jenkins Global Tool Configuration
    }

    stages {
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
        stage('Deploy') {
            steps {
                sh 'cp target/User.war /usr/local/tomcat/webapps/'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished!'
        }
    }
}

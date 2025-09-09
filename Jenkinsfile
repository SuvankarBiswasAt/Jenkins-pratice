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
        stage('Deploy to Tomcat') {
            steps {
                script {
                    // Find the WAR file
                    def warFile = sh(script: "find target -type f -name '*.war' | head -n 1", returnStdout: true).trim()
                    if (!warFile) {
                        error "No WAR file found!"
                    }

                    // Find Tomcat webapps directory
                    def webappsDir = sh(script: "find / -type d -name 'webapps' 2>/dev/null | head -n 1", returnStdout: true).trim()
                    if (!webappsDir) {
                        error "Tomcat webapps folder not found!"
                    }

                    // Copy WAR into Tomcat
                    sh "cp ${warFile} ${webappsDir}/"

                    echo "✅ Deployed ${warFile} to ${webappsDir}"
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished!'
        }
    }
}

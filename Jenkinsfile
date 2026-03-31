pipeline {
    agent any

    tools {
        maven 'Maven3'   // Name from Jenkins tool config
        jdk 'Java17'     // Name from Jenkins tool config
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/mannepallinarasimha/ems-application.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                cp target/ems-application.war /opt/tomcat/webapps/
                systemctl restart tomcat
                '''
            }
        }
    }
}

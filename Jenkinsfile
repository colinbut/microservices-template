pipeline {
    //agent any
    agent { 
        docker { 
            image 'maven:3.3.3' 
        } 
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
    post {
        always {
            echo 'Build finished.'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            junit 'target/surefire-reports/*.xml'
        }
        success {
            echo 'The build succeeded'
        }
        failure {
            echo 'The build failed'
        }
        unstable {
            echo 'The build was marked unstable'
        }
        changed {
            echo 'The state of the pipeline has changed'
        }
    }
}
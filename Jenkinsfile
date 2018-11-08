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
                sh 'mvn clean compile'
            }
        }
        stage('test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('deploy') {
            steps {
                sh 'mvn package'
            }
        }
    }
    post {
        always {
            echo 'Build finished.'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            junit 'target/surefire-reports/*.xml'
            deleteDir()
        }
        success {
            echo 'The build succeeded'
            
            // Comment/Uncomment the ones you would need/use

            // Send email
            mail to: 'colin.but@email.com',
                 subject: "Passed Pipeline: ${currentBuild.fullDisplayName}",
                 body: "${env.BUILD_URL} - ${env.JOB_NAME} #${env.BUILD_NUMBER} has passed."

            // Atlassian Hipchat Integration
            hipchatSend message: "@here ${currentBuild.fullDisplayName} has successfully completed.", 
                        color: 'GREEN'

            // Slack Integration
            slackSend channel: '#room',
                      color: 'good',
                      message: "The pipeline ${currentBuild.fullDisplayName} has successfully completed."
        }
        failure {
            echo 'The build failed'
            
            mail to: 'colin.but@email.com',
                 subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                 body: "Something went wrong with ${env.BUILD_URL}"

            hipchatSend message: "@here ${env.JOB_NAME} #${env.BUILD_NUMBER} has failed.", 
                        color: 'RED'

            slackSend channel: '#room',
                      color: 'bad',
                      message: "${env.JOB_NAME} #${env.BUILD_NUMBER} has failed."
        }
        unstable {
            echo 'The build was marked unstable'
        }
        changed {
            echo 'The state of the pipeline has changed'
        }
    }
}
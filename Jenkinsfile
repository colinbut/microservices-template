pipeline {
    //agent any
    agent { 
        docker { 
            image 'maven:3.3.3' 
        } 
    }

    /** 
     * Multiple stages that gets run on Jenkins to build & test the merged code
     * This practice is called CI (Continous Integration)
     */
    stages {
        stage('Build') {
            steps {
                sh './mvnw clean compile'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }
        stage('Packaging') {
            steps {
                sh './mvnw package -DskipTests=true'
            }
        }
        stage ('Static Code Analysis') {
            steps {
                // required SonarQube server configured in Jenkins System Configuration
                withSonarQubeEnv(credentialsId: 'sonarqube-credentials', installationName: 'MySonarQubeServer') {
                    sh './mvnw sonar:sonar'
                }
            }
        }
        stage('Deploy - Staging') {
            steps {
                sh './deploy.sh staging'
                sh './run-e2e-tests.sh'
            }
        }

        /**
         * Every successful build of a commit (or merge to be precise) is a RC (Release Candidate).
         * This is known as CD (Continous Delivery)
         */
        stage('Sanity Check') {
            steps {
                input "Does the Staging environment look good?"
            }
        }
        
        /**
         * Automatically deploy to Production environment after running e2e tests on the Staging environment
         * This practice is called CD (Continous Deployment)
         */ 
        stage('Deploy - Production') {
            steps {
                sh './deploy.sh production'
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
            
            // Comment/Uncomment the ones you would need/use

            // Send email
            mail to: 'colin.but@email.com',
                 subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                 body: "Something went wrong with ${env.BUILD_URL}"

            // Atlassian Hipchat Integration
            hipchatSend message: "@here ${env.JOB_NAME} #${env.BUILD_NUMBER} has failed.", 
                        color: 'RED'

            // Slack Integration
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
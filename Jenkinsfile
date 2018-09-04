pipeline {
    agent any

    parameters {
         string(name: 'tomcat_dev', defaultValue: 'localhost:9999', description: 'Staging Server')
         string(name: 'tomcat_prod', defaultValue: 'localhost:9998', description: 'Production Server')
    }

    triggers {
         pollSCM('* * * * *')
     }

stages{
        stage('Build'){
            steps {
                bat 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }

        stage ('Deployments'){
            parallel{
                stage ('Deploy to Staging'){
                    steps {
                        bat "cp **/target/*.war ${params.tomcat_dev}"
                    }
                }

                stage ("Deploy to Production"){
                    steps {
                        bat "cp **/target/*.war ${params.tomcat_prod}"
                    }
                }
            }
        }
    }
}
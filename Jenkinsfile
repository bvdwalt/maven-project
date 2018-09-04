pipeline {
    agent any

    parameters {
         string(name: 'tomcat_dev', defaultValue: 'C:\\Users\\bennie.vdwalt\\Documents\\apache-tomcat-8.5.33-staging\\webapps', description: 'Staging Server')
         string(name: 'tomcat_prod', defaultValue: 'C:\\Users\\bennie.vdwalt\\Documents\\apache-tomcat-8.5.33-production\\webapps', description: 'Production Server')
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
                        bat "xcopy **/target/*.war ${params.tomcat_dev}"
                    }
                }

                stage ("Deploy to Production"){
                    steps {
                        bat "xcopy **/target/*.war ${params.tomcat_prod}"
                    }
                }
            }
        }
    }
}
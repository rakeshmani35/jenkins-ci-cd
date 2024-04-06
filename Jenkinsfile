pipeline {
    agent any

    tools {
        maven "maven"
    }

    stages {

        stage("SCM checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/rakeshmani35/jenkins-ci-cd.git']])
            }
        }

        stage("maven build"){
            steps{
                script{
                    bat 'mvn clean install'
                }
            }
        }

        stage("deploy to tomcat container"){
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-pwd', path: '', url: 'http://localhost:9090/')], contextPath: 'jenkinsCiCd', war: '**/*.war'
            }
        }
    }

    post {
        always {
            emailext attachLog: true, body: '''<html>
<body>
    <p>Build Status : ${BUILD_STATUS}</p>
    <p>Build Number : $(BUILD_NUMBER)</p>
    <p>Check the <a href="${BUILD_URL}"}>console ouptut</a>.</p>
</body>
</html>''', mimeType: 'text/html', replyTo: 'rakeshmani35@gmail.com', subject: 'pipeline Status : ${BUILD_NUMBER}', to: 'rakeshmani35@gmail.com'
        }
    }
}
//SCM checkout
//build
//deploy WAR
//EMAIL
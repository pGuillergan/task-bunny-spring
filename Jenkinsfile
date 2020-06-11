pipeline {
    agent any
	
    environment{
        JENKINS_NODE_COOKIE = 'dontkillme'
        PORT=3000
    } 
    stages{
    
        stage('Download') {
           steps {
              // Download code from a GitHub repository
              // branch: the branch that you want to build
              // credentialsId: the ID of the credentials for your GitLab repo that is being managed by Jenkins
              // url: url to your repo
              git branch: 'master', credentialsId: 'd8d9e999-e44a-4924-950f-f767f4ebbcdd', url: 'https://github.com/pGuillergan/task-bunny-spring.git'
              
           }

        }
            stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            }
    }

}
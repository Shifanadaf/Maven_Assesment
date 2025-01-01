pipeline{
  agent any
  tools{
    maven 'sonarmaven'
  }
  environment{
    JAVA_PATH="C:\\Program Files\\Java\\jdk-17\\bin"
  }
  stages{
    stage('Checkout Code') {
            steps {
                checkout scm
            }
    }
    stage('Build'){
      steps{
      
            bat 'mvn clean install -U'
        }
    }
     
    stage('SonarQube Analysis'){
   environment{
       SONAR_TOKEN=credentials('sonarqube-token')
       MAVEN_HOME="C:\\Program Files\\apache-maven-3.9.9\\bin" 
       PATH="${env.PATH};${env.MAVEN_HOME}\\bin"
   }
   steps{
       bat '''
       set PATH=%JAVA_PATH%;
       set PATH=%MAVEN_HOME%\\bin;%PATH%;
       mvn clean verify sonar:sonar -Dsonar.projectKey=Maven_Assesment -Dsonar.projectName='Maven_Assesment' -Dsonar.source=. -Dsonar.host.url=http://localhost:9000 -Dsonar.token=${SONAR_TOKEN}
       '''
   }
  }
  }
  post{
    success{
      echo "DONE SUCCESSFULLY"
    }
    failure{
      echo "WRONG"
    }
  }
  
}

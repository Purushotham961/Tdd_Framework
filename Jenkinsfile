pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git 'https://github.com/yourusername/yourrepository.git'
        sh 'mvn clean package'
      }
    }
    stage('Run') {
      steps {
        sh 'java -jar target/yourproject.jar'
      }
    }
  }
}

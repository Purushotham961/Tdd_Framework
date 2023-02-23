pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git 'https://github.com/Purushotham961/Tdd_Framework.git'
        sh 'mvn clean package'
      }
    }
    stage('Run') {
      steps {
        sh 'java -jar target/Tdd_Framework.jar'
      }
    }
  }
}

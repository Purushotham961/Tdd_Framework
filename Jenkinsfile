pipeline{
	agent any
	stages{
	stage('Build')
	{
		steps {
       git 'https://github.com/Purushotham961/Tdd_Framework.git'
        sh 'mvn clean package'
	echo "Building the code....."
	bat "mvn clean"
      }
	}
	stage('Test')
	{
		steps{
		echo "Testing the code....."
		bat "mvn test"
		}
	}
	stage('Compile')
	{
		steps{
		echo "Compiling the project....."
		bat "mvn compile"
		}
	}
	stage('Deploy')
	{
	steps{
	echo "Deploying the project....."
	}
	}
	}
}

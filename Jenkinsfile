pipeline{
	agent any
	stages{
	stage('Build')
	{
		steps {
       git 'https://github.com/Purushotham961/Tdd_Framework.git'
	echo "Building the code....."
      }
	}
	stage('Test')
	{
		steps{
		echo "Testing the code....."
	
		}
	}
	stage('Compile')
	{
		steps{
		echo "Compiling the project....."
	
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

node{
	stage('SCM Checkout'){
		git 'https://github.com/Purushotham961/Tdd_Framework.git'
	}
	stage('Compile-Package'){
	def mvnHome = tool name: '', type: 'maven'
	sh "${mvnHome}/bin/mvn package"
	}
}

pipeline {
  agent any

  environment {
    AWS_DEFAULT_REGION = 'us-east-1'
  }

  stages {
    stage('Clone Repo') {
      steps {
        git 'https://github.com/mwaqee/mwfinancial.git'
      }
    }

    stage('Deploy CloudFormation') {
      steps {
        withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-access-key']]) {
          sh '''
            aws cloudformation deploy \
              --template-file cloudformation/s3-bucket.yaml \
              --stack-name my-iac-stack \
              --capabilities CAPABILITY_NAMED_IAM
          '''
        }
      }
    }
  }

  post {
    success {
      echo '✅ Stack deployed successfully.'
    }
    failure {
      echo '❌ Stack deployment failed.'
    }
  }
}

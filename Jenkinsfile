pipeline {
  agent any

  environment {
    AWS_DEFAULT_REGION = 'us-east-1'
  }

  stages {
    stage('Clone Repo') {
      steps {
        git branch: 'main', url: 'https://github.com/mwaqee/mwfinancial.git'
      }
    }

    stage('Deploy CloudFormation') {
      steps {
        script {
          withCredentials([
            string(credentialsId: 'aws-access-key', variable: 'AWS_ACCESS_KEY_ID'),
            string(credentialsId: 'aws-secret-access-key', variable: 'AWS_SECRET_ACCESS_KEY')
          ]) {
            sh '''
              echo "Deploying to region: $AWS_REGION"
              aws configure set aws-access-key $AWS_ACCESS_KEY_ID
              aws configure set aws_secret_access_key $AWS_SECRET_ACCESS_KEY
              aws configure set region $AWS_REGION
              aws cloudformation deploy \
                --region us-east-1 \
                --template-file cloudformation/s3-bucket.yaml \
                --stack-name my-iac-stack \
                --capabilities CAPABILITY_NAMED_IAM
            '''
          }
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

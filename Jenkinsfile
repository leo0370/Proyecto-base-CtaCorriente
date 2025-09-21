pipeline {
  agent any

  tools {
    jdk 'JDK_21'
    maven 'M3'
  }

  environment {
    // Configurado en Jenkins: Manage Jenkins > System > JFrog
    ARTIFACTORY_SERVER = 'Artifactory-Server'
    ARTIFACTORY_REPO   = 'libs-release-local'
  }

  stages {
    stage('Preparación - Checkout') {
      steps {
        checkout([$class: 'GitSCM',
          branches: [[name: '*/main']],
          userRemoteConfigs: [[url: 'https://github.com/<tu-usuario>/CtaCorriente.git', credentialsId: 'github-creds']]
        ])
      }
    }
    stage('Build') {
      steps {
        sh label: 'Build mvn', script: 'mvn -B -DskipTests clean package'
      }
      post {
        success {
          archiveArtifacts artifacts: 'target/*.war', fingerprint: true
        }
      }
    }
    stage('Test') {
      steps {
        sh 'mvn -B test'
      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'
          publishHTML(target: [
            reportName: 'Cucumber',
            reportDir: 'target',
            reportFiles: 'cucumber-report.html',
            keepAll: true, alwaysLinkToLastBuild: true
          ])
        }
      }
    }
    stage('Publicar en Artifactory') {
      steps {
        script {
          def server = Artifactory.server(ARTIFACTORY_SERVER)
          def uploadSpec = """{
            "files": [{
              "pattern": "target/*.war",
              "target": "${ARTIFACTORY_REPO}/com/platinum/CtaCorriente/"
            }]
          }"""
          server.upload(spec: uploadSpec)
        }
      }
    }
  }
  post {
    always {
      echo "Pipeline finalizado"
    }
  }
}

pipeline{
    agent any
    tools{
        maven: 'maven'
    }
    stages{
        stage('Clean up'){
            steps{
                deleteDir()
            }
        }
        stage('Clone repo'){
            steps{
                sh "git clone https://github.com/MohamedAmineDev/tp3-devops-new1.git"
            }
        }
        stage('Generate app image'){
            steps{
                dir('tp3-devops-new1'){
                    sh "mvn clean install"
                    sh "docker build -t my-school-web-app ."
                }
            }
        }
        stage('Run the app'){
            steps{
                dir('tp3-devops-new1'){
                    sh "docker compose up -d"
                }
            }
        }
        stage('Wait for testing'){
            steps{
                dir('tp3-devops-new1'){
                    sh "sleep 50"
                }
            }
        }
        stage('Close the app'){
            steps{
                dir('tp3-devops-new1'){
                    sh "docker compose down"
                }
            }
        }
    }
}
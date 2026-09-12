// Declarative wrapper: checkout, setup, check, optional conventional-commit on PRs.
def call(Map args = [:]) {
    pipeline {
        agent { docker { image args.image ?: 'python:3.12' } }
        stages {
            stage('Setup') { steps { apSetup(language: args.language) } }
            stage('Check') { steps { apCheck(language: args.language) } }
            stage('Commits') {
                when { changeRequest() }
                steps { apConventionalCommit() }
            }
        }
    }
}

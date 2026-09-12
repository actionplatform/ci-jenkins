// Fetch one of the shared scripts from ci-scripts@v1 and run it with the given env.
def call(String name, Map env = [:]) {
    def base = env.remove('AP_SCRIPTS') ?: 'https://raw.githubusercontent.com/actionplatform/ci-scripts/v1'
    def exports = env.collect { k, v -> "export ${k}='${v}'" }.join('\n')
    sh """
        mkdir -p .ap
        curl -fsSL "${base}/lib.sh" -o .ap/lib.sh
        curl -fsSL "${base}/gitflow.sh" -o .ap/gitflow.sh
        curl -fsSL "${base}/${name}.sh" -o ".ap/${name}.sh"
        chmod +x .ap/*.sh
        ${exports}
        .ap/${name}.sh
    """
}

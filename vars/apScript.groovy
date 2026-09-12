// Fetch one of the shared scripts from ci-scripts and run it with the given env.
// Base URL: call map AP_SCRIPTS, then the AP_SCRIPTS job/global env var, then public ci-scripts@v1.
def call(String name, Map vars = [:]) {
    def base = vars.remove('AP_SCRIPTS') ?: env.AP_SCRIPTS ?: 'https://raw.githubusercontent.com/actionplatform/ci-scripts/v1'
    def exports = vars.collect { k, v -> "export ${k}='${"${v}".replace("'", "'\\''")}'" }.join('\n')
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

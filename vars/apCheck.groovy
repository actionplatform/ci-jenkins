def call(Map args = [:]) {
    apScript('check', [AP_LANGUAGE: args.language ?: ''])
}

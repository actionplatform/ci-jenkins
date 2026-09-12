def call(Map args = [:]) {
    apScript('conventional-commit', [AP_BASE: args.base ?: "origin/${env.CHANGE_TARGET ?: 'main'}"])
}

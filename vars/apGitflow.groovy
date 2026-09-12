def call(Map args = [:]) {
    apScript('gitflow-pr', [AP_HEAD: args.head ?: env.CHANGE_BRANCH, AP_BASE: args.base ?: env.CHANGE_TARGET, AP_DEFAULT_BRANCH: args.defaultBranch ?: 'main'])
}

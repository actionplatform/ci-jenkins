def call(Map args = [:]) {
    apScript('release', [AP_TAG: args.tag ?: env.TAG_NAME, AP_FILES: args.files ?: '', AP_BRANCH: args.branch ?: 'main'])
}

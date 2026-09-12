def call(Map args = [:]) {
    apScript('setup', [AP_LANGUAGE: args.language ?: '', AP_INSTALL: (args.install == false) ? 'false' : 'true'])
}

job('NodeJS Example') {
  scm {
      git('git://github.com:kamarja/test-node-cicd.git') { node -> // is hudson.plugins.git.GITSCM
          node / gitConfigName('DSL User')
          node / gitConfigEmail('kamarja@gmail.com')
      }
  }
  triggers {
    scm('H/5 * * * *')
  }
  wrappers {
    nodejs('NodeJS 10.10.0') //Name of the NodeJS installation in Manage->Jenkins->Configure Tools -> NodeJS Installations -> Name
  }
  steps {
    shell("npm install")
  }
}

job('NodeJS Docker example') {
    scm {
        git('git://github.com/kamarja/test-node-cicd.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('kamarja@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('NodeJS 10.10.0') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('kamarja/test-node-cicd')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('07de667e-2367-40d0-a0b9-bc8cbf6119b3')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}

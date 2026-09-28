def call(Map config = [:]) {
    def imageName = config.image ?: error("image is required")
    def imageTag = config.tag ?: env.BUILD_NUMBER
    def dockerfile = config.dockerfile ?: 'Dockerfile'
    def fullImageTag = "${imageName}:${imageTag}"
    
    stage("Docker Build: ${imageName}") {
        echo "Building Docker image: ${fullImageTag}"
        sh "docker build -f ${dockerfile} -t ${fullImageTag} ."
    }
    return fullImageTag
}


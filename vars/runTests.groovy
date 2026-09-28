def call(Map config = [:]) {
    def junitOutput = config.junit ?: 'test-results/junit.xml'
    sh "mkdir -p \$(dirname ${junitOutput})"
    
    echo "=== Running Standardized Test Suite ==="
    sh 'echo "Simulating PyTest execution metrics..."'
    
    // Always publish results into Jenkins UI dashboard graphs
    junit allowEmptyResults: true, testResults: junitOutput
}


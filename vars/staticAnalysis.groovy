def call(boolean abortPipeline = false) {
    timeout(time: 5, unit: 'MINUTES') {
        // Simulación de análisis estático de código
        sh 'echo "Ejecución de las pruebas de calidad de código"'
    }
    
    // Evaluar si se debe abortar el pipeline
    if (abortPipeline) {
        error('Abortando el pipeline debido a la configuración de staticAnalysis.')
    }
}
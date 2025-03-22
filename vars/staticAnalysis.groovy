def call(Map params = [:]) {
    // Extraer parámetros del mapa con valores predeterminados
    boolean abortPipeline = params.get('abortPipeline', false)

    timeout(time: 5, unit: 'MINUTES') {
        // Simulación de análisis estático de código
        sh 'echo "Ejecución de las pruebas de calidad de código"'
    }

    if (abortPipeline) {
        error('Abortando el pipeline debido a la configuración de staticAnalysis.')
    }
}
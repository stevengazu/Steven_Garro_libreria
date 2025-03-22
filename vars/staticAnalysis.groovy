def call(Map params = [:]) {
    // Extraer parámetros del mapa con valores predeterminados
    boolean abortPipeline = params.get('abortPipeline', false)

    // Leer el nombre de la rama desde las variables de entorno de Jenkins
    def branchName = env.BRANCH_NAME ?: 'unknown'

    // Lógica para cortar el pipeline según heurística
    if (abortPipeline) {
        error('Abortando el pipeline debido a la configuración de staticAnalysis (abortPipeline=true).')
    } else if (branchName == 'master') {
        error('Abortando el pipeline porque la rama es "master".')
    } else if (branchName.startsWith('hotfix')) {
        error('Abortando el pipeline porque la rama empieza con "hotfix".')
    } else {
        echo "La rama es '${branchName}', el pipeline continuará."
    }

    timeout(time: 5, unit: 'MINUTES') {
        // Simulación de análisis estático de código
        sh 'echo "Ejecución de las pruebas de calidad de código"'
    }
}
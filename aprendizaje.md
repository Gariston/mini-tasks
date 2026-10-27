# Bitácora de Aprendizaje — Mini Tasks (Sesiones 1, 2 y 3)

## Sesión 1: Dominio y Test Semilla
- **Rojo:** Se creó el test 
ewTaskShouldNotBeCompleted en TaskTest, el cual fallaba por no existir la clase Task.
- **Verde:** Se implementó Task con constructor que inicializa completed = false y genera un UUID identificador.
- **Resultado:** Test en verde.

## Sesión 2: Controladores REST y Pruebas MVC
- **Rojo:** Se crearon las pruebas en TaskControllerTest para verificar el listado en /v1/tasks, creación con código 201 y cabecera Location hacia /v2/tasks/{id}, y código 404 ante IDs inexistentes.
- **Verde:** Se implementó TaskController con gestión de peticiones HTTP mediante ResponseEntity y almacenamiento temporal.
- **Resultado:** Pruebas MockMvc superadas.

## Sesión 3: Capa de Servicio y Reglas de Negocio
- **Rojo:** Se definió el test createStripsTitleEdges en TaskServiceTest exigiendo que cadenas con espacios a los lados como '   Repasar Spring Boot   ' se guarden limpias.
- **Verde:** Se implementó TaskService aplicando String.strip() en la creación de tareas y se refactorizó TaskController para inyectar y delegar en el servicio.
- **Resultado:** Toda la suite de tests en verde.
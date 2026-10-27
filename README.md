# Mini Tasks — Práctica DWES

Proyecto individual desarrollado según los requerimientos de las sesiones 1, 2 y 3 aplicando TDD con Spring Boot.

## Estructura y desarrollo

- **Sesión 1 (Dominio):** Creación de la entidad `Task` con estado inicial `completed = false` validado mediante test unitario inicial.
- **Sesión 2 (Controlador y MockMvc):** Implementación de endpoints REST:
  - `GET /v1/tasks` para el listado de tareas.
  - `POST /v1/tasks` recibiendo `CreateTaskDTO`, devolviendo estado 201 y cabecera `Location` apuntando a `/v2/tasks/{id}`.
  - `GET /v2/tasks/{id}` gestionando respuestas 200 OK y 404 Not Found.
- **Sesión 3 (Servicio):** Separación de la lógica en `TaskService` e implementación de la regla de normalización de títulos mediante TDD para eliminar espacios en los extremos con `strip()`.

## Ejecución de tests

Para compilar el proyecto y ejecutar la batería de pruebas:

```bash
mvn test

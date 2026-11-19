# Modificar Pokémon — PUT

Esta práctica permite recibir el **ID** del Pokémon desde la ruta y los **nuevos datos** desde el cuerpo de la petición.

- Ruta: `PUT /ordenadores/{id}`
- Controller: `@PutMapping("/{id}")`, `@PathVariable int id`, `@Valid @RequestBody OrdenadorRequest`
- Flujo: `OrdenadorController` → `OrdenadorMapper.toCommand(id, request)` → `EditOrdenadorService` → `EditOrdenadorUseCase` → `OrdenadorRepository.getById()` y `save()`. Si no existe el ID, se lanza `OrdenadorNotFoundException`.

## Cómo probarlo

Iniciar `StoreApplication.java` y ejecutar en una terminal:

```bash
curl -i -X PUT http://localhost:8080/ordenadores/1 \
  -H "Content-Type: application/json" \
  -d '{"nombre":"cambiado","tipo":"Electrico","foto":"https://ejemplo.com/pikachu.png","precio":35.5}'
```

Debería de verse los resultados en <http://localhost:8080/ordenadores>.

<img src="./images/modificacionOrdenador.png">



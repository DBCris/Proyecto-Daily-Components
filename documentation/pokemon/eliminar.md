# Eliminar Pokémon — DELETE

La petición identifica el Pokémon que queremos eliminar mediante un parámetro de ruta: `DELETE /ordenadores/{id}`.

- Controller: `@DeleteMapping("/{id}")` y `@PathVariable int id`.
- Flujo: `OrdenadorController` → `DeleteOrdenadorService` → `DeleteOrdenadorUseCase` → `OrdenadorRepository.getById()` y `deleteById()`. Si no existe el ID, se lanza `OrdenadorNotFoundException`.
- Respuesta actual: `204 No Content`.

## Cómo probarlo con curl

Iniciar `StoreApplication.java` y ejecutar:

```bash
curl -i -X DELETE http://localhost:8080/ordenadores/2
```

## Alternativa: formulario HTML

Iniciar `StoreApplication.java` e introducir la siguiente dirección en tu navegador:

<http://localhost:8080/formulario-eliminar-ordenador.html>

Deberías ver el siguiente formulario:

<img src="./images/formularioeliminar.png">

Si hemos eliminado el id de un Pokémon **existente** y vamos a <http://localhost:8080/ordenadores>, deberíamos de ver que el Pokémon que ha tenido ese ID ha sido eliminado.

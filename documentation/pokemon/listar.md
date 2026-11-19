# Listar Pokémon — GET

El listado de prueba muestra tres Pokémon estáticos: Bulbsaur, Charmander y Squirtle.

## Cómo probarlo

1. Iniciar `StoreApplication.java`.
2. Abrir <http://localhost:8080/ordenadores>.
3. El Controller devuelve una página HTML con los tres Pokémon.

<img src="./images/listaOrdenadors.png">

## Cómo funciona

`OrdenadorController` atiende `GET /ordenadores` y llama a `ListOrdenadorService`, que delega en `FindOrdenadorUseCase`. El UseCase consulta `OrdenadorRepository` y devuelve la lista almacenada en `OrdenadorRepositoryMockImpl`. Finalmente, el Controller genera el HTML con `StringBuilder` y un `for-each`.

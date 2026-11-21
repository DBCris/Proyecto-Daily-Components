# Daily-Components

## 1. Datos del proyecto

- **Nombre:** Daily-Components
- **Versión:** 0.0.1-SNAPSHOT
- **Integrantes:**
  - Cristian David Anghel
  - Mauro Díaz Rodríguez
  - Jieke Zhuang

## 2. Contexto

Nuestro proyecto consiste en una aplicación web para gestionar componentes informáticos.

Nos hemos inspirado en páginas como PCComponentes. Está pensada para gestionar un catálogo de componentes, sin funciones de compra o pago aún.

## 3. Requisitos

### Requisitos funcionales

- Crear, consultar, modificar y eliminar componentes.
- Validar los datos introducidos en los formularios.
- Mostrar los errores cuando los datos no son correctos.

### Requisitos no funcionales

- Utilizar Java y Spring Boot.
- Guardar los datos temporalmente en memoria.
- Organizar el código por capas.

## 4. Plan de pruebas

Además de comprobar las operaciones CRUD, queremos probar los siguientes casos:

- Crear un componente sin introducir el nombre.
- Introducir un nombre con espacios, como `Intel Core i5`.
- Introducir un precio negativo o superior a 6000.
- Comprobar que los cambios aparecen en el listado.

Las pruebas realizadas y las capturas se encuentran en los documentos de cada funcionalidad.

## 5. Problemas encontrados

Uno de los problemas fue la validación del nombre, ya que al principio no permitía introducir espacios. Lo cambiamos para poder utilizar nombres como `Intel Core i5`.

También hemos ampliado las opciones del formulario para poder seleccionar distintos tipos de componentes, como CPU, GPU o RAM.


## 6. Fuentes consultadas

- Material de clase sobre desarrollo de aplicaciones web con Java y Spring Boot.

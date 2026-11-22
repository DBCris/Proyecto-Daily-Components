# Gestionar errores con slice common

El slice `common` permite manejar las excepciones de otros slices (como componente o, en el futuro, licencia), por ejemplo `NullPointerException`, evitando implementar la gestión de errores en el slice componente y hacer que los demás slices dependan de él.

```mermaid
flowchart LR
    P[Slice componente<br/>Manejar datos de los componentes] --> E
    E[Slice common<br/>Gestionar excepciones de otros slices]
    T[Slice Licencia<br/>Futuro] ---> E
```
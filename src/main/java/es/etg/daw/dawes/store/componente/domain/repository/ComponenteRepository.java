package es.etg.daw.dawes.store.componente.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.store.componente.domain.model.Componente;

public interface ComponenteRepository extends CRUDRepository<Componente, Integer>{
    public Optional<Componente> getByName(String name);
}
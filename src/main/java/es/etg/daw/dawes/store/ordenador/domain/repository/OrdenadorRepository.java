package es.etg.daw.dawes.store.ordenador.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.store.ordenador.domain.model.Ordenador;

public interface OrdenadorRepository extends CRUDRepository<Ordenador, Integer>{
    public Optional<Ordenador> getByName(String name);
}
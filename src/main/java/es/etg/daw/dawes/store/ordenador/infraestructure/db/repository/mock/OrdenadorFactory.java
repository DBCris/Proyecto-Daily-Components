package es.etg.daw.dawes.store.ordenador.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.store.ordenador.domain.model.Ordenador;

public class OrdenadorFactory {
    

    public static final Map<Integer, Ordenador> getDemoData(){
        Map<Integer, Ordenador> datos = new LinkedHashMap<>();

        datos.put(1, new Ordenador(1, "Bulbsaur","Planta","1", 10, LocalDateTime.now()));
        datos.put(2, new Ordenador(2, "Charmander","Fuego","2", 10, LocalDateTime.now()));
        datos.put(3, new Ordenador(3, "Squirtle","Agua","3", 10, LocalDateTime.now()));


        return datos;
    }
}

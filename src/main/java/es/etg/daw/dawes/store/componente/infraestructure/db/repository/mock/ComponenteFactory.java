package es.etg.daw.dawes.store.componente.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.store.componente.domain.model.Componente;

public class ComponenteFactory {
    

    public static final Map<Integer, Componente> getDemoData(){
        Map<Integer, Componente> datos = new LinkedHashMap<>();

        datos.put(1, new Componente(1, "Lenovo","Sobremesa","1", 1030, LocalDateTime.now()));
        datos.put(2, new Componente(2, "Forgeon","RAM","2", 640, LocalDateTime.now()));
        datos.put(3, new Componente(3, "Windows-10","Licencia","3", 300, LocalDateTime.now()));


        return datos;
    }
}

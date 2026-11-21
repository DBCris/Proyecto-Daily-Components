package es.etg.daw.dawes.store.componente.domain.error.EntityNotFoundException;

import es.etg.daw.dawes.store.common.infraestructure.web.error.EntityNotFoundException;

public class ComponenteNotFoundException extends EntityNotFoundException{
    
    public static final String ENTIDAD = "Componente";

    public ComponenteNotFoundException(){
        super(ENTIDAD);
    }

    public ComponenteNotFoundException(int id){
        super(ENTIDAD, id);
    }
}
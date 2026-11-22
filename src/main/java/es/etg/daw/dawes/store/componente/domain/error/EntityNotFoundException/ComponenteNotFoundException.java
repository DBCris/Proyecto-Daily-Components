package es.etg.daw.dawes.store.componente.domain.error.EntityNotFoundException;

public class ComponenteNotFoundException extends EntityNotFoundException{
    
    public static final String ENTIDAD = "Componente";

    public ComponenteNotFoundException(){
        super(ENTIDAD);
    }

    public ComponenteNotFoundException(int id){
        super(ENTIDAD, id);
    }
}
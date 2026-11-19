package es.etg.daw.dawes.store.ordenador.domain.error.EntityNotFoundException;

public class OrdenadorNotFoundException extends EntityNotFoundException{
    
    public static final String ENTIDAD = "Ordenador";

    public OrdenadorNotFoundException(){
        super(ENTIDAD);
    }

    public OrdenadorNotFoundException(int id){
        super(ENTIDAD, id);
    }
}
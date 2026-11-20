package es.etg.daw.dawes.store.componente.application.usecase;

import java.util.List;

import es.etg.daw.dawes.store.componente.domain.error.EntityNotFoundException.ComponenteNotFoundException;
import es.etg.daw.dawes.store.componente.domain.model.Componente;
import es.etg.daw.dawes.store.componente.domain.repository.ComponenteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class FindComponenteUseCase {

    public ComponenteRepository componenteRepository;
    
    public List<Componente> findAll() {
        
        List<Componente> componentes = componenteRepository.getAll();

        if (componentes.isEmpty())
            throw new ComponenteNotFoundException();
       
        return componenteRepository.getAll();
    }
}

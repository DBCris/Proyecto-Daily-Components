package es.etg.daw.dawes.store.componente.application.usecase;

import java.util.Optional;

import es.etg.daw.dawes.store.componente.domain.error.EntityNotFoundException.ComponenteNotFoundException;
import es.etg.daw.dawes.store.componente.domain.model.Componente;
import es.etg.daw.dawes.store.componente.domain.repository.ComponenteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor   
public class DeleteComponenteUseCase {
    public ComponenteRepository componenteRepository;
    
    public void delete(int id) {

    Optional <Componente> resultado = componenteRepository.getById(id);

        if (resultado.isEmpty())
            throw new ComponenteNotFoundException();
       
    componenteRepository.deleteById(id);
        
    }
}
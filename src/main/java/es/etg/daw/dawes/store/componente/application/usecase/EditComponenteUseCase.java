package es.etg.daw.dawes.store.componente.application.usecase;

import java.util.Optional;

import es.etg.daw.dawes.store.componente.application.command.EditComponenteCommand;
import es.etg.daw.dawes.store.componente.domain.error.EntityNotFoundException.ComponenteNotFoundException;
import es.etg.daw.dawes.store.componente.domain.model.Componente;
import es.etg.daw.dawes.store.componente.domain.repository.ComponenteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class EditComponenteUseCase {

    public ComponenteRepository componenteRepository;
    
    public Componente update(EditComponenteCommand command) {
    Optional <Componente> resultado = componenteRepository.getById(command.id());

    if (resultado.isEmpty()) {
        throw new ComponenteNotFoundException();
    }

    Componente componente = resultado.get();

    componente.setFoto(command.foto());
    componente.setPrecio(command.precio());
    componente.setNombre(command.nombre());
    componente.setTipo(command.tipo());

    return componenteRepository.save(componente);
 
    

    
    }
}


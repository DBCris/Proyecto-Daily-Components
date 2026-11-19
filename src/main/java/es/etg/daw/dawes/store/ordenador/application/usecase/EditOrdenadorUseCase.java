package es.etg.daw.dawes.store.ordenador.application.usecase;

import java.util.Optional;

import es.etg.daw.dawes.store.ordenador.application.command.EditOrdenadorCommand;
import es.etg.daw.dawes.store.ordenador.domain.error.EntityNotFoundException.OrdenadorNotFoundException;
import es.etg.daw.dawes.store.ordenador.domain.model.Ordenador;
import es.etg.daw.dawes.store.ordenador.domain.repository.OrdenadorRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class EditOrdenadorUseCase {

    public OrdenadorRepository ordenadorRepository;
    
    public Ordenador update(EditOrdenadorCommand command) {
    Optional <Ordenador> resultado = ordenadorRepository.getById(command.id());

    if (resultado.isEmpty()) {
        throw new OrdenadorNotFoundException();
    }

    Ordenador ordenador = resultado.get();

    ordenador.setFoto(command.foto());
    ordenador.setPrecio(command.precio());
    ordenador.setNombre(command.nombre());
    ordenador.setTipo(command.tipo());

    return ordenadorRepository.save(ordenador);
 
    

    
    }
}


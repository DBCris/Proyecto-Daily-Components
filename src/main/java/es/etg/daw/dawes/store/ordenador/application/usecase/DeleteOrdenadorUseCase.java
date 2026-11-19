package es.etg.daw.dawes.store.ordenador.application.usecase;

import java.util.Optional;

import es.etg.daw.dawes.store.ordenador.domain.error.EntityNotFoundException.OrdenadorNotFoundException;
import es.etg.daw.dawes.store.ordenador.domain.model.Ordenador;
import es.etg.daw.dawes.store.ordenador.domain.repository.OrdenadorRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor   
public class DeleteOrdenadorUseCase {
    public OrdenadorRepository ordenadorRepository;
    
    public void delete(int id) {

    Optional <Ordenador> resultado = ordenadorRepository.getById(id);

        if (resultado.isEmpty())
            throw new OrdenadorNotFoundException();
       
    ordenadorRepository.deleteById(id);
        
    }
}
package es.etg.daw.dawes.store.ordenador.application.usecase;

import java.util.List;

import es.etg.daw.dawes.store.ordenador.domain.error.EntityNotFoundException.OrdenadorNotFoundException;
import es.etg.daw.dawes.store.ordenador.domain.model.Ordenador;
import es.etg.daw.dawes.store.ordenador.domain.repository.OrdenadorRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class FindOrdenadorUseCase {

    public OrdenadorRepository ordenadorRepository;
    
    public List<Ordenador> findAll() {
        
        List<Ordenador> ordenadores = ordenadorRepository.getAll();

        if (ordenadores.isEmpty())
            throw new OrdenadorNotFoundException();
       
        return ordenadorRepository.getAll();
    }
}

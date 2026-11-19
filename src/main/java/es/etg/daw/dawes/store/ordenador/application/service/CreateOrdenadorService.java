package es.etg.daw.dawes.store.ordenador.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.store.ordenador.application.command.CreateOrdenadorCommand;
import es.etg.daw.dawes.store.ordenador.application.usecase.CreateOrdenadorUseCase;
import es.etg.daw.dawes.store.ordenador.domain.model.Ordenador;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class CreateOrdenadorService {
    
    private final CreateOrdenadorUseCase createOrdenadorUseCase;

    public Ordenador createOrdenador(CreateOrdenadorCommand comando){
        Ordenador ordenador = createOrdenadorUseCase.create(comando);
        return ordenador;
    }
}
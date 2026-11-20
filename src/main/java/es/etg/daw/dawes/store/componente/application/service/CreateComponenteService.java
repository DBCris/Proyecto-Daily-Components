package es.etg.daw.dawes.store.componente.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.store.componente.application.command.CreateComponenteCommand;
import es.etg.daw.dawes.store.componente.application.usecase.CreateComponenteUseCase;
import es.etg.daw.dawes.store.componente.domain.model.Componente;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class CreateComponenteService {
    
    private final CreateComponenteUseCase createComponenteUseCase;

    public Componente createComponente(CreateComponenteCommand comando){
        Componente componente = createComponenteUseCase.create(comando);
        return componente;
    }
}
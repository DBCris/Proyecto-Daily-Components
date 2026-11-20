package es.etg.daw.dawes.store.componente.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.store.componente.application.command.EditComponenteCommand;
import es.etg.daw.dawes.store.componente.application.usecase.EditComponenteUseCase;
import es.etg.daw.dawes.store.componente.domain.model.Componente;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditComponenteService {
    private final EditComponenteUseCase editComponenteUseCase;

    public Componente update(EditComponenteCommand command) {
        return editComponenteUseCase.update(command);
    }
}

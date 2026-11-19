package es.etg.daw.dawes.store.ordenador.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.store.ordenador.application.command.EditOrdenadorCommand;
import es.etg.daw.dawes.store.ordenador.application.usecase.EditOrdenadorUseCase;
import es.etg.daw.dawes.store.ordenador.domain.model.Ordenador;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditOrdenadorService {
    private final EditOrdenadorUseCase editOrdenadorUseCase;

    public Ordenador update(EditOrdenadorCommand command) {
        return editOrdenadorUseCase.update(command);
    }
}

package es.etg.daw.dawes.store.componente.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.store.componente.application.usecase.DeleteComponenteUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteComponenteService {

    private final DeleteComponenteUseCase deleteComponenteUseCase;

    public void delete(int id) {
        deleteComponenteUseCase.delete(id);
    }
}

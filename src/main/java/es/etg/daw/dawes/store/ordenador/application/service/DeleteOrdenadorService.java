package es.etg.daw.dawes.store.ordenador.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.store.ordenador.application.usecase.DeleteOrdenadorUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteOrdenadorService {

    private final DeleteOrdenadorUseCase deleteOrdenadorUseCase;

    public void delete(int id) {
        deleteOrdenadorUseCase.delete(id);
    }
}

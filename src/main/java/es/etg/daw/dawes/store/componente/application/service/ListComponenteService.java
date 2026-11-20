package es.etg.daw.dawes.store.componente.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.store.componente.application.usecase.FindComponenteUseCase;
import es.etg.daw.dawes.store.componente.domain.model.Componente;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class ListComponenteService {
    private final FindComponenteUseCase findComponenteUseCase;

    public List<Componente> listarComponentes() {
        List<Componente> componentes = findComponenteUseCase.findAll();
        return componentes;
    }
}

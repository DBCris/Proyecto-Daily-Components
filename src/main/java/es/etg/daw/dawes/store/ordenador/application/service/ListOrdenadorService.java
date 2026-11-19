package es.etg.daw.dawes.store.ordenador.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.store.ordenador.application.usecase.FindOrdenadorUseCase;
import es.etg.daw.dawes.store.ordenador.domain.model.Ordenador;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class ListOrdenadorService {
    private final FindOrdenadorUseCase findOrdenadorUseCase;

    public List<Ordenador> listarOrdenadors() {
        List<Ordenador> ordenadores = findOrdenadorUseCase.findAll();
        return ordenadores;
    }
}

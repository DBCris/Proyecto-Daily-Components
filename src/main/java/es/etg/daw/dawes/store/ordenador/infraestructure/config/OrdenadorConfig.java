package es.etg.daw.dawes.store.ordenador.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.store.ordenador.application.usecase.CreateOrdenadorUseCase;
import es.etg.daw.dawes.store.ordenador.application.usecase.DeleteOrdenadorUseCase;
import es.etg.daw.dawes.store.ordenador.application.usecase.EditOrdenadorUseCase;
import es.etg.daw.dawes.store.ordenador.application.usecase.FindOrdenadorUseCase;
import es.etg.daw.dawes.store.ordenador.domain.repository.OrdenadorRepository;
import lombok.RequiredArgsConstructor;

@Configuration 
@RequiredArgsConstructor 
public class OrdenadorConfig {

    private final OrdenadorRepository ordenadorRepository;

    @Bean 
    public CreateOrdenadorUseCase createOrdenadorUseCase(){
        return new CreateOrdenadorUseCase(ordenadorRepository);
    }


    @Bean
    public DeleteOrdenadorUseCase deleteOrdenadorUseCase() {
        return new DeleteOrdenadorUseCase(ordenadorRepository);
    }


    @Bean 
    public EditOrdenadorUseCase editOrdenadorUseCase() {
        return new EditOrdenadorUseCase(ordenadorRepository);
    } 


    @Bean 
    public FindOrdenadorUseCase findOrdenadorUseCase() {
        return new FindOrdenadorUseCase(ordenadorRepository);
    }

}
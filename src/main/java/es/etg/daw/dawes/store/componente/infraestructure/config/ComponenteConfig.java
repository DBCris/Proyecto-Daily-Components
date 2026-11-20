package es.etg.daw.dawes.store.componente.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.store.componente.application.usecase.CreateComponenteUseCase;
import es.etg.daw.dawes.store.componente.application.usecase.DeleteComponenteUseCase;
import es.etg.daw.dawes.store.componente.application.usecase.EditComponenteUseCase;
import es.etg.daw.dawes.store.componente.application.usecase.FindComponenteUseCase;
import es.etg.daw.dawes.store.componente.domain.repository.ComponenteRepository;
import lombok.RequiredArgsConstructor;

@Configuration 
@RequiredArgsConstructor 
public class ComponenteConfig {

    private final ComponenteRepository componenteRepository;

    @Bean 
    public CreateComponenteUseCase createComponenteUseCase(){
        return new CreateComponenteUseCase(componenteRepository);
    }


    @Bean
    public DeleteComponenteUseCase deleteComponenteUseCase() {
        return new DeleteComponenteUseCase(componenteRepository);
    }


    @Bean 
    public EditComponenteUseCase editComponenteUseCase() {
        return new EditComponenteUseCase(componenteRepository);
    } 


    @Bean 
    public FindComponenteUseCase findComponenteUseCase() {
        return new FindComponenteUseCase(componenteRepository);
    }

}
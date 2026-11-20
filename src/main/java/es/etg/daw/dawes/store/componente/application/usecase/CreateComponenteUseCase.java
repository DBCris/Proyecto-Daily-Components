package es.etg.daw.dawes.store.componente.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.store.componente.application.command.CreateComponenteCommand;
import es.etg.daw.dawes.store.componente.domain.model.Componente;
import es.etg.daw.dawes.store.componente.domain.repository.ComponenteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateComponenteUseCase {

    public ComponenteRepository componenteRepository;

    public Componente create( CreateComponenteCommand comando){
        
        Componente componente = Componente.builder()
                                 .nombre(comando.nombre())
                                 .tipo(comando.tipo())
                                 .foto(comando.foto())
                                 .precio(comando.precio())
                                 .createdAt(LocalDateTime.now()).build();

        return componenteRepository.save(componente);
    }
}
    



    

package es.etg.daw.dawes.store.ordenador.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.store.ordenador.application.command.CreateOrdenadorCommand;
import es.etg.daw.dawes.store.ordenador.domain.model.Ordenador;
import es.etg.daw.dawes.store.ordenador.domain.repository.OrdenadorRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateOrdenadorUseCase {

    public OrdenadorRepository ordenadorRepository;

    public Ordenador create( CreateOrdenadorCommand comando){
        
        Ordenador ordenador = Ordenador.builder()
                                 .nombre(comando.nombre())
                                 .tipo(comando.tipo())
                                 .foto(comando.foto())
                                 .precio(comando.precio())
                                 .createdAt(LocalDateTime.now()).build();

        return ordenadorRepository.save(ordenador);
    }
}
    



    

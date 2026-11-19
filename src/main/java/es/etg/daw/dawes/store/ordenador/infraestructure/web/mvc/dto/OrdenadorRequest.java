package es.etg.daw.dawes.store.ordenador.infraestructure.web.mvc.dto;

import es.etg.daw.dawes.store.ordenador.infraestructure.web.validation.NombradoOrdenador;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record OrdenadorRequest(
    
    @NotBlank (message = "{ordenador.valid.nombre.no_vacio}")
    @NombradoOrdenador (message = "{ordenador.valid.nombre.nombrado_validation}")
    String nombre, 

    @NotBlank (message = "{ordenador.valid.tipo.no_vacio}")
    String tipo, String foto, 
    @Min(value=0, message = "{ordenador.valid.precio.min}")
    @Max(value = 100, message = "{ordenador.valid.precio.max}")
    double precio) { 

}

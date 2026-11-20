package es.etg.daw.dawes.store.componente.infraestructure.web.mvc.dto;

import es.etg.daw.dawes.store.componente.infraestructure.web.validation.NombradoComponente;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ComponenteRequest(
    
    @NotBlank (message = "{componente.valid.nombre.no_vacio}")
    @NombradoComponente (message = "{componente.valid.nombre.nombrado_validation}")
    String nombre, 

    @NotBlank (message = "{componente.valid.tipo.no_vacio}")
    String tipo, String foto, 
    @Min(value=0, message = "{componente.valid.precio.min}")
    @Max(value = 6000, message = "{componente.valid.precio.max}")
    double precio) { 

}

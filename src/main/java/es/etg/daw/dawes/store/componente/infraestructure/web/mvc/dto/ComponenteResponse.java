package es.etg.daw.dawes.store.componente.infraestructure.web.mvc.dto;

import java.time.LocalDateTime;

public record ComponenteResponse(int id, String nombre, String tipo, String foto, 
    double precio, LocalDateTime createdAt ) {
    
}
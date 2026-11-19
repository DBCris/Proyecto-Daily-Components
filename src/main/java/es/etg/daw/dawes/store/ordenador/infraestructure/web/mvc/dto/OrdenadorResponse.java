package es.etg.daw.dawes.store.ordenador.infraestructure.web.mvc.dto;

import java.time.LocalDateTime;

public record OrdenadorResponse(int id, String nombre, String tipo, String foto, 
    double precio, LocalDateTime createdAt ) {
    
}
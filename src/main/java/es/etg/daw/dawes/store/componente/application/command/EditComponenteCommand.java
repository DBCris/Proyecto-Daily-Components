package es.etg.daw.dawes.store.componente.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditComponenteCommand {

    private int id;
    private String foto;
    private double precio;
    private String nombre;
    private String tipo;
}

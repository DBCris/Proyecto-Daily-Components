package es.etg.daw.dawes.store.ordenador.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditOrdenadorCommand {

    private int id;
    private String foto;
    private double precio;
    private String nombre;
    private String tipo;
}

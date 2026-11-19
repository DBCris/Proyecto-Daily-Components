package es.etg.daw.dawes.store.ordenador.infraestructure.web.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.HtmlUtils;

import es.etg.daw.dawes.store.ordenador.application.command.CreateOrdenadorCommand;
import es.etg.daw.dawes.store.ordenador.application.command.EditOrdenadorCommand;
import es.etg.daw.dawes.store.ordenador.application.service.CreateOrdenadorService;
import es.etg.daw.dawes.store.ordenador.application.service.DeleteOrdenadorService;
import es.etg.daw.dawes.store.ordenador.application.service.EditOrdenadorService;
import es.etg.daw.dawes.store.ordenador.application.service.ListOrdenadorService;
import es.etg.daw.dawes.store.ordenador.domain.model.Ordenador;
import es.etg.daw.dawes.store.ordenador.infraestructure.mapper.OrdenadorMapper;
import es.etg.daw.dawes.store.ordenador.infraestructure.web.mvc.dto.OrdenadorRequest;
import es.etg.daw.dawes.store.ordenador.infraestructure.web.mvc.dto.OrdenadorResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller 
@RequestMapping ("/ordenadores")
@RequiredArgsConstructor 

public class OrdenadorController {

    private final CreateOrdenadorService createOrdenadorService;
    private final ListOrdenadorService listOrdenadorService;
    private final DeleteOrdenadorService deleteOrdenadorService;
    private final EditOrdenadorService editOrdenadorService;

    private final OrdenadorMapper ordenadorMapper;
    
    @GetMapping
    @ResponseBody 
    public String listOrdenador() {

        List<Ordenador> ordenadores = listOrdenadorService.listarOrdenadors();

      StringBuilder html = new StringBuilder();
      html.append(
        """
        <html>
          <body>
        """
      );

      for (Ordenador ordenador : ordenadores) {
          html.append(
            """
              <div>
                <p>ID: %s</p>
                <p>Nombre: %s</p>
                <p>Tipo: %s</p>
                <p>Precio: %s</p>
                <p>Fecha creada: %s</p>
              </div>
            """.formatted(ordenador.getId(), ordenador.getNombre(), ordenador.getTipo(), ordenador.getPrecio(), ordenador.getCreatedAt())
          );
      }
      html.append(
          """
                  </body>
              </html>
          """
          
      );
      return html.toString();
    }

    @PostMapping
    @ResponseBody
    public String createOrdenador(
                        @Valid
                        OrdenadorRequest request) {
        CreateOrdenadorCommand commando = ordenadorMapper.toCommand(request);

        Ordenador ordenador = createOrdenadorService.createOrdenador(commando);
        
        return """
            <!DOCTYPE html>
            <html lang="es">
              <head>
                <meta charset="UTF-8">
                <title>Ordenador</title>
              </head>
              <body>
                <h1>Ordenador: %s - %s</h1>
                <p>Tipo: %s </p>
                <p>Precio: %s </p>
                <p>Creado el: %s </p>
              </body>
            </html>
            """.formatted(ordenador.getId(), ordenador.getNombre(), ordenador.getTipo(), ordenador.getPrecio(), ordenador.getCreatedAt());
    }

    @DeleteMapping ("/{id}")
    @ResponseBody 
    public ResponseEntity<?> deleteOrdenador(@PathVariable int id){
        deleteOrdenadorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ResponseBody 
    public OrdenadorResponse editOrdenador(@PathVariable int id, @Valid @RequestBody OrdenadorRequest ordenadorRequest){
        EditOrdenadorCommand comando = ordenadorMapper.toCommand(id, ordenadorRequest);
        Ordenador ordenador = editOrdenadorService.update(comando);
        return  ordenadorMapper.toResponse(ordenador); //Respuesta
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public String handleValidationExceptions(MethodArgumentNotValidException ex) {

        StringBuilder html = new StringBuilder(256);
        html.append("<!DOCTYPE html>")
            .append("<html lang=\"es\"><head><meta charset=\"UTF-8\">")
            .append("<title>Errores de validación</title></head><body>")
            .append("<h1>Errores de validación</h1>")
            .append("<ul>");

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field   = (error instanceof FieldError fe) ? fe.getField() : error.getObjectName();
            String message = error.getDefaultMessage();

            html.append("<li><strong>")
                .append(HtmlUtils.htmlEscape(field))
                .append("</strong>: ")
                .append(HtmlUtils.htmlEscape(message))
                .append("</li>");
        });

        html.append("</ul></body></html>");
        return html.toString();
    }
}
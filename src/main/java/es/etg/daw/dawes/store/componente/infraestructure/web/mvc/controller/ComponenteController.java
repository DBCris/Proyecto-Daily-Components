package es.etg.daw.dawes.store.componente.infraestructure.web.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.HtmlUtils;

import es.etg.daw.dawes.store.componente.application.command.CreateComponenteCommand;
import es.etg.daw.dawes.store.componente.application.command.EditComponenteCommand;
import es.etg.daw.dawes.store.componente.application.service.CreateComponenteService;
import es.etg.daw.dawes.store.componente.application.service.DeleteComponenteService;
import es.etg.daw.dawes.store.componente.application.service.EditComponenteService;
import es.etg.daw.dawes.store.componente.application.service.ListComponenteService;
import es.etg.daw.dawes.store.componente.domain.model.Componente;
import es.etg.daw.dawes.store.componente.infraestructure.mapper.ComponenteMapper;
import es.etg.daw.dawes.store.componente.infraestructure.web.mvc.dto.ComponenteRequest;
import es.etg.daw.dawes.store.componente.infraestructure.web.mvc.dto.ComponenteResponse;
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
@RequestMapping ("/componentes")
@RequiredArgsConstructor 

public class ComponenteController {

    private final CreateComponenteService createComponenteService;
    private final ListComponenteService listComponenteService;
    private final DeleteComponenteService deleteComponenteService;
    private final EditComponenteService editComponenteService;

    private final ComponenteMapper componenteMapper;
    
    @GetMapping
    @ResponseBody 
    public String listComponente() {

        List<Componente> componentes = listComponenteService.listarComponentes();

      StringBuilder html = new StringBuilder();
      html.append(
        """
        <html>
          <body>
        """
      );

      for (Componente componente : componentes) {
          html.append(
            """
              <div>
                <p>ID: %s</p>
                <p>Nombre: %s</p>
                <p>Tipo: %s</p>
                <p>Precio: %s</p>
                <p>Fecha creada: %s</p>
              </div>
            """.formatted(componente.getId(), componente.getNombre(), componente.getTipo(), componente.getPrecio(), componente.getCreatedAt())
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
    public String createComponente(
                        @Valid
                        ComponenteRequest request) {
        CreateComponenteCommand commando = componenteMapper.toCommand(request);

        Componente componente = createComponenteService.createComponente(commando);
        
        return """
            <!DOCTYPE html>
            <html lang="es">
              <head>
                <meta charset="UTF-8">
                <title>Componente</title>
              </head>
              <body>
                <h1>Componente: %s - %s</h1>
                <p>Tipo: %s </p>
                <p>Precio: %s </p>
                <p>Creado el: %s </p>
              </body>
            </html>
            """.formatted(componente.getId(), componente.getNombre(), componente.getTipo(), componente.getPrecio(), componente.getCreatedAt());
    }

    @DeleteMapping ("/{id}")
    @ResponseBody 
    public ResponseEntity<?> deleteComponente(@PathVariable int id){
        deleteComponenteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ResponseBody 
    public ComponenteResponse editComponente(@PathVariable int id, @Valid @RequestBody ComponenteRequest componenteRequest){
        EditComponenteCommand comando = componenteMapper.toCommand(id, componenteRequest);
        Componente componente = editComponenteService.update(comando);
        return  componenteMapper.toResponse(componente); //Respuesta
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
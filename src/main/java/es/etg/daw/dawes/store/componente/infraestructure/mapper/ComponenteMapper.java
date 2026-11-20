package es.etg.daw.dawes.store.componente.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.etg.daw.dawes.store.componente.application.command.CreateComponenteCommand;
import es.etg.daw.dawes.store.componente.application.command.EditComponenteCommand;
import es.etg.daw.dawes.store.componente.domain.model.Componente;
import es.etg.daw.dawes.store.componente.infraestructure.web.mvc.dto.ComponenteRequest;
import es.etg.daw.dawes.store.componente.infraestructure.web.mvc.dto.ComponenteResponse;


@Mapper(componentModel = "spring")
public interface ComponenteMapper {

    CreateComponenteCommand toCommand(ComponenteRequest request);

    ComponenteResponse toResponse(Componente componente);

    @Mapping(source = "id", target = "id")
    EditComponenteCommand toCommand(int id, ComponenteRequest request);
}
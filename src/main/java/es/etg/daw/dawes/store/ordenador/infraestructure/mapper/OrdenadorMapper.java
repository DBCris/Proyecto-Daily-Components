package es.etg.daw.dawes.store.ordenador.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.etg.daw.dawes.store.ordenador.application.command.CreateOrdenadorCommand;
import es.etg.daw.dawes.store.ordenador.application.command.EditOrdenadorCommand;
import es.etg.daw.dawes.store.ordenador.domain.model.Ordenador;
import es.etg.daw.dawes.store.ordenador.infraestructure.web.mvc.dto.OrdenadorRequest;
import es.etg.daw.dawes.store.ordenador.infraestructure.web.mvc.dto.OrdenadorResponse;


@Mapper(componentModel = "spring")
public interface OrdenadorMapper {

    CreateOrdenadorCommand toCommand(OrdenadorRequest request);

    OrdenadorResponse toResponse(Ordenador ordenador);

    @Mapping(source = "id", target = "id")
    EditOrdenadorCommand toCommand(int id, OrdenadorRequest request);
}
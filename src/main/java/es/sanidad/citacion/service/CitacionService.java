package es.sanidad.citacion.service;

import es.sanidad.citacion.entity.Citacion;
import es.sanidad.citacion.model.CitacionBusquedaDto;
import es.sanidad.citacion.model.CitacionCreacionDto;
import es.sanidad.citacion.model.CitacionListadoDto;
import java.util.List;

public interface CitacionService {

  List<CitacionListadoDto> busquedaCitacion(CitacionBusquedaDto citacionBusquedaDto);

  List<CitacionListadoDto> busquedaTodasCitaciones();

  Citacion creacionCitacion(CitacionCreacionDto citacionCreacionDto);

}

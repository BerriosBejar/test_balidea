package es.sanidad.citacion.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CitacionBusquedaDto {

  private String observacion;

  private Boolean urgente;

  private String doctor;

}

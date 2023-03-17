package es.sanidad.citacion.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CitacionListadoDto {

  private Integer id;
  private String horaCita;
  private String notificacionPdf;
  private String observacion;
  private String urgente;
  private String datosDoctor;

}

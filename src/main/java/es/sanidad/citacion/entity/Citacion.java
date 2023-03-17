package es.sanidad.citacion.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "citacion")
public class Citacion {

  @Id
  private Integer id;
  private Timestamp horaCita;
  private String observacion;
  private Boolean urgente;
  private Boolean notificacionPdf;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "doctor", referencedColumnName = "id", nullable = false)
  private Doctor doctor;

}

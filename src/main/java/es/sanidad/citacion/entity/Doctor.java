package es.sanidad.citacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {

  @Id
  @Column
  private Integer id;

  private String nombres;

  private String apellido;

  private Integer especialidad;



}

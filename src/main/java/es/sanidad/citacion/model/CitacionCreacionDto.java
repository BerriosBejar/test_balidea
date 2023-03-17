package es.sanidad.citacion.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
public class CitacionCreacionDto {

    @NotNull(message = "The id is required.")
    private Integer id;
    @NotNull(message = "The horaCita is required.")
    private Timestamp horaCita;
    @NotNull(message = "The notificacionPdf is required.")
    private Boolean notificacionPdf;
    @NotNull(message = "The observacion is required.")
    private String observacion;
    @NotNull(message = "The urgente is required.")
    private Boolean urgente;
    @NotNull(message = "The doctorApellido is required.")
    private String doctorApellido;
}


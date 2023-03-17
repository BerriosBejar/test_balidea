package es.sanidad.citacion.mapper;

import es.sanidad.citacion.entity.Citacion;
import es.sanidad.citacion.entity.Doctor;
import es.sanidad.citacion.model.CitacionCreacionDto;
import es.sanidad.citacion.model.CitacionListadoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Mapper(componentModel = "spring")
public interface CitacionMapper {


  @Mapping(source = "notificacionPdf", target = "notificacionPdf", qualifiedByName = "booleanToString")
  @Mapping(source = "doctor", target = "datosDoctor", qualifiedByName = "doctorToDatosDoctor")
  @Mapping(source = "horaCita", target = "horaCita", qualifiedByName = "horaToHoraFormat")
  CitacionListadoDto toDto(Citacion citacion);

  Citacion toCitacionEntity(CitacionCreacionDto citacionCreacionDto);

  @Named("horaToHoraFormat")
  public static String horaToHoraFormat (Timestamp horaCita) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    Date date = new Date(horaCita.getTime());
    return sdf.format(date);
  }

  @Named("doctorToDatosDoctor")
  public static String doctorToDatosDoctor (Doctor doctor){
    return doctor.getNombres().toString() + " " + doctor.getApellido();
  }
  @Named("booleanToString")
  public static String booleanToString (Boolean notificacionPdf){
    if (notificacionPdf) {
      return "Si";
    }
    return "No";
  }

}

package es.sanidad.citacion.service.impl;

import es.sanidad.citacion.entity.Citacion;
import es.sanidad.citacion.entity.Doctor;
import es.sanidad.citacion.mapper.CitacionMapper;
import es.sanidad.citacion.model.CitacionBusquedaDto;
import es.sanidad.citacion.model.CitacionCreacionDto;
import es.sanidad.citacion.model.CitacionListadoDto;
import es.sanidad.citacion.repository.CitacionRepository;
import es.sanidad.citacion.repository.DoctorRepository;
import es.sanidad.citacion.service.CitacionService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@RequiredArgsConstructor
public class CitacionServiceImpl implements CitacionService {

  private final CitacionRepository citacionRepository;
  private final DoctorRepository doctorRepository;
  private final CitacionMapper citacionMapper;

  @PersistenceContext
  EntityManager entityManager;


  @Override
  public List<CitacionListadoDto> busquedaCitacion(CitacionBusquedaDto dto) {
    return citacionRepository.findByUrgente(dto.getUrgente())
            .stream()
            .filter(citacion -> citacion.getDoctor().getApellido().equals(dto.getDoctor()) &&
                    citacion.getObservacion().toLowerCase().contains(dto.getObservacion().toLowerCase()))
            .map(citacionMapper::toDto).collect(
                    Collectors.toList());
  }



  @Override
  public List<CitacionListadoDto> busquedaTodasCitaciones() {
    return citacionRepository.findAll().
        stream().map(citacionMapper::toDto).collect(
        Collectors.toList());
  }

  @Override
  public Citacion creacionCitacion(CitacionCreacionDto citacionCreacionDto) {
    Citacion citacion =citacionMapper.toCitacionEntity(citacionCreacionDto);
    Citacion citacion3=new Citacion();
    citacion.setId(citacion3.getId());
    Doctor doctor=findDoctorPorApellido(citacionCreacionDto.getDoctorApellido());
    if(doctor!=null){
      citacion.setDoctor(doctor);

    }
    return citacionRepository.save(citacion);
  }


  private Doctor findDoctorPorApellido(String doctor) {
    return doctorRepository.findByApellido(doctor);
  }
}

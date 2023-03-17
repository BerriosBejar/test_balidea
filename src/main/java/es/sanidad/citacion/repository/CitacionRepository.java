package es.sanidad.citacion.repository;

import es.sanidad.citacion.entity.Citacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CitacionRepository extends JpaRepository<Citacion, Integer> {


  List<Citacion> findByObservacionLikeAndUrgente(String observacion, Boolean urgente);

  List<Citacion> findByUrgente(Boolean urgente);



}

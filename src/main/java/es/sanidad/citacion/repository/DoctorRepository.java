package es.sanidad.citacion.repository;

import es.sanidad.citacion.entity.Citacion;
import es.sanidad.citacion.entity.Doctor;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

  @Query(value="SELECT * FROM doctor q WHERE q.apellido LIKE :dato limit 1",nativeQuery=true)
  Doctor findByApellido(@Param(value = "dato") String dato);

}

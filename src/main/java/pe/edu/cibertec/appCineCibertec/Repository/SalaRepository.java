package pe.edu.cibertec.appCineCibertec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.appCineCibertec.Model.bd.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {

}

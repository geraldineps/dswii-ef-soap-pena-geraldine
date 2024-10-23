package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}

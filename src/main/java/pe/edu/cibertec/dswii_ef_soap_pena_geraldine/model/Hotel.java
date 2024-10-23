package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_hotel;
    private String  nombre;
    private String  direccion;
    private String  ciudad;
    private Integer id_pais;
}

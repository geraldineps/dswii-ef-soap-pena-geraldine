package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pais;
    private String nombre;
}

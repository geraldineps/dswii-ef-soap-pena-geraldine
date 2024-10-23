package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "habitacion")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_habitacion;
    private String  numero;
    private String  tipo;
    private Double  precio;
    private Integer id_hotel;
}

package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;
    private String  nombre;
    private String  email;
    private String  telefono;
    private Integer id_pais;
}

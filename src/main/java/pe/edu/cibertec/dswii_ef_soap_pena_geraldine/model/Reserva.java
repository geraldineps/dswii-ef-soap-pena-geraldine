package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha_reserva;
    private Date fecha_ingreso;
    private Date fecha_salida;
    private Integer id_cliente;
    private Integer id_habitacion;
}

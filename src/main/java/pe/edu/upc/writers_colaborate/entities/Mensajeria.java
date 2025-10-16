package pe.edu.upc.writers_colaborate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="mensajerias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mensajeria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Issue;
    private String Message;
    private LocalDate ShippingDate;
    private Boolean State;

}

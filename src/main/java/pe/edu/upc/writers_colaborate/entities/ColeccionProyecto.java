package pe.edu.upc.writers_colaborate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name="colecciones_proyectos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColeccionProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate AsignmentDate;
    private Integer Amount;
    private String Description;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="coleccion_id")
    private Coleccion coleccion;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="proyecto_id")
    private Proyecto proyecto;
}

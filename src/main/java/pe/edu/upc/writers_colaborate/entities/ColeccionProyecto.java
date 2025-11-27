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

    private LocalDate asignmentDate;
    private Integer amount;
    private String description;

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

    @Override
    public String toString() {
        return "ColeccionProyecto{" +
                "id=" + id +
                ", AsignmentDate='" + asignmentDate + '\'' +
                ", Amount='" + amount + '\'' +
                ", Description=" + description +
                '}';
    }
}

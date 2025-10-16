package pe.edu.upc.writers_colaborate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name="proyectos_generos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoGenero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate AsignmentDate;
    private String Main;
    private String Sub;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="proyecto_id")
    private Proyecto proyecto;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="genero_id")
    private Genero genero;
}

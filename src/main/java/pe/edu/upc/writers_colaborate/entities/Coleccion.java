package pe.edu.upc.writers_colaborate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="colecciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Title;
    private String Creator;
    private String Type;
    private String Description;
    private LocalDate CreationDate;
    private Boolean Enabled;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "Coleccion", fetch = FetchType.EAGER)
    private List<ColeccionProyecto> colecciones_proyectos;
}

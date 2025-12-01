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

    private String title;
    private String creator;
    private String type;
    private String description;
    private LocalDate creationDate;
    private Boolean enabled;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "coleccion", fetch = FetchType.EAGER)
    private List<ColeccionProyecto> colecciones_proyectos;

    @Override
    public String toString() {
        return "Coleccion{" +
                "id=" + id +
                ", Title='" + title + '\'' +
                ", Creator='" + creator + '\'' +
                ", Type=" + type +
                ", Description=" + description +
                ", CreationDate=" + creationDate +
                ", Enabled=" + enabled +
                '}';
    }
}

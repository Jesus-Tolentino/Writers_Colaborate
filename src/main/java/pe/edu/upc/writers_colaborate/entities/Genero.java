package pe.edu.upc.writers_colaborate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="generos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "genero", fetch = FetchType.EAGER)
    private List<ProyectoGenero> proyectos_generos;

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Description='" + description + '\'' +
                '}';
    }
}

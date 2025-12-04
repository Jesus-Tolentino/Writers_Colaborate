package pe.edu.upc.writers_colaborate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name="colaboraciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Colaboracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate creationDate;
    private LocalDate completionDate;
    private String rol;
    private String description;
    private String state;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="capitulo_id")
    private Capitulo capitulo;

    @Override
    public String toString() {
        return "Colaboracion{" +
                "id=" + id +
                ", CreationDate='" + creationDate + '\'' +
                ", CompletionDate='" + completionDate + '\'' +
                ", Rol=" + rol +
                ", Description=" + description +
                ", State=" + state +
                '}';
    }
}

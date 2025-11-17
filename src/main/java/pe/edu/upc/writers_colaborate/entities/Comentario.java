package pe.edu.upc.writers_colaborate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name="comentarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Content;
    private LocalDate PublicationDate;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="proyecto_id")
    private Proyecto proyecto;

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", Content='" + Content + '\'' +
                ", PublicationDate='" + PublicationDate + '\'' +
                '}';
    }
}

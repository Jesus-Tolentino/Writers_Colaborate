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
@Table(name="colaboraciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Colaboracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate CreationDate;
    private LocalDate CompletionDate;
    private String Rol;
    private String Description;
    private String State;


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

}

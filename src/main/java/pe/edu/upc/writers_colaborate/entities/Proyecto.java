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
@Table(name="proyectos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Title;
    private String Description;
    private LocalDate PublicationDate;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "Proyecto", fetch = FetchType.EAGER)
    private List<Comentario> comentarios;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "Proyecto", fetch = FetchType.EAGER)
    private List<Capitulo> capitulos;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "Proyecto", fetch = FetchType.EAGER)
    private List<Reunion> reuniones;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "Proyecto", fetch = FetchType.EAGER)
    private List<ProyectoGenero> proyectos_generos;
}

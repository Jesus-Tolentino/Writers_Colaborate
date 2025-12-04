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
@Table(name="autores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String email;

//    @JsonIgnore
//    @ToString.Exclude
//    @ManyToOne
//    @JoinColumn(name="user_id")
//    private User user;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER)
    private List<Subscripcion> subscripciones;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER)
    private List<Proyecto> proyectos;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER)
    private List<Comentario> comentarios;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER)
    private List<Colaboracion> colaboraciones;

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", LastName='" + lastName + '\'' +
                ", Birthdate=" + birthdate +
                ", Email=" + email +
                '}';
    }
}

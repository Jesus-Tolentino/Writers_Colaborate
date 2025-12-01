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
@Table(name="capitulos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Capitulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private Integer chapterNumber;
    private LocalDate creationDate;
    private Boolean published;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="proyecto_id")
    private Proyecto proyecto;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "capitulo", fetch = FetchType.EAGER)
    private List<Colaboracion> colaboraciones;

    @Override
    public String toString() {
        return "Capitulo{" +
                "id=" + id +
                ", Title='" + title + '\'' +
                ", Content='" + content + '\'' +
                ", ChapterNumber=" + chapterNumber +
                ", CreationDate=" + creationDate +
                ", Published=" + published +
                '}';
    }
}

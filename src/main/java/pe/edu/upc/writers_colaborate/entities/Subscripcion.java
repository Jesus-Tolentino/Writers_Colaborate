package pe.edu.upc.writers_colaborate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name="subscripciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Type;
    private String Description;
    private LocalDate StartDate;
    private LocalDate EndDate;
    private Double Price;
    private Boolean AutoRenew;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;

    @Override
    public String toString() {
        return "Subscripcion{" +
                "id=" + id +
                ", Type='" + Type + '\'' +
                ", Description='" + Description + '\'' +
                ", StartDate=" + StartDate +
                ", EndDate=" + EndDate +
                ", Price=" + Price +
                ", AutoRenew=" + AutoRenew +
                '}';
    }
}

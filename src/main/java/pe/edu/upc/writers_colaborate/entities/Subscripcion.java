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

    private String type;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;
    private Boolean autoRenew;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;

    @Override
    public String toString() {
        return "Subscripcion{" +
                "id=" + id +
                ", Type='" + type + '\'' +
                ", Description='" + description + '\'' +
                ", StartDate=" + startDate +
                ", EndDate=" + endDate +
                ", Price=" + price +
                ", AutoRenew=" + autoRenew +
                '}';
    }
}

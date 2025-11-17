package pe.edu.upc.writers_colaborate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name="notificaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Message;
    private LocalDate CreationDate;
    private Boolean State;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="proyecto_id")
    private Proyecto proyecto;

    @Override
    public String toString() {
        return "Notificacion{" +
                "id=" + id +
                ", Message='" + Message + '\'' +
                ", CreationDate='" + CreationDate + '\'' +
                ", State=" + State +
                '}';
    }
}

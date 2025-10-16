package pe.edu.upc.writers_colaborate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="reuniones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reunion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Issue;
    private String Description;
    private LocalDate MeetingDate;
    private LocalTime StartHour;
    private LocalTime EndHour;
    private String Link;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="proyecto_id")
    private Proyecto proyecto;
}

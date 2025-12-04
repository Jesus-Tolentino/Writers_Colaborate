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

    private String issue;
    private String description;
    private LocalDate meetingDate;
    private LocalTime startHour;
    private LocalTime endHour;
    private String link;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="proyecto_id")
    private Proyecto proyecto;

    @Override
    public String toString() {
        return "Reunion{" +
                "id=" + id +
                ", Issue='" + issue + '\'' +
                ", Description='" + description + '\'' +
                ", MeetingDate=" + meetingDate +
                ", StartHour=" + startHour +
                ", EndHour=" + endHour +
                ", Link=" + link +
                '}';
    }
}

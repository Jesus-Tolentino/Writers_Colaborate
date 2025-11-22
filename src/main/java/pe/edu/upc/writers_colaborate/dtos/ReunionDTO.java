package pe.edu.upc.writers_colaborate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReunionDTO {

    private Long id;
    private String Issue;
    private String Description;
    private LocalDate MeetingDate;
    private LocalTime StartHour;
    private LocalTime EndHour;
    private String Link;
    private Long proyectoId;
}

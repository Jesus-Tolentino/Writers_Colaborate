package pe.edu.upc.writers_colaborate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoGeneroDTO {

    private Long id;
    private LocalDate AsignmentDate;
    private String Main;
    private String Sub;
    private Long proyectoId;
    private Long generoId;
}

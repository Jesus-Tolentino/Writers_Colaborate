package pe.edu.upc.writers_colaborate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColeccionProyectoDTO {

    private Long id;

    private LocalDate AsignmentDate;
    private Integer Amount;
    private String Description;
    private Long coleccionId;
    private Long proyectoId;
}

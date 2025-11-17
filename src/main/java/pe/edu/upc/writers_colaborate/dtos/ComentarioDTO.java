package pe.edu.upc.writers_colaborate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioDTO {

    private Long id;
    private String Content;
    private LocalDate PublicationDate;
    private Long autorId;
    private Long proyectoId;
}

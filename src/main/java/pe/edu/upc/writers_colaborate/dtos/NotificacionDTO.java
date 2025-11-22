package pe.edu.upc.writers_colaborate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionDTO {

    private Long id;
    private String Message;
    private LocalDate CreationDate;
    private Boolean State;
    private Long proyectoId;
}

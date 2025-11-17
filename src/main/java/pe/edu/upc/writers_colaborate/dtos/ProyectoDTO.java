package pe.edu.upc.writers_colaborate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoDTO {

    private Long id;
    private String Title;
    private String Description;
    private LocalDate CreationDate;
    private LocalDate PublicationDate;
    private String State;
    private Boolean MeetingsEnabled;
    private Long autorId;
}

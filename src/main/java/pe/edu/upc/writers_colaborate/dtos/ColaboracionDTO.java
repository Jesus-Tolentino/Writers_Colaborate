package pe.edu.upc.writers_colaborate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColaboracionDTO {

    private Long id;
    private LocalDate CreationDate;
    private LocalDate CompletionDate;
    private String Rol;
    private String Description;
    private String State;
    private Long autorId;
    private Long capituloId;
}

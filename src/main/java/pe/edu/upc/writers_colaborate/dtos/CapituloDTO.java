package pe.edu.upc.writers_colaborate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CapituloDTO {

    private Long id;
    private String Title;
    private String Content;
    private Integer ChapterNumber;
    private LocalDate CreationDate;
    private Boolean Published;
    private Long proyectoId;
}

package pe.edu.upc.writers_colaborate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscripcionDTO {

    private Long id;
    private String Type;
    private String Description;
    private LocalDate StartDate;
    private LocalDate EndDate;
    private Double Price;
    private Boolean AutoRenew;
    private Long autorId;
}

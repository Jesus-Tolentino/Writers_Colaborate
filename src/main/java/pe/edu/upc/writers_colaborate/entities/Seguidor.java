package pe.edu.upc.writers_colaborate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="seguidores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seguidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate FollowDate;
    private LocalDate UnfollowDate;
    private Boolean State;
}

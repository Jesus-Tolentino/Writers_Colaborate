package pe.edu.upc.writers_colaborate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pe.edu.upc.writers_colaborate.repositories.*;
import pe.edu.upc.writers_colaborate.services.AuthorityService;
import pe.edu.upc.writers_colaborate.services.UserService;

@SpringBootApplication
public class WritersColaborateApplication {

    public static void main(String[] args) {
        SpringApplication.run(WritersColaborateApplication.class, args);
    }

    @Bean
    public CommandLineRunner startConfiguration(
            AutorRepository autorRepository,
            CapituloRepository capituloRepository,
            ColaboracionRepository colaboracionRepository,
            ColeccionProyectoRepository coleccionProyectoRepository,
            ColeccionRepository coleccionRepository,
            ComentarioRepository comentarioRepository,
            GeneroRepository generoRepository,
            NotificacionRepository notificacionRepository,
            ProyectoGeneroRepository proyectoGeneroRepository,
            ProyectoRepository proyectoRepository,
            ReunionRepository reunionRepository,
            SubscripcionRepository subscripcionRepository,

            UserService userService,
            AuthorityService authorityService
    ){
        return args -> {

        };

    };
}

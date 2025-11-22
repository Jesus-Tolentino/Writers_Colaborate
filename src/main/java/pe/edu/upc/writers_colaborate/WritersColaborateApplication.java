package pe.edu.upc.writers_colaborate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pe.edu.upc.writers_colaborate.entities.Authority;
import pe.edu.upc.writers_colaborate.entities.Autor;
import pe.edu.upc.writers_colaborate.entities.Proyecto;
import pe.edu.upc.writers_colaborate.entities.User;
import pe.edu.upc.writers_colaborate.repositories.*;
import pe.edu.upc.writers_colaborate.services.AuthorityService;
import pe.edu.upc.writers_colaborate.services.UserService;

import java.time.LocalDate;
import java.util.List;

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

            Authority authority1 = authorityService.addAuthority(new Authority("ROLE_ADMIN"));
            Authority authority2 = authorityService.addAuthority(new Authority("ROLE_USER"));
            Authority authority3 = authorityService.addAuthority(new Authority("ROLE_WRITER"));

            userService.addUser(new User(null, "admin","admin",true,
                    List.of(authority1, authority2)));

            userService.addUser(new User(null, "grupo","grupo",true,
                    List.of(authority2)));

            userService.addUser(new User(null, "miguel","miguel",true,
                    List.of(authority3)));


            Autor a1 = autorRepository.save(new Autor(null,"Miguel","Cervantes",
                    LocalDate.of(1996,3,10),"MiguelCervantes@gmail.com",null,null,null,null));
            System.out.println(a1);
            Autor a2 = autorRepository.save(new Autor(null, "Laura", "Gutiérrez",
                    LocalDate.of(1998,5,21), "LauraGtz98@gmail.com", null,null,null,null
            ));
            System.out.println(a2);
            Autor a3 = autorRepository.save(new Autor(null, "Javier", "Montoya",
                    LocalDate.of(1993,11,2), "JMontoya93@gmail.com", null,null,null,null
            ));
            System.out.println(a3);
            Autor a4 = autorRepository.save(new Autor(null, "Carolina", "Ríos",
                    LocalDate.of(2000,1,15), "CarolRios00@gmail.com", null,null,null,null
            ));
            System.out.println(a4);
            Autor a5 = autorRepository.save(new Autor(null, "Andrés", "Salazar",
                    LocalDate.of(1995,7,8), "AndresSalazar95@gmail.com", null,null,null,null
            ));
            System.out.println(a5);


            Proyecto p1 = proyectoRepository.save(new Proyecto(null,"Don Quijote de la Mancha","Narrativa épica española que cuenta el viaje de Don Quijote en búsqueda de su amada Dulcinea.",
                    LocalDate.of(1602,9,27),LocalDate.of(1605,6,27),"Publicado",Boolean.FALSE,a1,null,null,null,null,null,null));
            System.out.println(p1);
            Proyecto p2 = proyectoRepository.save(new Proyecto(null, "El Guardián del Horizonte", "Aventura fantástica donde un guerrero protege el equilibrio entre mundos paralelos.",
                    LocalDate.of(2020,3,12), LocalDate.of(2022,1,5), "Publicado", Boolean.TRUE, a1, null,null,null,null,null,null));
            System.out.println(p2);
            Proyecto p3 = proyectoRepository.save(new Proyecto(null, "Sombras en la Ciudad", "Novela policial que sigue a un detective acechado por un caso sin resolver.",
                    LocalDate.of(2023,6,10), LocalDate.of(2024,1,20), "En Edición", Boolean.TRUE, a1, null,null,null,null,null,null));
            System.out.println(p3);

            Proyecto p4 = proyectoRepository.save(new Proyecto(null, "Ecos del Pasado", "Historia dramática donde secretos familiares resurgen tras décadas en silencio.",
                    LocalDate.of(2019,4,15), LocalDate.of(2020,9,10), "Publicado",Boolean.TRUE, a2, null,null,null,null,null,null));
            System.out.println(p4);
            Proyecto p5 = proyectoRepository.save(new Proyecto(null, "Alas de Cristal", "Fantasía juvenil sobre una joven que descubre que puede transformar sueños en realidad.",
                    LocalDate.of(2022,7,21), LocalDate.of(2023,3,30), "En Edición", Boolean.TRUE, a2, null,null,null,null,null,null));
            System.out.println(p5);

            Proyecto p6 = proyectoRepository.save(new Proyecto(null, "La Última Frontera", "Ciencia ficción que sigue a una tripulación en busca de un nuevo hogar para la humanidad.",
                    LocalDate.of(2018,11,10), LocalDate.of(2020,2,18), "Publicado", Boolean.FALSE, a3, null,null,null,null,null,null));
            System.out.println(p6);
            Proyecto p7 = proyectoRepository.save(new Proyecto(null, "Ríos de Sangre", "Thriller psicológico sobre un asesino en serie y un periodista que descubre la verdad.",
                    LocalDate.of(2021,5,4), LocalDate.of(2022,12,1), "Iniciado", Boolean.FALSE, a3, null,null,null,null,null,null));
            System.out.println(p7);

            Proyecto p8 = proyectoRepository.save(new Proyecto(null, "Bajo el Cerezo", "Romance contemporáneo ambientado en Kioto, donde dos almas se encuentran por destino.",
                    LocalDate.of(2020,9,2), LocalDate.of(2021,8,11), "En Edición", Boolean.FALSE, a4, null,null,null,null,null,null));
            System.out.println(p8);
            Proyecto p9 = proyectoRepository.save(new Proyecto(
                    null, "La Voz del Bosque", "Una fábula ecológica sobre un guardián ancestral que protege a la naturaleza del olvido.",
                    LocalDate.of(2017,1,13), LocalDate.of(2018,4,20), "En Edición", Boolean.FALSE, a4, null,null,null,null,null,null));
            System.out.println(p9);

            Proyecto p10 = proyectoRepository.save(new Proyecto(null, "Tormenta de Acero", "Relato bélico que narra la lucha de un soldado por sobrevivir en territorio enemigo.",
                    LocalDate.of(2016,2,28), LocalDate.of(2017,7,6), "Publicado", Boolean.TRUE, a5, null,null,null,null,null,null));
            System.out.println(p10);
            Proyecto p11 = proyectoRepository.save(new Proyecto(null, "El Reino Sumergido", "Fantasía épica situada en un mundo submarino lleno de misterios y criaturas ancestrales.",
                    LocalDate.of(2023,8,3), LocalDate.of(2024,5,14), "Publicado", Boolean.TRUE, a5, null,null,null,null,null,null));
            System.out.println(p11);


//            majorRepository.save(new Major(null,"Ingenieria de Software",f1,null));
//            majorRepository.save(new Major(null,"Ingenieria de Sistemas de Informacion",f1,null));
//            majorRepository.save(new Major(null,"Ciencias de la Computacion",f1,null));
//            majorRepository.save(new Major(null,"Ingenieria Civil",f1,null));
//            majorRepository.save(new Major(null,"Ingenieria Industrial",f1,null));
//
//            majorRepository.save(new Major(null,"Diseño Grafico",facultyDiseno,null));
//            majorRepository.save(new Major(null,"Diseño de Interiores",facultyDiseno,null));
//            majorRepository.save(new Major(null,"Diseño Industrial",facultyDiseno,null));

        };

    };
}

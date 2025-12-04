package pe.edu.upc.writers_colaborate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pe.edu.upc.writers_colaborate.entities.*;
import pe.edu.upc.writers_colaborate.repositories.*;
import pe.edu.upc.writers_colaborate.services.AuthorityService;
import pe.edu.upc.writers_colaborate.services.UserService;

import java.time.LocalDate;
import java.time.LocalTime;
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


            Subscripcion s1 = subscripcionRepository.save(new Subscripcion(null, "Premium", "El usuario puede crear reuniones y acceder a herramientas avanzadas.",
                    LocalDate.of(2025, 1, 10), LocalDate.of(2025, 12, 10), 25.90, Boolean.TRUE, a1));
            System.out.println(s1);

            Subscripcion s2 = subscripcionRepository.save(new Subscripcion(null, "Gratuito", "El usuario tiene acceso a las funcionalidades básicas, sin reuniones.",
                    LocalDate.of(2025, 2, 5), LocalDate.of(2025, 3, 5), 0.00, Boolean.FALSE, a2));
            System.out.println(s2);

            Subscripcion s3 = subscripcionRepository.save(new Subscripcion(null, "Premium", "Acceso completo a todas las herramientas colaborativas.",
                    LocalDate.of(2025, 4, 1), LocalDate.of(2025, 10, 1), 19.90, Boolean.TRUE, a3));
            System.out.println(s3);

            Subscripcion s4 = subscripcionRepository.save(new Subscripcion(null, "Gratuito", "Acceso limitado a herramientas de colaboración.",
                    LocalDate.of(2025, 6, 15), LocalDate.of(2025, 7, 15), 0.00, Boolean.FALSE, a4));
            System.out.println(s4);

            Subscripcion s5 = subscripcionRepository.save(new Subscripcion(null, "Premium", "Acceso total e interacciones ilimitadas.",
                    LocalDate.of(2025, 6, 1), LocalDate.of(2026, 6, 1), 29.99, Boolean.TRUE, a5));
            System.out.println(s5);


            Reunion r1 = reunionRepository.save(new Reunion(
                    null, "Planificación de personajes",
                    "Discusión creativa sobre los protagonistas",
                    LocalDate.of(2025, 7, 12),
                    LocalTime.of(19, 0),
                    LocalTime.of(20, 0),
                    "https://meet.example.com/r1", p4));
            System.out.println(r1);

            Reunion r2 = reunionRepository.save(new Reunion(
                    null, "Revisión narrativa inicial",
                    "Ajustes al tono de la historia",
                    LocalDate.of(2025, 7, 20),
                    LocalTime.of(18, 30),
                    LocalTime.of(19, 30),
                    "https://meet.example.com/r2", p4));
            System.out.println(r2);

            Reunion r3 = reunionRepository.save(new Reunion(
                    null, "Avance de capítulos",
                    "Seguimiento de progreso y asignación",
                    LocalDate.of(2025, 7, 28),
                    LocalTime.of(17, 0),
                    LocalTime.of(18, 15),
                    "https://meet.example.com/r3", p4));
            System.out.println(r3);

// Proyecto p8 (Autor premium: a4)
            Reunion r4 = reunionRepository.save(new Reunion(
                    null, "Diseño de arte de portadas",
                    "Ideas para cubiertas alternativas",
                    LocalDate.of(2025, 8, 3),
                    LocalTime.of(18, 0),
                    LocalTime.of(19, 0),
                    "https://meet.example.com/r4", p8));
            System.out.println(r4);

            Reunion r5 = reunionRepository.save(new Reunion(
                    null, "Estructura del libro",
                    "Definición del orden de capítulos",
                    LocalDate.of(2025, 8, 10),
                    LocalTime.of(16, 30),
                    LocalTime.of(18, 0),
                    "https://meet.example.com/r5", p8));
            System.out.println(r5);

            Reunion r6 = reunionRepository.save(new Reunion(
                    null, "Corrección ortográfica grupal",
                    "Revisión colectiva de errores comunes",
                    LocalDate.of(2025, 8, 15),
                    LocalTime.of(19, 0),
                    LocalTime.of(20, 0),
                    "https://meet.example.com/r6", p8));
            System.out.println(r6);

            Reunion r7 = reunionRepository.save(new Reunion(
                    null, "Revisión de plot twist",
                    "Analizar impacto en la audiencia",
                    LocalDate.of(2025, 8, 24),
                    LocalTime.of(20, 0),
                    LocalTime.of(21, 0),
                    "https://meet.example.com/r7", p8));
            System.out.println(r7);

// Proyecto p10 (Autor premium: a4)
            Reunion r8 = reunionRepository.save(new Reunion(
                    null, "Evaluar personajes secundarios",
                    "Profundizar en villanos y aliados",
                    LocalDate.of(2025, 9, 1),
                    LocalTime.of(17, 45),
                    LocalTime.of(19, 0),
                    "https://meet.example.com/r8", p10));
            System.out.println(r8);

            Reunion r9 = reunionRepository.save(new Reunion(
                    null, "Diálogos entre capítulos",
                    "Mejorar coherencia conversacional",
                    LocalDate.of(2025, 9, 8),
                    LocalTime.of(18, 0),
                    LocalTime.of(19, 30),
                    "https://meet.example.com/r9", p10));
            System.out.println(r9);

            Reunion r10 = reunionRepository.save(new Reunion(
                    null, "Cierre argumental",
                    "Definir final y posibles continuaciones",
                    LocalDate.of(2025, 9, 16),
                    LocalTime.of(19, 0),
                    LocalTime.of(20, 0),
                    "https://meet.example.com/r10", p10));
            System.out.println(r10);


            Comentario c1 = comentarioRepository.save(
                    new Comentario(null, "Una historia que promete mucho, me encantó el inicio.",
                            LocalDate.of(2025, 1, 12), a2, p1));
            System.out.println(c1);

            Comentario c2 = comentarioRepository.save(
                    new Comentario(null, "Creo que el personaje principal necesita más desarrollo.",
                            LocalDate.of(2025, 2, 3), a3, p2));
            System.out.println(c2);

            Comentario c3 = comentarioRepository.save(
                    new Comentario(null, "Wow, me atrapó desde el primer capítulo.",
                            LocalDate.of(2025, 2, 15), a4, p3));
            System.out.println(c3);

            Comentario c4 = comentarioRepository.save(
                    new Comentario(null, "Buen ritmo narrativo, espero la continuación pronto.",
                            LocalDate.of(2025, 3, 1), a5, p4));
            System.out.println(c4);

            Comentario c5 = comentarioRepository.save(
                    new Comentario(null, "Los diálogos son increíbles, muy reales.",
                            LocalDate.of(2025, 3, 10), a1, p5));
            System.out.println(c5);

            Comentario c6 = comentarioRepository.save(
                    new Comentario(null, "El giro inesperado me sorprendió completamente.",
                            LocalDate.of(2025, 3, 20), a3, p6));
            System.out.println(c6);

            Comentario c7 = comentarioRepository.save(
                    new Comentario(null, "Me encanta la ambientación futurista del proyecto.",
                            LocalDate.of(2025, 4, 2), a2, p7));
            System.out.println(c7);

            Comentario c8 = comentarioRepository.save(
                    new Comentario(null, "No soy fan del género, pero está muy bien escrito.",
                            LocalDate.of(2025, 4, 18), a5, p8));
            System.out.println(c8);

            Comentario c9 = comentarioRepository.save(
                    new Comentario(null, "Me gustaría ver más interacción entre personajes.",
                            LocalDate.of(2025, 5, 5), a4, p9));
            System.out.println(c9);

            Comentario c10 = comentarioRepository.save(
                    new Comentario(null, "Excelente trabajo, va directo a mi colección favorita.",
                            LocalDate.of(2025, 5, 20), a1, p10));
            System.out.println(c10);


            Capitulo ca1 = capituloRepository.save(new Capitulo(null, "Comienzo inesperado", "El protagonista inicia su viaje con dudas…",
                    1, LocalDate.of(2025, 1, 10), true, p1, null));
            System.out.println(ca1);
            Capitulo ca2 = capituloRepository.save(new Capitulo(null, "Sombras del pasado", "Un encuentro que cambia todo…",
                    2, LocalDate.of(2025, 1, 14), true, p1,null));
            System.out.println(ca2);
            Capitulo ca3 = capituloRepository.save(new Capitulo(null, "El camino peligroso", "Se descubre una amenaza oculta.",
                    3, LocalDate.of(2025, 1, 20), false, p1,null));
            System.out.println(ca3);
            Capitulo ca4 = capituloRepository.save(new Capitulo(null, "Un nuevo aliado", "Aparece un personaje crucial.",
                    1, LocalDate.of(2025, 2, 5), true, p2,null));
            System.out.println(ca4);
            Capitulo ca5 = capituloRepository.save(new Capitulo(null, "Revelaciones", "Una verdad difícil de aceptar.",
                    2, LocalDate.of(2025, 2, 9), true, p2,null));
            System.out.println(ca5);
            Capitulo ca6 = capituloRepository.save(new Capitulo(null, "Camino sin regreso", "Una decisión arriesgada.",
                    3, LocalDate.of(2025, 2, 15), false, p2,null));
            System.out.println(ca6);
            Capitulo ca7 = capituloRepository.save(new Capitulo(null, "Presentación misteriosa", "La historia comienza con una carta.",
                    1, LocalDate.of(2025, 3, 3), true, p3,null));
            System.out.println(ca7);
            Capitulo ca8 = capituloRepository.save(new Capitulo(null, "El pasajero extraño", "Alguien sube al tren y lo cambia todo.",
                    2, LocalDate.of(2025, 3, 9), true, p3, null));
            System.out.println(ca8);
            Capitulo ca9 = capituloRepository.save(new Capitulo(null, "El código del destino", "Una pista importante aparece.",
                    1, LocalDate.of(2025, 4, 1), true, p4, null));
            System.out.println(ca9);
            Capitulo ca10 = capituloRepository.save(new Capitulo(null, "Conexiones ocultas", "Los personajes se cruzan por primera vez.",
                    2, LocalDate.of(2025, 4, 8), false, p4, null));
            System.out.println(ca10);
            Capitulo ca11 = capituloRepository.save(new Capitulo(null, "Es hora de despertar", "Una revelación abre una nueva trama.",
                    1, LocalDate.of(2025, 5, 10), true, p5, null));
            System.out.println(ca11);
            Capitulo ca12 = capituloRepository.save(new Capitulo(null, "Un héroe improbable", "El protagonista acepta su misión.",
                    2, LocalDate.of(2025, 5, 20), true, p5, null));
            System.out.println(ca12);


            Colaboracion co1 = colaboracionRepository.save(new Colaboracion(
                    null, LocalDate.of(2025, 7, 4), null,
                    "Co-Writer", "Apoyo en escritura del capítulo", "EN_PROCESO",
                    a1, ca1));
            System.out.println(co1);

            Colaboracion co2 = colaboracionRepository.save(new Colaboracion(
                    null, LocalDate.of(2025, 7, 10), LocalDate.of(2025, 7, 18),
                    "Ilustrador", "Diseño de portadas e imágenes", "FINALIZADO",
                    a2, ca1));
            System.out.println(co2);

            Colaboracion co3 = colaboracionRepository.save(new Colaboracion(
                    null, LocalDate.of(2025, 7, 15), null,
                    "Editor", "Corrección de estilo previa publicación", "EN_PROCESO",
                    a3, ca2));
            System.out.println(co3);

            Colaboracion co4 = colaboracionRepository.save(new Colaboracion(
                    null, LocalDate.of(2025, 8, 1), null,
                    "Revisor", "Validación del contenido científico", "EN_PROCESO",
                    a4, ca2));
            System.out.println(co4);

            Colaboracion co5 = colaboracionRepository.save(new Colaboracion(
                    null, LocalDate.of(2025, 8, 5), LocalDate.of(2025, 8, 25),
                    "Corrector", "Correcciones ortográficas y gramaticales", "FINALIZADO",
                    a5, ca3));
            System.out.println(co5);

            Colaboracion co6 = colaboracionRepository.save(new Colaboracion(
                    null, LocalDate.of(2025, 8, 8), null,
                    "Investigador", "Búsqueda de referencias históricas", "EN_PROCESO",
                    a4, ca3));
            System.out.println(co6);

            Colaboracion co7 = colaboracionRepository.save(new Colaboracion(
                    null, LocalDate.of(2025, 8, 10), LocalDate.of(2025, 8, 28),
                    "Co-Writer", "Ampliación de la narrativa", "FINALIZADO",
                    a3, ca4));
            System.out.println(co7);

            Colaboracion co8 = colaboracionRepository.save(new Colaboracion(
                    null, LocalDate.of(2025, 8, 15), null,
                    "Ilustrador", "Creación de arte conceptual", "EN_PROCESO",
                    a2, ca5));
            System.out.println(co8);

            Colaboracion co9 = colaboracionRepository.save(new Colaboracion(
                    null, LocalDate.of(2025, 8, 20), null,
                    "Editor", "Edición avanzada para publicación", "DETENIDO",
                    a1, ca6));
            System.out.println(co9);

            Colaboracion co10 = colaboracionRepository.save(new Colaboracion(
                    null, LocalDate.of(2025, 8, 30), null,
                    "Corrector", "Revisión final previa entrega", "EN_PROCESO",
                    a4, ca6));
            System.out.println(co10);


// Proyecto: p1
            Notificacion n1 = notificacionRepository.save(new Notificacion(
                    null,
                    "Nueva actualización disponible del capítulo",
                    LocalDate.of(2025, 6, 10),
                    Boolean.FALSE,
                    p1));
            System.out.println(n1);

            Notificacion n2 = notificacionRepository.save(new Notificacion(
                    null,
                    "Recordatorio: Revisión pendiente",
                    LocalDate.of(2025, 6, 12),
                    Boolean.TRUE,
                    p1));
            System.out.println(n2);

// Proyecto: p2
            Notificacion n3 = notificacionRepository.save(new Notificacion(
                    null,
                    "El autor agregó nuevo contenido",
                    LocalDate.of(2025, 7, 1),
                    Boolean.FALSE,
                    p2));
            System.out.println(n3);

            Notificacion n4 = notificacionRepository.save(new Notificacion(
                    null,
                    "Se programó una reunión para este proyecto",
                    LocalDate.of(2025, 7, 4),
                    Boolean.TRUE,
                    p2));
            System.out.println(n4);

// Proyecto: p3
            Notificacion n5 = notificacionRepository.save(new Notificacion(
                    null,
                    "Nuevo comentario en el proyecto",
                    LocalDate.of(2025, 6, 20),
                    Boolean.TRUE,
                    p3));
            System.out.println(n5);

            Notificacion n6 = notificacionRepository.save(new Notificacion(
                    null,
                    "Capítulo pendiente de publicación",
                    LocalDate.of(2025, 6, 21),
                    Boolean.FALSE,
                    p3));
            System.out.println(n6);

// Proyecto: p4
            Notificacion n7 = notificacionRepository.save(new Notificacion(
                    null,
                    "Una colaboración ha sido finalizada",
                    LocalDate.of(2025, 6, 25),
                    Boolean.TRUE,
                    p4));
            System.out.println(n7);

            Notificacion n8 = notificacionRepository.save(new Notificacion(
                    null,
                    "Nuevo colaborador añadido",
                    LocalDate.of(2025, 6, 26),
                    Boolean.FALSE,
                    p4));
            System.out.println(n8);

// Proyecto: p5
            Notificacion n9 = notificacionRepository.save(new Notificacion(
                    null,
                    "Se ha eliminado un capítulo",
                    LocalDate.of(2025, 7, 5),
                    Boolean.FALSE,
                    p5));
            System.out.println(n9);

            Notificacion n10 = notificacionRepository.save(new Notificacion(
                    null,
                    "Tu suscripción permite agendar reuniones extras",
                    LocalDate.of(2025, 7, 8),
                    Boolean.TRUE,
                    p5));
            System.out.println(n10);


            Coleccion col1 = coleccionRepository.save(new Coleccion(
                    null,
                    "Clásicos del Suspenso",
                    "Carlos García",
                    "Pública",
                    "Colección con los mejores proyectos de suspenso",
                    LocalDate.of(2025, 7, 1),
                    true,
                    null));
            System.out.println(col1);

            Coleccion col2 = coleccionRepository.save(new Coleccion(
                    null,
                    "Romance Contemporáneo",
                    "Laura Torres",
                    "Privada",
                    "Historias modernas de amor",
                    LocalDate.of(2025, 7, 2),
                    true,
                    null));
            System.out.println(col2);

            Coleccion col3 = coleccionRepository.save(new Coleccion(
                    null,
                    "Viajes Fantásticos",
                    "Sofía Martínez",
                    "Pública",
                    "Selección de proyectos de fantasía",
                    LocalDate.of(2025, 7, 5),
                    true,
                    null));
            System.out.println(col3);

            Coleccion col4 = coleccionRepository.save(new Coleccion(
                    null,
                    "Detectives en Acción",
                    "Miguel López",
                    "Pública",
                    "Para amantes del misterio e investigación",
                    LocalDate.of(2025, 7, 8),
                    false,
                    null));
            System.out.println(col4);

            Coleccion col5 = coleccionRepository.save(new Coleccion(
                    null,
                    "Ciencia y Futuro",
                    "Ana Rojas",
                    "Pública",
                    "Historias que exploran la tecnología y el universo",
                    LocalDate.of(2025, 7, 10),
                    true,
                    null));
            System.out.println(col5);

            Coleccion col6 = coleccionRepository.save(new Coleccion(
                    null,
                    "Magia y Realidad",
                    "Carlos García",
                    "Privada",
                    "Fusión entre magia y mundo real",
                    LocalDate.of(2025, 7, 12),
                    true,
                    null));
            System.out.println(col6);

            Coleccion col7 = coleccionRepository.save(new Coleccion(
                    null,
                    "Risas Aseguradas",
                    "Laura Torres",
                    "Pública",
                    "Historias humorísticas para todas las edades",
                    LocalDate.of(2025, 7, 14),
                    true,
                    null));
            System.out.println(col7);

            Coleccion col8 = coleccionRepository.save(new Coleccion(
                    null,
                    "Relatos Cortos",
                    "Sofía Martínez",
                    "Pública",
                    "Colección colaborativa de historias breves",
                    LocalDate.of(2025, 7, 18),
                    false,
                    null));
            System.out.println(col8);

            Coleccion col9 = coleccionRepository.save(new Coleccion(
                    null,
                    "Historias de Superación",
                    "Miguel López",
                    "Privada",
                    "Proyectos con mensajes motivadores",
                    LocalDate.of(2025, 7, 20),
                    true,
                    null));
            System.out.println(col9);

            Coleccion col10 = coleccionRepository.save(new Coleccion(
                    null,
                    "Sombras y Oscuridad",
                    "Ana Rojas",
                    "Pública",
                    "Colección de terror y suspenso psicológico",
                    LocalDate.of(2025, 7, 22),
                    true,
                    null));
            System.out.println(col10);


            ColeccionProyecto cp1 = coleccionProyectoRepository.save(
                    new ColeccionProyecto(null, LocalDate.of(2025,1,10), 1,
                            "Proyecto clásico destacado", col1, p1));
            System.out.println(cp1);

            ColeccionProyecto cp2 = coleccionProyectoRepository.save(
                    new ColeccionProyecto(null, LocalDate.of(2025,1,10), 2,
                            "Obras del mismo autor", col1, p2));
            System.out.println(cp2);

            ColeccionProyecto cp3 = coleccionProyectoRepository.save(
                    new ColeccionProyecto(null, LocalDate.of(2025,2,15), 1,
                            "Suspenso y policíaco moderno", col2, p3));
            System.out.println(cp3);

            ColeccionProyecto cp4 = coleccionProyectoRepository.save(
                    new ColeccionProyecto(null, LocalDate.of(2025,2,15), 1,
                            "Suspenso profundo con giros fuertes", col2, p7));
            System.out.println(cp4);

            ColeccionProyecto cp5 = coleccionProyectoRepository.save(
                    new ColeccionProyecto(null, LocalDate.of(2025,3,2), 3,
                            "Historias dramáticas memorables", col3, p4));
            System.out.println(cp5);

            ColeccionProyecto cp6 = coleccionProyectoRepository.save(
                    new ColeccionProyecto(null, LocalDate.of(2025,3,2), 2,
                            "Fantasía inspiradora juvenil", col3, p5));
            System.out.println(cp6);

            ColeccionProyecto cp7 = coleccionProyectoRepository.save(
                    new ColeccionProyecto(null, LocalDate.of(2025,4,5), 1,
                            "Exploración de mundos alternos", col4, p6));
            System.out.println(cp7);

            ColeccionProyecto cp8 = coleccionProyectoRepository.save(
                    new ColeccionProyecto(null, LocalDate.of(2025,4,5), 1,
                            "Universos submarinos mágicos", col4, p11));
            System.out.println(cp8);

            ColeccionProyecto cp9 = coleccionProyectoRepository.save(
                    new ColeccionProyecto(null, LocalDate.of(2025,5,12), 1,
                            "Romance y la voz de la naturaleza", col5, p8));
            System.out.println(cp9);

            ColeccionProyecto cp10 = coleccionProyectoRepository.save(
                    new ColeccionProyecto(null, LocalDate.of(2025,5,12), 2,
                            "Aventuras con profundo mensaje ecológico", col5, p9));
            System.out.println(cp10);


            Genero g1 = generoRepository.save(new Genero(null,
                    "Fantasía",
                    "Historias ambientadas en mundos imaginarios con elementos mágicos.",
                    null));
            System.out.println(g1);

            Genero g2 = generoRepository.save(new Genero(null,
                    "Ciencia Ficción",
                    "Narraciones basadas en avances científicos y tecnológicos en el futuro.",
                    null));
            System.out.println(g2);

            Genero g3 = generoRepository.save(new Genero(null,
                    "Misterio",
                    "Relatos centrados en la resolución de enigmas o crímenes.",
                    null));
            System.out.println(g3);

            Genero g4 = generoRepository.save(new Genero(null,
                    "Romance",
                    "Historias enfocadas en relaciones amorosas y vínculos sentimentales.",
                    null));
            System.out.println(g4);

            Genero g5 = generoRepository.save(new Genero(null,
                    "Terror",
                    "Historias diseñadas para provocar miedo, suspenso o inquietud.",
                    null));
            System.out.println(g5);

            Genero g6 = generoRepository.save(new Genero(null,
                    "Drama",
                    "Narrativas centradas en conflictos emocionales y personales.",
                    null));
            System.out.println(g6);

            Genero g7 = generoRepository.save(new Genero(null,
                    "Aventura",
                    "Obras que presentan viajes, exploraciones y desafíos emocionantes.",
                    null));
            System.out.println(g7);

            Genero g8 = generoRepository.save(new Genero(null,
                    "Histórico",
                    "Historias basadas en hechos o contextos del pasado.",
                    null));
            System.out.println(g8);

            Genero g9 = generoRepository.save(new Genero(null,
                    "Policial",
                    "Relatos de investigación criminal con detectives o policías.",
                    null));
            System.out.println(g9);

            Genero g10 = generoRepository.save(new Genero(null,
                    "Fábula",
                    "Historias con moraleja que suelen incluir animales personificados.",
                    null));
            System.out.println(g10);


            ProyectoGenero pg1 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,1,10), "Sí", null, p1, g3));
            System.out.println(pg1);
            ProyectoGenero pg2 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,1,11), "No", "Caballería", p1, g4));
            System.out.println(pg2);

            ProyectoGenero pg3 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,2,1), "Sí", null, p2, g1));
            System.out.println(pg3);
            ProyectoGenero pg4 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,2,2), "No", "Aventura multiversal", p2, g2));
            System.out.println(pg4);

            ProyectoGenero pg5 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,3,5), "Sí", null, p3, g2));
            System.out.println(pg5);
            ProyectoGenero pg6 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,3,6), "No", "Policía vs Mafia", p3, g6));
            System.out.println(pg6);

            ProyectoGenero pg7 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,4,12), "Sí", null, p4, g5));
            System.out.println(pg7);
            ProyectoGenero pg8 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,4,13), "No", "Drama familiar", p4, g8));
            System.out.println(pg8);

            ProyectoGenero pg9 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,5,12), "Sí", null, p5, g1));
            System.out.println(pg9);
            ProyectoGenero pg10 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,5,13), "No", "Juvenil fantástico", p5, g4));
            System.out.println(pg10);

            ProyectoGenero pg11 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,6,14), "Sí", null, p6, g7));
            System.out.println(pg11);
            ProyectoGenero pg12 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,6,15), "No", "Viaje espacial", p6, g2));
            System.out.println(pg12);

            ProyectoGenero pg13 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,7,21), "Sí", null, p7, g6));
            System.out.println(pg13);
            ProyectoGenero pg14 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,7,22), "No", "Psicología", p7, g8));
            System.out.println(pg14);

            ProyectoGenero pg15 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,8,18), "Sí", null, p8, g8));
            System.out.println(pg15);
            ProyectoGenero pg16 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,8,19), "No", "Romance japonés", p8, g3));
            System.out.println(pg16);

            ProyectoGenero pg17 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,9,28), "Sí", null, p9, g10));
            System.out.println(pg17);
            ProyectoGenero pg18 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,9,29), "No", "Naturaleza mística", p9, g3));
            System.out.println(pg18);

            ProyectoGenero pg19 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,10,11), "Sí", null, p10, g9));
            System.out.println(pg19);
            ProyectoGenero pg20 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,10,12), "No", "Batallas tácticas", p10, g7));
            System.out.println(pg20);

            ProyectoGenero pg21 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,11,8), "Sí", null, p11, g1));
            System.out.println(pg21);
            ProyectoGenero pg22 = proyectoGeneroRepository.save(new ProyectoGenero(null,
                    LocalDate.of(2024,11,9), "No", "Mundo submarino", p11, g10));
            System.out.println(pg22);

            //autor, proyecto, subscripcion, reunion, comentario, capitulo, colaboracion, notificaciones
            //coleccion, coleccion_proyecto, genero, proyecto_genero
        };

    };
}

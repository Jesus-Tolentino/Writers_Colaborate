package pe.edu.upc.writers_colaborate.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    private static final String[] AUTH_WHITELIST ={
            // -- Swagger
            "/v2/api-docs/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/swagger-ui/**",

            // -- Login
            "/upc/users/login/**",

            // -- Resigtro
            "/upc/users/register/**"
    };

    // Authentication Manager
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
                return authenticationConfiguration.getAuthenticationManager();
    }

    // Security Filter Chain

    /*

    1. Cuales van a ser los Request(pedidos) que seran evaluados para saber si el usuario tiene permisos sobre estos
        a. AnyRequest -> Todos los pedidos
        b. RequestMatchers -> Se evalua solo los que coincidan con las rutas
        c. RequestMatches + HttpMethod -> Se evalua a los que coincidan con la ruta y con el metodo (GET, POST, etc.)

    2. Cual es la regla de autorización que se van a aplicar sobre estos Request(pedidos)
        a. permitAll()
        b. denyAll()
        c. requestMatchers()
        d. hasRole()
        e. hayAnyRole()
        f. hasAuthority()
        g. hasAnyAuthority()
        h. SpEL Spring Expression Language
        i. authenticated()

    */

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.addFilterBefore( jwtRequestFilter , UsernamePasswordAuthenticationFilter.class );
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(Customizer.withDefaults());
        http.authorizeHttpRequests( (auth) -> auth
                // ================================
                // 1. ENDPOINTS PUBLICOS (LOGIN, REGISTER, SWAGGER, ETC.)
                // ================================
                .requestMatchers(AUTH_WHITELIST).permitAll()

                // ================================
                // 2. PERMISOS POR ENTIDAD
                // ================================

                // -------- AUTOR --------
                // Admin puede hacer todo, Writer solo puede verse a sí mismo (GET)
                .requestMatchers(HttpMethod.GET, "/autores/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_WRITER")
                .requestMatchers(HttpMethod.POST, "/autores/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.PUT, "/autores/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/autores/**").hasAuthority("ROLE_ADMIN")

                // -------- PROYECTO -------- (Writer crea, Admin controla todo)
                .requestMatchers(HttpMethod.POST, "/proyectos/**").hasAuthority("ROLE_WRITER")
                .requestMatchers(HttpMethod.PUT, "/proyectos/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_WRITER")
                .requestMatchers(HttpMethod.GET, "/proyectos/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_WRITER", "ROLE_USER")
                .requestMatchers(HttpMethod.DELETE, "/proyectos/**").hasAuthority("ROLE_ADMIN")

                // -------- CAPITULO -------- (Writer crea capítulos)
                .requestMatchers(HttpMethod.POST, "/capitulos/**").hasAuthority("ROLE_WRITER")
                .requestMatchers(HttpMethod.PUT, "/capitulos/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_WRITER")
                .requestMatchers(HttpMethod.GET, "/capitulos/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_WRITER", "ROLE_USER")
                .requestMatchers(HttpMethod.DELETE, "/capitulos/**").hasAuthority("ROLE_ADMIN")

                // -------- COLABORACION -------- (Writer puede unirse)
                .requestMatchers(HttpMethod.POST, "/colaboraciones/**").hasAuthority("ROLE_WRITER")
                .requestMatchers(HttpMethod.GET, "/colaboraciones/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_WRITER")
                .requestMatchers(HttpMethod.DELETE, "/colaboraciones/**").hasAuthority("ROLE_ADMIN")

                // -------- COLECCION -------- (Writer crea)
                .requestMatchers(HttpMethod.POST, "/colecciones/**").hasAuthority("ROLE_WRITER")
                .requestMatchers(HttpMethod.PUT, "/colecciones/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_WRITER")
                .requestMatchers(HttpMethod.GET, "/colecciones/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_WRITER", "ROLE_USER")
                .requestMatchers(HttpMethod.DELETE, "/colecciones/**").hasAuthority("ROLE_ADMIN")

                // -------- COLECCION-PROYECTO -------- (Writer agrega proyectos a colecciones)
                .requestMatchers(HttpMethod.POST, "/colecciones_proyectos/**").hasAuthority("ROLE_WRITER")
                .requestMatchers(HttpMethod.DELETE, "/colecciones_proyectos/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_WRITER")
                .requestMatchers(HttpMethod.GET, "/colecciones_proyectos/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_WRITER", "ROLE_USER")

                // -------- GENERO -------- (USER actualiza géneros disponibles)
                .requestMatchers(HttpMethod.PUT, "/generos/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .requestMatchers(HttpMethod.POST, "/generos/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/generos/**").permitAll()

                // -------- PROYECTO-GENERO -------- (Writer define los géneros de sus proyectos)
                .requestMatchers(HttpMethod.POST, "/proyectos_generos/**").hasAuthority("ROLE_WRITER")
                .requestMatchers(HttpMethod.DELETE, "/proyectos_generos/**").hasAuthority("ROLE_WRITER")
                .requestMatchers(HttpMethod.GET, "/proyectos_generos/**").permitAll()

                // -------- COMENTARIO -------- (Writer crea comentarios)
                .requestMatchers(HttpMethod.POST, "/comentarios/**").hasAuthority("ROLE_WRITER")
                .requestMatchers(HttpMethod.GET, "/comentarios/**").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/comentarios/**").hasAuthority("ROLE_ADMIN")

                // -------- NOTIFICACION -------- (Usuarios pueden crearlas)
                .requestMatchers(HttpMethod.POST, "/notificaciones/**").hasAnyAuthority("ROLE_USER", "ROLE_WRITER")
                .requestMatchers(HttpMethod.GET, "/notificaciones/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_WRITER", "ROLE_USER")
                .requestMatchers(HttpMethod.DELETE, "/notificaciones/**").hasAuthority("ROLE_ADMIN")

                // -------- REUNION -------- (Solo writer suscrito crea)
                .requestMatchers(HttpMethod.POST, "/reuniones/**").hasAuthority("ROLE_WRITER")
                .requestMatchers(HttpMethod.GET, "/reuniones/**").hasAnyAuthority("ROLE_WRITER", "ROLE_ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/reuniones/**").hasAuthority("ROLE_ADMIN")

                // -------- SUSCRIPCION -------- (Writer puede suscribirse)
                .requestMatchers(HttpMethod.POST, "/suscripciones/**").hasAuthority("ROLE_WRITER")
                .requestMatchers(HttpMethod.GET, "/suscripciones/**").hasAnyAuthority("ROLE_WRITER", "ROLE_ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/suscripciones/**").hasAuthority("ROLE_ADMIN")

                // ================================
                // 3. CUALQUIER OTRO ENDPOINT
                // ================================
                .anyRequest().authenticated()
        );
        http.sessionManagement(
                (session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        return http.build();
    }

    // Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

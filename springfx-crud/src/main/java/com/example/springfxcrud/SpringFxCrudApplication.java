package com.example.springfxcrud;

import com.example.springfxcrud.model.Usuario;
import com.example.springfxcrud.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringFxCrudApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringFxCrudApplication.class, args);
    }
    @Bean
    CommandLineRunner initDatabase(UsuarioRepository usuarioRepository) {
        return args -> {
            if (usuarioRepository.count() == 0) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                Usuario admin = new Usuario();
                admin.setUser("admin");
                admin.setNombre("Administrador");
                admin.setRol("ADMIN");
                admin.setContraseña(encoder.encode("1234")); // contraseña: 1234
                usuarioRepository.save(admin);
                System.out.println(" Usuario admin creado: user=admin / pass=1234");
            }
        };
    }
}

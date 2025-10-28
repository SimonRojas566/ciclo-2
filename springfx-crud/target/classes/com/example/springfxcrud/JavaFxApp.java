package com.example.springfxcrud;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApp extends Application {

    private static ConfigurableApplicationContext springContext;

    @Override
    public void init() throws Exception {
        System.out.println("=== INICIANDO SPRING CONTEXT ===");
        springContext = new SpringApplicationBuilder(SpringFxCrudApplication.class)
                .headless(false) // ¡IMPORTANTE para JavaFX!
                .run();
        System.out.println("=== SPRING CONTEXT INICIADO ===");
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("=== CARGANDO INTERFAZ LOGIN ===");

        // Cargar login.fxml usando Spring context
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        loader.setControllerFactory(springContext::getBean); // ¡CONECTA CON SPRING!
        Parent root = loader.load();

        stage.setTitle("SpringFX - Login");
        stage.setScene(new Scene(root, 400, 300));
        stage.show();

        System.out.println("=== INTERFAZ LOGIN CARGADA ===");
    }

    @Override
    public void stop() throws Exception {
        System.out.println("=== CERRANDO APLICACIÓN ===");
        if (springContext != null) {
            springContext.close();
        }
        Platform.exit();
    }

    // Método para obtener el contexto de Spring desde otros controladores
    public static ConfigurableApplicationContext getSpringContext() {
        return springContext;
    }
}
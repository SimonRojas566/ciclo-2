package com.example.springfxcrud.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {
    @FXML
    private void openUsuarios() { openWindow("/fxml/usuarios.fxml", "Usuarios"); }
    @FXML
    private void openProductos() { openWindow("/fxml/productos.fxml", "Productos"); }
    @FXML
    private void openPedidos() { openWindow("/fxml/pedidos_placeholder.fxml", "Pedidos"); }

    private void openWindow(String fxml, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

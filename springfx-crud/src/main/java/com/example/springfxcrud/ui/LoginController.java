package com.example.springfxcrud.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginController {
    @FXML private TextField txtUser;
    @FXML private PasswordField txtPass;
    @FXML private Label lblMsg;

    @FXML
    private void onLogin() {
        String user = txtUser.getText();
        String pass = txtPass.getText();
        if(user==null || user.isBlank() || pass==null || pass.isBlank()) {
            lblMsg.setText("Ingrese usuario y contraseña");
            return;
        }
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
            Stage stage = (Stage) txtUser.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (Exception ex) {
            lblMsg.setText("Error: " + ex.getMessage());
        }
    }
}

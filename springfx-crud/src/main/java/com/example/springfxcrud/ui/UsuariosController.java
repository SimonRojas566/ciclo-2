package com.example.springfxcrud.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class UsuariosController {
    @FXML private TableView table;
    @FXML private void onNuevo() { System.out.println("Nuevo usuario - implementar formulario"); }
    @FXML private void onEliminar() { System.out.println("Eliminar usuario - implementar selección"); }
}

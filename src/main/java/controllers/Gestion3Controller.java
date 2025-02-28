package controllers;

import application.Gestion3;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Gestion3Controller {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private TableView<Gestion3> tablaPersonas;
    @FXML
    private TableColumn<Gestion3, String> columnaNombre;
    @FXML
    private TableColumn<Gestion3, String> colApellidos;
    @FXML
    private TableColumn<Gestion3, Integer> columnaEdad;

    private ObservableList<Gestion3> listaPersonas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        columnaNombre.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        colApellidos.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getApellidos()));
        columnaEdad.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getEdad()));

        tablaPersonas.setItems(listaPersonas);
    }

    @FXML
    private void agregarPersona() {
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        int edad;
        try {
            edad = Integer.parseInt(txtEdad.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Edad inválida", "Por favor ingrese un número válido.");
            return;
        }

        listaPersonas.add(new Gestion3(nombre, apellidos, edad));
        txtNombre.clear();
        txtApellidos.clear();
        txtEdad.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

package controllers;

import application.Gestion4CLASE;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Gestion5Controller {

    @FXML
    private TableView<Gestion4CLASE> tablaPersonas;
    @FXML
    private TableColumn<Gestion4CLASE, String> columnaNombre, columnaApellidos;
    @FXML
    private TableColumn<Gestion4CLASE, Integer> columnaEdad;
    @FXML
    private Button btnAgregar, btnModificar, btnEliminar;

    private final ObservableList<Gestion4CLASE> listaPersonas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configurar columnas
        columnaNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        columnaApellidos.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());
        columnaEdad.setCellValueFactory(cellData -> cellData.getValue().edadProperty().asObject());

        tablaPersonas.setItems(listaPersonas);

        // Deshabilitar botones de modificar/eliminar si no hay selección
        btnModificar.setDisable(true);
        btnEliminar.setDisable(true);

        tablaPersonas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            boolean seleccion = newSelection != null;
            btnModificar.setDisable(!seleccion);
            btnEliminar.setDisable(!seleccion);
        });
    }

    @FXML
    private void abrirVentanaAgregar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/persona5.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Agregar Persona");
            stage.setScene(new Scene(loader.load()));

            Gestion5ControllerAg controlador = loader.getController();
            controlador.setListaPersonas(listaPersonas);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void eliminarPersona() {
        Gestion4CLASE seleccionada = tablaPersonas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            listaPersonas.remove(seleccionada);
        }
    }

    public void modificarPersona(ActionEvent actionEvent) {

    }
}

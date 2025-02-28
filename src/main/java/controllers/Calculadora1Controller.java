package controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class Calculadora1Controller {

    @FXML private TextField txtNum1;
    @FXML private TextField txtNum2;
    @FXML private TextField txtResultado;

    @FXML
    private void sumar() {
        try {
            double num1 = Double.parseDouble(txtNum1.getText());
            double num2 = Double.parseDouble(txtNum2.getText());
            double suma = num1 + num2;
            txtResultado.setText(String.valueOf(suma));
        } catch (NumberFormatException e) {
            txtResultado.setText("Error");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor, ingresa solo números.", ButtonType.OK);
            alert.show();
        }
    }
}

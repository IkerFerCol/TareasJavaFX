package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Calculadora2Controller {

    @FXML private TextField txtNum1;
    @FXML private TextField txtNum2;
    @FXML private TextField txtResultado;
    @FXML private RadioButton rbSuma;
    @FXML private RadioButton rbResta;
    @FXML private RadioButton rbMultiplicacion;
    @FXML private RadioButton rbDivision;

    private ToggleGroup operaciones;

    @FXML
    public void initialize() {
        operaciones = new ToggleGroup();
        rbSuma.setToggleGroup(operaciones);
        rbResta.setToggleGroup(operaciones);
        rbMultiplicacion.setToggleGroup(operaciones);
        rbDivision.setToggleGroup(operaciones);
    }

    @FXML
    private void operar() {
        try {
            double num1 = Double.parseDouble(txtNum1.getText());
            double num2 = Double.parseDouble(txtNum2.getText());
            double resultado = 0;

            if (rbSuma.isSelected()) {
                resultado = num1 + num2;
            } else if (rbResta.isSelected()) {
                resultado = num1 - num2;
            } else if (rbMultiplicacion.isSelected()) {
                resultado = num1 * num2;
            } else if (rbDivision.isSelected()) {
                if (num2 == 0) {
                    txtResultado.setText("Error: División por 0");
                    return;
                }
                resultado = num1 / num2;
            }

            txtResultado.setText(String.valueOf(resultado));

        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Número inválido");
        }
    }
}

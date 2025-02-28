package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;

public class Gestion4CLASE {
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty apellidos;
    private final SimpleIntegerProperty edad;

    public Gestion4CLASE(String nombre, String apellidos, int edad) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.edad = new SimpleIntegerProperty(edad);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(String apellidos) {
        this.apellidos.set(apellidos);
    }

    public int getEdad() {
        return edad.get();
    }

    public void setEdad(int edad) {
        this.edad.set(edad);
    }

    // Métodos Property (para TableView)
    public StringProperty nombreProperty() {
        return nombre;
    }

    public StringProperty apellidosProperty() {
        return apellidos;
    }

    public IntegerProperty edadProperty() {
        return edad;
    }
}

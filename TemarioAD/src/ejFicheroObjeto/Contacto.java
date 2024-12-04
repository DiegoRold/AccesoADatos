package ejFicheroObjeto;

import java.io.Serializable;

public class Contacto implements Serializable {
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correoElectronico;

    public Contacto(String nombre, String apellidos, String telefono, String correoElectronico) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getTelefono() { return telefono; }
    public String getCorreoElectronico() { return correoElectronico; }

    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellidos: " + apellidos + ", Teléfono: " + telefono + ", Correo: " + correoElectronico;
    }
}

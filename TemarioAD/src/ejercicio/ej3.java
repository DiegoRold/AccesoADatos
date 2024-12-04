package ejercicio;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class ej3 {

    static class Persona {
        String nombre;
        String apellido1;
        String apellido2;
        int anioNacimiento;

        Persona(String nombre, String apellido1, String apellido2, int anioNacimiento) {
            this.nombre = nombre;
            this.apellido1 = apellido1;
            this.apellido2 = apellido2;
            this.anioNacimiento = anioNacimiento;
        }

        @Override
        public String toString() {
            return String.format("Nombre: %s, Apellido1: %s, Apellido2: %s, Año de Nacimiento: %d",
                    nombre.trim(), apellido1.trim(), apellido2.trim(), anioNacimiento);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String rutaFichero = "personas.bin";

        try (DataInputStream dis = new DataInputStream(new FileInputStream(rutaFichero))) {
            while (true) {
                String nombre = leerString(dis, 20);
                String apellido1 = leerString(dis, 20);
                String apellido2 = leerString(dis, 20);
                int anioNacimiento = dis.readInt();

                Persona persona = new Persona(nombre, apellido1, apellido2, anioNacimiento);
                System.out.println(persona);
            }
        } catch (EOFException e) {
            // Fin del fichero alcanzado, se puede ignorar
        } catch (IOException e) {
            System.out.println("Se produjo un error al leer el fichero: " + e.getMessage());
        }
    }

    private static String leerString(DataInputStream dis, int longitud) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            sb.append(dis.readChar());
        }
        return sb.toString();
    }
}

package ejercicio;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ej2 {

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

        public void escribir(DataOutputStream dos) throws IOException {
            dos.writeChars(ajustarLongitud(nombre, 20));
            dos.writeChars(ajustarLongitud(apellido1, 20));
            dos.writeChars(ajustarLongitud(apellido2, 20));
            dos.writeInt(anioNacimiento);
        }

        private String ajustarLongitud(String texto, int longitud) {
            if (texto.length() > longitud) {
                return texto.substring(0, longitud);
            }
            return String.format("%-" + longitud + "s", texto);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        String rutaFichero = "personas.bin";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(rutaFichero))) {
            String continuar;
            do {
                System.out.print("Introduce el nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Introduce el primer apellido: ");
                String apellido1 = scanner.nextLine();
                System.out.print("Introduce el segundo apellido: ");
                String apellido2 = scanner.nextLine();
                System.out.print("Introduce el año de nacimiento: ");
                int anioNacimiento = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                Persona persona = new Persona(nombre, apellido1, apellido2, anioNacimiento);
                persona.escribir(dos);

                System.out.print("¿Quieres añadir otra persona? (s/n): ");
                continuar = scanner.nextLine();
            } while (continuar.equalsIgnoreCase("s"));

            System.out.println("Datos guardados en " + rutaFichero);
        } catch (IOException e) {
            System.out.println("Se produjo un error al escribir en el fichero: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}


package ejercicio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ej1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Crear un escáner para recibir la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar el nombre del archivo de entrada
        System.out.print("C:\\Users\\diego\\Desktop\\dir1\\articulos.txt ");
        String archivoEntrada = scanner.nextLine();

        // Solicitar el nombre del archivo de salida
        System.out.print("C:\\Users\\diego\\Desktop\\dir1\\articulos.txt");
        String archivoSalida = scanner.nextLine();

        // Copiar el archivo
        try (FileInputStream fis = new FileInputStream(archivoEntrada);
             FileOutputStream fos = new FileOutputStream(archivoSalida)) {

            // Buffer para leer el archivo
            byte[] buffer = new byte[1024];
            int longitud;

            // Leer y escribir el archivo en bloques de 1024 bytes
            while ((longitud = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, longitud);
            }

            System.out.println("Copia del archivo realizada con éxito.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al copiar el archivo: " + e.getMessage());
        }

        // Cerrar el escáner
        scanner.close();
    }
}

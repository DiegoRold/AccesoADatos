package ejFicheroAleatorio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ej2 {

    public static void mostrarContenidoFichero(String nombreFichero) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}

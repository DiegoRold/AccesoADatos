package ejFicheroAleatorio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ej1 {

    public static void escribirCalificaciones(ArrayList<String> nombres, int[] calificaciones, String nombreFichero) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero))) {
            for (int i = 0; i < nombres.size(); i++) {
                writer.write(nombres.get(i) + ": " + calificaciones[i]);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

}

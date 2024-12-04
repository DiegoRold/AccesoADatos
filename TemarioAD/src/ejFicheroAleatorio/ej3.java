package ejFicheroAleatorio;

import java.io.*;

public class ej3 {

    public static void actualizarCalificaciones(String nombreFichero) {
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(": ");
                String nombre = partes[0];
                int calificacion = Integer.parseInt(partes[1].trim());

                if (calificacion > 8) {
                    calificacion = Math.min(calificacion + 1, 10);
                } else if (calificacion < 5) {
                    calificacion += 0.5;
                }

                contenido.append(nombre).append(": ").append(calificacion).append("\n");
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al procesar el fichero: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero))) {
            writer.write(contenido.toString());
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}

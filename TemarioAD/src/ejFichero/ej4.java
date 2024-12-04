package ejFichero;

import java.io.*;

public class ej4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try (BufferedReader reader = new BufferedReader(new FileReader("texto.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("texto.txt", false))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String modifiedLine = line.replaceAll("[aeiouAEIOU]", "*$0");
                writer.write(modifiedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar contenido modificado
        try (BufferedReader reader = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

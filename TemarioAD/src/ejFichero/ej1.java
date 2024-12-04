package ejFichero;

import java.io.*;

public class ej1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try (BufferedReader reader = new BufferedReader(new FileReader("texto.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("invertido.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String invertedLine = new StringBuilder(line).reverse().toString();
                writer.write(invertedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar contenido de invertido.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("invertido.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

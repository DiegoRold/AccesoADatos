package ejFichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ej3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String filename = "texto.txt";
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("El fichero no existe.");
            return;
        }

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                wordCount += line.split("\\s+").length; // contar palabras
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Número de líneas: " + lineCount);
        System.out.println("Número de palabras: " + wordCount);
        System.out.println("Número de caracteres: " + charCount);
    }
}

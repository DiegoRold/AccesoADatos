package ejFichero;

import java.io.*;

public class ej7 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try (BufferedReader reader = new BufferedReader(new FileReader("texto.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("encriptado.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder encryptedLine = new StringBuilder();
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        char shifted = (char) ((c - 'a' + 3) % 26 + 'a');
                        if (Character.isUpperCase(c)) {
                            shifted = Character.toUpperCase(shifted);
                        }
                        encryptedLine.append(shifted);
                    } else {
                        encryptedLine.append(c);
                    }
                }
                writer.write(encryptedLine.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar contenido de encriptado.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("encriptado.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

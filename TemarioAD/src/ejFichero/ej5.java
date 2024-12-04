package ejFichero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ej5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la palabra a buscar: ");
        String palabraBuscada = scanner.nextLine();

        int contador = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("parrafo.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] palabras = line.split("\\W+");
                for (String palabra : palabras) {
                    if (palabra.equalsIgnoreCase(palabraBuscada)) {
                        contador++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("La palabra \"" + palabraBuscada + "\" aparece " + contador + " veces.");

    }
}

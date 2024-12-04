package ejFichero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ej2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de líneas a mostrar: ");
        int n = scanner.nextInt();

        try (BufferedReader reader = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null && count < n) {
                System.out.println(line);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

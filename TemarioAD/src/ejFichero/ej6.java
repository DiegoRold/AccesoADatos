package ejFichero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ej6 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Map<Integer, Integer> frecuencia = new HashMap<>();
        int total = 0;
        int count = 0;

        // Inicializar mapa
        for (int i = 0; i < 10; i++) {
            frecuencia.put(i, 0);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("numeros.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numeros = line.split(" ");
                for (String numStr : numeros) {
                    int num = Integer.parseInt(numStr);
                    frecuencia.put(num, frecuencia.get(num) + 1);
                    total += num;
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        double media = (count > 0) ? (double) total / count : 0;
        int moda = -1, maxFrecuencia = 0;

        try (FileWriter writer = new FileWriter("estadistica.txt")) {
            for (Map.Entry<Integer, Integer> entry : frecuencia.entrySet()) {
                writer.write("Número " + entry.getKey() + " – " + entry.getValue() + " veces\n");
                if (entry.getValue() > maxFrecuencia) {
                    maxFrecuencia = entry.getValue();
                    moda = entry.getKey();
                }
            }
            writer.write("Moda: " + moda + " Media: " + String.format("%.2f", media));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

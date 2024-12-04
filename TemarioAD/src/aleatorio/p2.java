package aleatorio;

import java.io.RandomAccessFile;
import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {

        long tamanno;
        int posicion = 0, entero;

        Scanner scanner = new Scanner(System.in);

        try {
            RandomAccessFile raf = new RandomAccessFile("C:\\Users\\diego\\Desktop\\dir1\\enteros1.dat", "rw");
            tamanno = raf.length() / 4;
            System.out.println("Tamaño: " + tamanno);
            //bucle do while

            do {
                System.out.println("Posición a modificar: ");
                posicion = scanner.nextInt();

            }while((posicion < 1) || (posicion > tamanno));
            posicion--;

            raf.seek(posicion * 4); //nos permite posicionarnos donde queremos
            System.out.println("Valor actual: " + raf.readInt());
            System.out.println("Nuevo valor: ");
            entero = scanner.nextInt();
            raf.seek(posicion * 4);
            raf.writeInt(entero);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

package aleatorio;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class p1 {

    static RandomAccessFile raf = null;

    public static void main(String[] args) {

        //crear metodo para mostrar fichero
        int entero;
        Scanner scanner = new Scanner(System.in);
        try {
            raf = new RandomAccessFile("C:\\Users\\diego\\Desktop\\dir1\\enteros1.dat", "rw");
            verDatos();
            System.out.println("Entero: ");
            entero = scanner.nextInt();
            raf.seek(raf.length());
            raf.writeInt(entero);
            verDatos();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public static void verDatos() {
        int numeroEntero;
        try {
            raf.seek(0);
            while(true) {
                numeroEntero = raf.readInt();
                System.out.println(numeroEntero);
            }
        } catch (EOFException e) {
            System.out.println("EOF");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

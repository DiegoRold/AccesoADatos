package ejFichero;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejExtra {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        String linea, palabra;


        RandomAccessFile raf = new RandomAccessFile("C:\\Users\\diego\\Desktop\\dir1\\articulos2.txt","rw");
        System.out.println("Palabra: ");
        palabra = sc.nextLine();

        //while para que nos devuelva línea por línea
        while((linea = raf.readLine()) !=null) {
            raf.seek(raf.getFilePointer()-linea.length() -1);
            raf.writeBytes(cambiaLinea(linea, palabra) + "\n");
        }
    }

    static String cambiaLinea(String linea, String palabra) {
        int indice;
        StringBuilder auxSB = new StringBuilder(linea);
        indice = auxSB.indexOf(palabra); //nos devuelve el indice con la posición
        //while para que nos busque por saltos la palabra que queremos modificar a mayusculas
        while(indice !=-1) {
            auxSB.replace(indice, indice + palabra.length(), palabra.toUpperCase());
            indice = auxSB.indexOf(palabra); //nos devuelve el indice con la posición
        }
        //ya tenemos modificadas las palabras
        return auxSB.toString();
    }
}

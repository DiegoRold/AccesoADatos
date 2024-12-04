package binario;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class p1EscribirBinario {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner (System.in);
        int codigoArticulo;
        double precio;

        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\diego\\Desktop\\dir1\\articulos.txt");
            DataOutputStream dos = new DataOutputStream(fos);

            System.out.println("Código de artículo: ");
            codigoArticulo = sc.nextInt();

            while(codigoArticulo != 0) {
                dos.writeInt(codigoArticulo);
                System.out.println("Precio: ");
                precio = sc.nextDouble();
                dos.writeDouble(precio);
                System.out.println("Código artículo: ");
                codigoArticulo = sc.nextInt();
            }
        }catch (IOException e) {

            e.printStackTrace();
        }

    }
}

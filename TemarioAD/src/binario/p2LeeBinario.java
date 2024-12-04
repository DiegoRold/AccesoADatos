package binario;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class p2LeeBinario {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FileInputStream fis;
        try {
            fis = new FileInputStream("C:\\Users\\diego\\Desktop\\dir1\\articulos.txt");
            DataInputStream dis = new DataInputStream(fis);

            while(dis.available()>0) {
                int codigoArticulo = dis.readInt();
                double precio = dis.readDouble();
                System.out.println("Artículo: " + codigoArticulo + "\tPrecio: " + precio);
            }
        }catch (IOException e) {

            e.printStackTrace();
        }
    }
}

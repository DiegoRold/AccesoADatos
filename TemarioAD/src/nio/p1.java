package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class p1 {

    public static void operacionesNIO(String operacion) throws IOException {

        //creamos PATH de fichero y otro de directorio
        Path pathf = Paths.get("C:\\Users\\diego\\Desktop\\dir2\\nio1.txt");
        Path pathd = Paths.get("C:\\Users\\diego\\Desktop\\dir2\\NIO1\\NIO2");
        Path pathdFich = Paths.get(pathd + "/fff.txt");
        Path pathOrigen = Paths.get("C:\\Users\\diego\\Desktop\\dir2\\aleatorio1.txt");
        Path pathDestino = Paths.get("C:\\Users\\diego\\Desktop\\dir2\\aleatorio1_copia.txt");

        //para cargar y ver si existe o no el fichero
        switch(operacion) {
            case "existe":
                boolean existe = Files.exists(pathf, new LinkOption[] {LinkOption.NOFOLLOW_LINKS});
                System.out.println("Existe: " + existe);
                break;

            //creamos el directorio
            case "crear":
                Path nuevoPath = Files.createDirectories(pathd); //le hacemos un throws para resolver el error.
                break;

            //copiar
            case "copiar":
                Files.copy(pathOrigen, pathDestino);
                break;

            //mover
            case "mover":
                Files.move(pathDestino, pathdFich, new LinkOption[] {LinkOption.NOFOLLOW_LINKS});
                break;

            //elminar
            case "eliminar":
                Files.delete(pathdFich);
                break;
        }



    }

    //para leer el contenido del fichero
    public static void leer() throws IOException {
        Path path = Paths.get("C:\\Users\\diego\\Desktop\\dir2\\aleatorio1.txt");
        byte[] bytes = Files.readAllBytes(path); //hacemos un throws
        for (byte b : bytes) {
            System.out.print((char) b);
        }
    }

    //escribir en el fichero
    public static void escribir() throws IOException {
        Path path = Paths.get("C:\\Users\\diego\\Desktop\\dir2\\aleatorio1.txt");
        String texto = "pues feliz jalogúin";
        Files.write(path, texto.getBytes()); //declaramos throws
    }

    //Escribir por canal
    public static void escribirPorChannel() throws IOException {
        RandomAccessFile file = new RandomAccessFile("C:\\Users\\diego\\Desktop\\dir2\\f1.txt", "rw"); //tenemos que hacer throws

        //importamos FileChannel
        FileChannel channel = file.getChannel();
        String texto = "ola k ase";

        //allocate sirve para reserva el tamaño e indicamos el tamaño
        ByteBuffer buf = ByteBuffer.allocate(128);
        buf.clear();

        //obtenemos los bytes del texto
        buf.put(texto.getBytes());
        buf.flip();

        //vamos a escribir el flip al canal con un bucle
        while(buf.hasRemaining()) {
            channel.write(buf); //hacemos throws
        }
        file.close();

    }

    //Leer por el canal
    public static void leerPorChannel() throws IOException {
        RandomAccessFile file = new RandomAccessFile("C:\\Users\\diego\\Desktop\\dir2\\f1.txt", "rw"); //otro throws
        FileChannel channel = file.getChannel();
        long size = channel.size();
        ByteBuffer buf = ByteBuffer.allocate((int) size);
        int BytesRead = channel.read(buf);

        //coge todos los caracteres
        while (BytesRead != -1) {
            System.out.println("Leídos: " + BytesRead); //saber cuantos bytes hemos leido
            buf.flip(); //leemos

            //para pillar todos los caracteres y mostrarlos en pantalla
            while(buf.hasRemaining()) {
                System.out.println((char) buf.get()); //vamos a obtener datos mientras haya
            }
            buf.clear(); //cambiamos a modo escritura
            BytesRead = channel.read(buf);
        }
        file.close();
    }

    public static void main(String[] args) throws IOException { //hemos hecho un throws a operacionesNIO("existe")
        //operacionesNIO("eliminar"); //pones la acción deseada.
        //leer();
        //escribir(); //en el caso de que contenga contenido, lo sobreescribe.
        //escribirPorChannel();
        leerPorChannel();
    }
}

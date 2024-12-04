package ejNio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ej {

    public static void main(String[] args) {

        //Las rutas de acceso
        Path sourcePath = Path.of("C:\\Users\\diego\\Desktop\\dir2\\aleatorio1.txt"); //ruta de copia
        Path destinationPath = Path.of("C:\\Users\\diego\\Desktop\\dir2\\destino.txt"); //ruta de destino

        //definir tamaño de buffers
        int buffersSize = 1024;
        ByteBuffer buffer = ByteBuffer.allocate(buffersSize);

        //aqui copiamos el archivo
        try(
                FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
                FileChannel destinationChannel = FileChannel.open(destinationPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        ){

            //Lo leemos y lo creamos en un bucle
            while(sourceChannel.read(buffer) > 0) {
                buffer.flip(); //se prepara el buffer para poder escribir
                destinationChannel.write(buffer);
                buffer.clear(); //limpiamos el buffer para la siguiente lectura
            }

            System.out.println("Archivo copiado correctamente.");

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}

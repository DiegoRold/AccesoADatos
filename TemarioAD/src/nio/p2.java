package nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class p2 {

    public static void main(String[] args) throws FileNotFoundException {

        RandomAccessFile file = new RandomAccessFile("C:\\Users\\diego\\Desktop\\dir2\\f2.txt", "rw"); //otro throws
        FileChannel channel = file.getChannel();
        ByteBuffer miBuffer = ByteBuffer.allocate(12);

        miBuffer.put((byte) 'H');
        miBuffer.put((byte) 'o');
        miBuffer.put((byte) 'l');
        miBuffer.put((byte) 'a');
        System.out.println(miBuffer.toString());

        miBuffer.flip();
        System.out.println(miBuffer.toString());

        System.out.println((char) miBuffer.get());
        System.out.println((char) miBuffer.get());
        System.out.println((char) miBuffer.get());
        System.out.println((char) miBuffer.get());
        System.out.println(miBuffer.toString());

        miBuffer.clear();
        System.out.println(miBuffer.toString());

        System.out.println((char) miBuffer.get());
        System.out.println((char) miBuffer.get());
        System.out.println(miBuffer.toString());

        miBuffer.compact();
        miBuffer.flip();
        System.out.println(miBuffer.toString());
        System.out.println((char) miBuffer.get());
        System.out.println((char) miBuffer.get());
        System.out.println(miBuffer.toString());
    }
}

package listar;

import java.io.File;

public class FilePrinter {

    public void printFiles(File [] files) {
        if(files != null && files.length > 0) {
            for(File fich : files) {
                System.out.println("Elemento: " + fich.toString());
            }
        } else {
            System.out.println("No se ha encontrado archivos");
        }
    }
}
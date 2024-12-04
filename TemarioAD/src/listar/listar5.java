package listar;

import java.io.File;
import java.io.FileFilter;

public class listar5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        File dir = new File("C:\\Users\\diego\\Desktop\\DAM\\2o año\\Materias\\Acceso a Datos\\Proyectos Eclipse\\listado");

        //FileFilter filtroTamanno = (File file) -> file.isFile() && file.length()  1024;
        FileFilter filtroTamanno = file -> file.isFile() && file.length() > 1024;

        File [] ficherosFiltrados = dir.listFiles(filtroTamanno);
        for (File file : ficherosFiltrados) {
            System.out.println("Archivo: " + file.getName() + "(Tamaño: " + file.length() + "bytes");
        }

    }
}

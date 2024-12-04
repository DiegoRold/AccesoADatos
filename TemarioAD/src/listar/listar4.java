package listar;

import java.io.File;
import java.io.FileFilter;

public class listar4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //FileFilter
        File dir = new File("C:\\Users\\diego\\Desktop\\DAM\\2o año\\Materias\\Acceso a Datos\\Proyectos Eclipse\\listado");
        FileFilter filtroTamanno = new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                // TODO Auto-generated method stub
                return pathname.isFile() && pathname.length() > 1024;
            }

        };

        File [] ficherosFiltrados = dir.listFiles(filtroTamanno);
        for (File file : ficherosFiltrados) {
            System.out.println("Archivo: " + file.getName() + "(Tamaño: " + file.length() + "bytes");
        }
    }
}

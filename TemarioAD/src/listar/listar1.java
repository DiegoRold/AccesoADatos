package listar;

import java.io.File;
import java.io.FilenameFilter;

public class listar1 implements FilenameFilter {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //Filefich: te hace una lista de todos los ficheros encontrados en el directorio
        File dir = new File("C:\\Users\\diego\\Desktop\\DAM\\2o año\\Materias\\Acceso a Datos\\Proyectos Eclipse\\listado");
        File [] lista = dir.listFiles();
        for(File fich : lista) {
            System.out.println("Elemento: " + fich.toString());
        }

        //FilenameFilter: te lista los ficheros por el formato deseado
        System.out.println("-------------------------");
        listar1 objetoListar = new listar1();
        lista = dir.listFiles(objetoListar);
        for(File fich : lista) {
            System.out.println("Elemento: " + fich.toString());
        }



    }

    @Override //este metodo viene del FilenameFilter
    public boolean accept(File dir, String name) {
        // TODO Auto-generated method stub
        return name.contains("1");
    }
}

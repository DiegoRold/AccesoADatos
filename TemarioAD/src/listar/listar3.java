package listar;

import java.io.File;

public class listar3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        File dir = new File("C:\\Users\\diego\\Desktop\\DAM\\2o año\\Materias\\Acceso a Datos\\Proyectos Eclipse\\listado");
        //listar1 objetoListar = new listar1();
        File [] lista = dir.listFiles((d, name) -> name.endsWith(".docx")); //d es directorio
        for(File fich : lista) {
            System.out.println("Elemento: " + fich.toString());
        }
    }
}

package listar;

import java.io.File;

public class listarMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File dir = new File("C:\\Users\\diego\\Desktop\\DAM\\2o año\\Materias\\Acceso a Datos\\Proyectos Eclipse\\listado");
        TxtFileFilter txtFilter = new TxtFileFilter();
        File [] txtFiles = dir.listFiles(txtFilter);

        FilePrinter printer = new FilePrinter();
        printer.printFiles(txtFiles);
    }
}

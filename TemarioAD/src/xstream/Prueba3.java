package xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

public class Prueba3 {

    public static void main(String[] Args) {
        //XStream xStream = new XStream(new StaxDriver());
        XStream xStream1 = new XStream(new DomDriver());//Esto hara que XStream trabaje con el DOM
        // y lo ejecute en la terminal más bonito.
        xStream1.allowTypes(new Class[] { Libro.class });

        xStream1.alias("Escritor", Autor.class);
        xStream1.aliasField("seudonimo", Autor.class, "nombre");

        //Al momento de crear el archivo.xml, entonces usarlo con el 'File' y no con el 'NIO'
        XmlArrayList lista = new XmlArrayList((new FilePersistenceStrategy(new File("C:\\dir1\\xstream"),
                xStream1)));
        //Te crea varios archivos .xml con el listado de autores. VENTAJAS: No tengo que crear
        // multiples archivos, solo uno con la lista de autores.

        lista.add(new Autor("Camilo Jose Cela"));
        lista.add(new Autor("JRR Tolkien"));
        lista.add(new Autor("Jorge Luis Borges"));
        lista.add(new Autor("Gabriel Garcia Marquez"));
        //Verificar en el directorio C:\\dir1 los archivos creados.

        Autor error = new Autor("error");
        lista.add(error);
        //El error se guarda en el archivo.xml
    }
}

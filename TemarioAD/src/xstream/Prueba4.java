package xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

import java.io.File;
import java.util.Iterator;

public class Prueba4 {

    public static void main(String[] Args) {
        XStream xStream1 = new XStream(new DomDriver());
        xStream1.allowTypes(new Class[]{Libro.class, Autor.class});

        xStream1.alias("Escritor", Autor.class);
        xStream1.aliasField("seudonimo", Autor.class, "nombre");

        XmlArrayList lista = new XmlArrayList((new FilePersistenceStrategy(new File("C:\\dir1\\xstream"), xStream1)));

        for (Iterator it = lista.iterator(); it.hasNext(); ) {
            Autor autor = (Autor) it.next();
            if (autor.getNombre().equals("error")) {
                System.out.println("Borrando el error");
                it.remove();
            } else {
                System.out.println("Manteniendo: " + autor.getNombre());
            }
            System.out.println(autor.getNombre());
        }
    }
}

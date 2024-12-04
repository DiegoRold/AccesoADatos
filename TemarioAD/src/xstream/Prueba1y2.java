package xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Prueba1y2 {

    public static void main(String[] Args) {
        //XStream xstream = new XStream(new StaxDriver());
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypes(new Class[]{Persona.class, Telefono.class, Autor.class, Libro.class});

        // Asignación de alias para clases
        xstream.alias("persona", Persona.class);
        xstream.alias("telefono", Telefono.class);
        xstream.alias("autor", Autor.class);
        xstream.alias("libro", Libro.class);

        // Creación de objetos y conversión a XML
        Telefono tel = new Telefono();
        tel.setCodigo(34);
        tel.setNumero(666666666);
        Persona persona = new Persona();
        persona.setNombre("Laura");
        persona.setApellido("Pérez");
        persona.setTelefono(tel);

        String xml = xstream.toXML(persona);
        System.out.println("XML de Persona:\n" + xml);
        System.out.println("\n");

        Persona persona2 = (Persona) xstream.fromXML(xml);
        System.out.println("Objeto persona: " + persona2);
        System.out.println("\n");

        Libro libro = new Libro();
        libro.setTitulo("El Principito");
        libro.setAutor(String.valueOf(new Autor("Lev Tolstoi")));
        libro.setEditorial("Planeta");

        String xmlLibro = xstream.toXML(libro);
        System.out.println("XML de Libro:\n" + xmlLibro);
        System.out.println("\n");

        Libro libro2 = (Libro) xstream.fromXML(xmlLibro);
        System.out.println("Objeto libro: " + libro2);
        System.out.println("\n");
    }
}

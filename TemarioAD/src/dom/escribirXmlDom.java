package dom;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class escribirXmlDom {

    public static void main(String[] args) throws Exception {

        //Ruta del fichero XML
        File fichero = new File("C:\\Users\\diego\\Desktop\\dir3\\coches.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder(); //se hace throws

        Document doc = dbBuilder.newDocument();

        //Crear tipo array
        Element eRaiz = doc.createElement("concesionario");

        //añadir al documento
        doc.appendChild(eRaiz);

        //definir nodo que va a contener los elementos
        Element eCoche = doc.createElement("coche");

        //añadir al elemento eraiz
        eRaiz.appendChild(eCoche);

        //creamos un elemento usando la clase attr
        Attr attr = doc.createAttribute("id");

        //le colocamos valor
        attr.setValue("1");

        //al coche le colocamos el atributo
        eCoche.setAttributeNode(attr);

        //creamos el elemento marca
        Element eMarca = doc.createElement("marca");

        //añadimos el hijo
        eMarca.appendChild(doc.createTextNode("Renault"));

        //se lo añadimos al elemento coche
        eCoche.appendChild(eMarca);

        //creamos el elemento modelo
        Element eModelo = doc.createElement("modelo");

        //añadimos el hijo
        eModelo.appendChild(doc.createTextNode("Megane"));

        //se lo añadimos al elemento coche
        eCoche.appendChild(eModelo);

        //creamos el elemento cilindrada
        Element eCilindrada = doc.createElement("cilindrada");

        //añadimos el hijo
        eCilindrada.appendChild(doc.createTextNode("1.1"));

        //se lo añadimos al elemento coche
        eCoche.appendChild(eCilindrada);


        //sirve para crear xml
        TransformerFactory tf = TransformerFactory.newInstance();

        //creamos con transformer
        Transformer tr = tf.newTransformer();

        //para escribir en fichero
        DOMSource source = new DOMSource(doc);

        //para escribir a xml
        StreamResult result = new StreamResult(fichero);
        tr.transform(source, result);







    }
}

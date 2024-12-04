package dom;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class leerXmlDomDesconocido {

    public static void main(String[] args) throws Exception {

        //Ruta del fichero XML
        File fichero = new File("C:\\Users\\diego\\Desktop\\dir3\\concesionario.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder(); //se hace throws

        Document doc = dbBuilder.parse(fichero); //otro throws

        //en en main modificamos los throws y ponemos throws Exception

        doc.getDocumentElement().normalize();

        procesaNodo(doc.getDocumentElement());
    }

    public static void procesaNodo(Node nodo) {
        if(nodo.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println("Elemento: " + nodo.getNodeName());
            NamedNodeMap atributos = nodo.getAttributes();
            for(int i=0; i<atributos.getLength(); i++) {
                Node atributo = atributos.item(i);
                System.out.println("Atributo: " + atributo.getNodeName() + "Valor: " + atributo.getNodeValue());
            }
        }

        if(nodo.getNodeType() == Node.TEXT_NODE && !nodo.getTextContent().trim().isEmpty()) {
            System.out.println("Texto: " + nodo.getTextContent());
        }

        NodeList nodosHijos = nodo.getChildNodes();
        for(int i=0; i<nodosHijos.getLength(); i++) {
            procesaNodo(nodosHijos.item(i));
        }

    }
}

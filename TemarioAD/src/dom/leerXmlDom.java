package dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class leerXmlDom {

    public static void main(String[] args) throws Exception {

        //Ruta del fichero XML
        File fichero = new File("C:\\Users\\diego\\Desktop\\dir3\\coches.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder(); //se hace throws

        Document doc = dbBuilder.parse(fichero); //otro throws

        //en en main modificamos los throws y ponemos throws Exception

        doc.getDocumentElement().normalize();

        //obtenemos una lista de los nodos
        NodeList nList = doc.getElementsByTagName("coche");

        //imprimir nº de coches
        System.out.println("Nº coches: " + nList.getLength());

        for(int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            //selecionamos el elemento del node, en este caso "coche"
            Element eElement = (Element) nNode; //le hacemos un cash al Element

            //imprimimos el id del coche
            System.out.println("Coche id: " + eElement.getAttribute("id"));

            //ahora cogemos el modelo, marca y cilindrada
            System.out.println("\tMarca: " + eElement.getElementsByTagName("marca").item(0).getTextContent());
            System.out.println("\tModelo: " + eElement.getElementsByTagName("modelo").item(0).getTextContent());
            System.out.println("\tCilindrada: " + eElement.getElementsByTagName("cilindrada").item(0).getTextContent());
        }

    }
}

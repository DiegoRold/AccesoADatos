package sax;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

public class leerXmlSax {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        DefaultHandler handler = new DefaultHandler() {
            boolean bNombre = false;
            boolean bUserName= false;
            boolean bPassword = false;

            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("inicia el elemento: "+ qName);//nombre del elemento en qName
                if(qName.equalsIgnoreCase("empleado")) {
                    String id = attributes.getValue("id");
                    System.out.println("Id: "+ id);
                }
                if (qName.equalsIgnoreCase("nombre")) {
                    bNombre = true;
                }
                if (qName.equalsIgnoreCase("username")) {
                    bUserName = true;
                }
                if (qName.equalsIgnoreCase("password")) {
                    bPassword = true;
                }
            }

            public void endElement (String uri, String localName, String qName){
                System.out.println("Finaliza elemento: " + qName);
            }

            public void characters(char[] ch, int start, int length){
                if(bNombre) {
                    System.out.println("Nombre: "+ new String(ch, start, length));
                    bNombre = false;
                }
                if(bUserName) {
                    System.out.println("Username: "+ new String(ch, start, length));
                    bUserName = false;
                }
                if(bPassword) {
                    System.out.println("Password: "+ new String(ch, start, length));
                    bPassword = false;
                }
            }
        };

        File archivo = new File("C:\\dir1\\empresa.xml");//donde está el fichro
        InputStream inputStream = new FileInputStream(archivo);
        Reader lector = new InputStreamReader(inputStream, "UTF-8");
        InputSource is = new InputSource(lector);
        saxParser.parse(archivo, handler);//parseamos el fichero con el handler
    }
}

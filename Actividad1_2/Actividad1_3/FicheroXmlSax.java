package ficheros.act03;

import java.io.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

public class FicheroXmlSax {
    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            XMLReader procesadorXML = spf.newSAXParser().getXMLReader();
            GestionContenido gestor = new GestionContenido();
            procesadorXML.setContentHandler(gestor);
            InputSource archivoXML = new InputSource(".\\ficheros\\act03\\alumnos.xml");
            procesadorXML.parse(archivoXML);            
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            System.err.printf(ex.getMessage());
        }


    }
}

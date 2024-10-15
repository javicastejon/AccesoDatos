package ficheros.act03;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestionContenido extends DefaultHandler{
    public GestionContenido(){
        super();
    }

    @Override
    public void startDocument(){
        System.out.println("Comienzo del documento XML");
    }

    @Override
    public void endDocument(){
        System.out.println("Fin del documento XML");
    }

    @Override
    public void startElement(String uri, String nombre, String nombrec, Attributes atts){
        System.out.printf("\tPrincipio de elemento: %s %n", nombre);
    }

    @Override
    public void endElement(String uri, String nombre, String nombrec){
        System.out.printf("\tFin de elemento: %s %n", nombre);
    }

    @Override
    public void characters(char[] ch, int inicio, int longitud) throws SAXException{
        String car = new String(ch, inicio, longitud);
        car = car.replaceAll("[\t\n]","");  //Eliminar saltos de linea
        System.out.printf("\tCaracteres: %s %n", car);
    }
}

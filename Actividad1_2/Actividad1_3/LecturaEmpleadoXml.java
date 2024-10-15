package ficheros.act03;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class LecturaEmpleadoXml {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("./ficheros/act03/Empleados.xml"));
            document.getDocumentElement().normalize();
            
            System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());

            // Generar lista XML
            NodeList empleados = document.getElementsByTagName("empleado");
            System.out.println("El número de empleados es: " + empleados.getLength());

            // Recorremos la lista de nodos
            for(int i=0; i < empleados.getLength(); i++){
                Node empleado = empleados.item(i); //Recupera cada nodo
                if(empleado.getNodeType() == Node.ELEMENT_NODE){
                    Element elemento = (Element) empleado;
                    System.out.printf("ID: %s, Apellido: %s, Dpto: %s, Salario: %s %n", 
                    elemento.getElementsByTagName("id").item(0).getTextContent(),
                    elemento.getElementsByTagName("apellido").item(0).getTextContent(),
                    elemento.getElementsByTagName("departamento").item(0).getTextContent(),
                    elemento.getElementsByTagName("salario").item(0).getTextContent()
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

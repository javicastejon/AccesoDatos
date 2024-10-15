package ficheros.act03;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class CrearEmpleadoXml{
    static File fichero = new File("./ficheros/act03/Fichaleatorio.dat");
    public static void main(String[] args) throws IOException{
        RandomAccessFile rafread = new RandomAccessFile(fichero, "r");
        int id, departamento, posicion=0;
        Double salario;
        char apellido[] = new char[10], aux;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0");

            // Leer fichero aleatorio y lanzar DOM builder para el XML
            while(rafread.getFilePointer() < rafread.length()){
                rafread.seek(posicion);  //Nos posicionamos al principio del fichero
                id = rafread.readInt(); //El primer campo es el id del empleado
                for(int i=0;i<apellido.length;i++){
                    aux = rafread.readChar();
                    apellido[i] = aux;
                }

                String apellidoEmp = new String(apellido);  //Conversión array a string
                departamento = rafread.readInt();
                salario = rafread.readDouble();
                if (id>0){
                    Element raiz = document.createElement("empleado");
                    document.getDocumentElement().appendChild(raiz);
                    // Elemento ID
                    CrearElemento("id", Integer.toString(id), raiz, document);
                    // Elemento Apellido
                    CrearElemento("apellido", apellidoEmp.trim(), raiz, document);
                    // Elemento Departamento
                    CrearElemento("departamento", Integer.toString(departamento), raiz, document);
                    // Elemento Salario
                    CrearElemento("salario", Double.toString(salario), raiz, document);
                }
                posicion = posicion + 36;
            }

            //Grabar fichero XML
            Source source = new DOMSource(document);
            Result result = new StreamResult(new File("./ficheros/act03/Empleados.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (Exception e){
            System.err.println("Error: " + e);
        }
        rafread.close();  // IMPORTANTE: Siempre cerrar el fichero
    }

    static void CrearElemento(String clave, String valor, Element raiz, Document documento){
        Element elemento = documento.createElement(clave);
        Text nodoTexto = documento.createTextNode(valor);
        raiz.appendChild(elemento);
        elemento.appendChild(nodoTexto);
    }
}
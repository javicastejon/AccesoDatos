package ficheros.act03;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;


public class CrearEmpleadoXml{
    

    public static void main(String[] args) throws IOException{
        Empleado[] listaEmpleados = {
            new Empleado(1, "BAYO",10 ,20.00),
            new Empleado(2, "PEREZ",20 ,20.00),
            new Empleado(3, "MATUTE",30 ,20.00)
        };


        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0");


            // Leer datos y lanzar DOM builder para el XML
            for (Empleado empleado : listaEmpleados) {
                if (empleado.getId()>0){
                    Element raiz = document.createElement("empleado");
                    document.getDocumentElement().appendChild(raiz);
                    // Elemento ID
                    CrearElemento("id", Integer.toString(empleado.getId()), raiz, document);
                    // Elemento Apellido
                    CrearElemento("apellido", empleado.getApellido().trim(), raiz, document);
                    // Elemento Departamento
                    CrearElemento("departamento", Integer.toString(empleado.getDepartamento()), raiz, document);
                    // Elemento Salario
                    CrearElemento("salario", Double.toString(empleado.getSalario()), raiz, document);
                }
            }

            //Grabar fichero XML
            Source source = new DOMSource(document);
            Result result = new StreamResult(new File("./ficheros/act03/Empleados.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (Exception e){
            System.err.println("Error: " + e);
        }
    }

    static void CrearElemento(String clave, String valor, Element raiz, Document documento){
        Element elemento = documento.createElement(clave);
        Text nodoTexto = documento.createTextNode(valor);
        raiz.appendChild(elemento);
        elemento.appendChild(nodoTexto);
    }
}

class Empleado {
    Integer id;
    String apellido;
    Integer departamento;
    Double salario;
   
    public Empleado(Integer id, String apellido, Integer departamento, Double salario) {
        this.id = id;
        this.apellido = apellido;
        this.departamento = departamento;
        this.salario = salario;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Integer getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Integer departamento) {
        this.departamento = departamento;
    }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }   
}

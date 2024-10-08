/*** 
ESCRIBIR FICHERO (FileWriter)
- En esta práctica hay que crear un fichero de texto con un editor cualquiera y después modificar su contenido con la clase FileWriter.  Añadir un carácter cualquiera al final del fichero (p.e. una coma).
- En el mismo código, añadir una sección en la que escriba el contenido de un String[] el fichero.
***/
package ficheros.act02;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class EscribirFicheroTexto {
    public static void main(String[] args) throws IOException {
        //Crear flujo de salida
        //La ruta tiene que existir, el fichero lo creará si no existe
        //El modificador true al final de FileWriter especifica que se anexará el contenido.  Si no estuviese, borraría el contenido previo
        File archivo = new File("C:\\Repos\\DAM2\\UD1_Ficheros\\Actividad2\\Ejemplo_escritura.txt");
        try (FileWriter fw = new FileWriter(archivo,true)) {
            String cadena = "Texto de ejemplo para agregar al fichero\n";
            char[] arrCadena = cadena.toCharArray();   
            for (int i=0; i< cadena.length(); i++){
                fw.write(arrCadena[i]);
            }
            fw.append("Fin\n\n");

            String[] ciudades = {"Zaragoza", "Huesca", "Teruel"};
            for (int i=0; i< ciudades.length; i++){
                fw.write(ciudades[i]+"\n");
            }
            
            fw.append("Fin ciudades");
            fw.close();  // Redundante.  En este ejemplo, la propia instancia de FileWriter gestiona el cierre del fichero  
        } catch (FileNotFoundException e) {
            throw e; // Aquí se implementaría la gestión de esta excepción (reintento, mensaje, llamada a otro método...)
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }    

    }   
}

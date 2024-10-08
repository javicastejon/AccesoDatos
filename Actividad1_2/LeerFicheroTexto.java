/*** 
 LEER FICHERO (FileReader)
 - Leer el contenido de un fichero en grupos de 20 en 20.  
 Probar a realizar la declaración directamente con la clase FileReader (sin crear un objeto File)
 ***/
package ficheros.act02;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroTexto {
    public static void main(String[] args) throws IOException{
        // Crear el flujo de entrada hacia el fichero
        // En la ruta hay que indicar un fichero que exista
        FileReader fic = new FileReader("C:\\Repos\\DAM2\\UD1_Ficheros\\Actividad2\\Ejemplo_lectura.txt");
        int i;
        char[] lector = new char[10];
        while ((i = fic.read(lector)) != -1){
            System.out.println(lector);
        }
            
        fic.close();  // Muy importante.  Cerrar siempre el fichero una vez finalizado el proceso de lectura/escritura

    }
}
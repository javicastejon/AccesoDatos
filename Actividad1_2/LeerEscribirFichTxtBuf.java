/*** 
LEER Y ESCRIBIR FICHERO POR LÍNEAS CON BUFFER:
- Leer un fichero línea por línea y mostrarlo por pantalla.  
- Después, modificar el contenido del fichero del fichero (p.e. agregar el número de línea al principio) y volver a visualizar el contenido por pantalla. 
***/
package ficheros.act02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LeerEscribirFichTxtBuf {
    public static void main(String[] args) {
        //Lectura de fichero
        try {
            BufferedReader ficheroRead = new BufferedReader(new FileReader("C:\\Repos\\DAM2\\ficheros\\act02\\Ejemplo_lectura.txt"));
            //Con el método readLine se recupera el contenido línea por línea
            String linea;
            while((linea = ficheroRead.readLine()) != null)
                System.out.println(linea);
            ficheroRead.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("Error de E/S");
        }

        //Escritura del fichero
        try {
            BufferedWriter ficheroWrite = new BufferedWriter(new FileWriter("C:\\Repos\\DAM2\\ficheros\\act02\\Ejemplo_escritura.txt"));
            for(int i=0; i<11; i++){
                ficheroWrite.write("Linea del fichero numero: " + i);
                ficheroWrite.newLine(); // Salto de línea
            }
            ficheroWrite.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("Error de E/S");
        }
    }
    
}

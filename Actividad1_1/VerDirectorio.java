package Actividad1_1;

/***
LEER FICHERO:
- Utiliza el método list() para recuperar una lista de los archivos del directorio actual.
- Muestra por pantalla si cada elemento recuperado del directorio es un archivo o un directorio.
 ***/
import java.io.File;

public class VerDirectorio {
    public static void main(String[] args) {
        String dir = ".";
        File f = new File(dir);
        String[] archivos = f.list();
        System.out.printf("Ficheros del directorio actual: %d %n", archivos.length);
        for(int i = 0; i < archivos.length; i++){
            File f2 = new File(archivos[i]);
            System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", archivos[i], f2.isFile(), f2.isDirectory());
        }
    }
    
}

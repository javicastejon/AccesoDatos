package Actividad1_1;

/*** 
MANEJO DE DIRECTORIOS
- Crea un nuevo directorio, dentro crea dos ficheros.  
- Una vez creados, renombra uno de los archivos y elimina el otro.  Se debe utilizar manejo de excepciones (IOException).
 ***/
import java.io.File;
import java.io.IOException;

public class CrearDirectorio {
    public static void main(String[] args) {
        File d = new File("NUEVODIRECTORIO");
        File f1 = new File(d,"FICHERO1.TXT");
        File f2 = new File(d,"FICHERO2.TXT");

        d.mkdir();
        try {
            if (f1.createNewFile())
                System.out.println("Fichero 1 creado correctamente.");
            else 
                System.out.println("Error al crear el fichero 1");
            
            if (f2.createNewFile())
                System.out.println("Fichero 2 creado correctamente.");
            else 
                System.out.println("Error al crear el fichero 2");
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        f1.renameTo(new File(d,"FICHERO1NUEVO"));

        try {
            File f3 = new File("NUEVODIRECTORIO/FICHERO3.TXT");
            f3.createNewFile();
        } catch (IOException ioe) { ioe.getStackTrace(); }

        if(f2.delete()){
            System.out.println("Fichero 2 borrado");
        }
        else
            System.out.println("No se ha podido eliminar el fichero2");

    }
}

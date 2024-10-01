package Actividad1_1;

/*** 
LISTAR PROPIEDADES
- Realiza un programa Java que utilice el método listFiles() de la clase File para mostrar la lista de ficheros en un directorio cualquiera.
- Realiza un programa en Java que muestre los ficheros de un directorio.  El nombre del directorio se pasará al programa desde los argumentos de main().  
- Si el directorio no existe se debe mostrar un mensaje indicándolo.  Recupera 6 propiedades (las que prefieras) de cada fichero y muéstralas por pantalla.
 ***/
import java.io.File;

class VerInfoDir{
    public static void main(String[] args){
        File f = new File(".");
        String[] listDir = f.list();

        for (int i = 0; i < listDir.length; i++){
            File f2 = new File (listDir[i]);
            if (f2.exists()){
                System.out.println("Información del archivo: " + f2.getName());
                System.out.println("Ruta: " + f2.getPath());
                System.out.println("Ruta absoluta: " + f2.getAbsolutePath());
                System.out.println("Tamaño: " + f2.length());
                System.out.println("Es un directorio: " + f2.isDirectory());
                System.out.println("Es un archivo: " + f2.isFile());
                System.out.println("Se puede leer: " + f2.canRead());
            }
            else {
                System.out.println("El fichero no existe.");
            }
        }        
    }

}

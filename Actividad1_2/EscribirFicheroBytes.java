package ficheros.act02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirFicheroBytes {
    public static void main(String[] args) {
        File fichero = new File("C:\\Repos\\DAM2\\ficheros\\act02\\Ejemplo_escritura.dat");
        //Crea un flujo de salida hacia el fichero
        try(FileOutputStream fileout = new FileOutputStream(fichero)) {
            for(int i=0; i <100; i++)
                fileout.write(i);           
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("Error de E/S");
        }

        //Crea un flujo de entrada desde el fichero
        int i;
        try(FileInputStream filein = new FileInputStream(fichero)) {
            while((i = filein.read()) != -1)
                System.out.println(i);
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("Error de E/S");
        }

    }
}

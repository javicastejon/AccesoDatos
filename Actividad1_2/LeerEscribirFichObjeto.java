package ficheros.act02;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LeerEscribirFichObjeto {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Persona persona;
        //Set de datos
        String[] nombres = {"Paco", "Mariana", "Pepon", "Felipon"};
        int[] edades = {48,32,12,27};
        File fichero = new File("C:\\Repos\\DAM2\\ficheros\\act02\\Ejemplo_escritura.dat");

        //ESCRITURA DE DATOS
        FileOutputStream fileout = new FileOutputStream(fichero);
        //Conexión del flujo de bytes a un flujo de datos de tipo objeto
        ObjectOutputStream dataout = new ObjectOutputStream(fileout);

        for(int i=0; i<edades.length; i++){
            persona = new Persona(nombres[i], edades[i]);
            dataout.writeObject(persona);
        }
        dataout.close();
        
        //LECTURA DE DATOS
        FileInputStream filein = new FileInputStream(fichero);
        //Conexión del flujo de bytes a un flujo de datos de tipo objeto
        ObjectInputStream datain = new ObjectInputStream(filein);
        try {
            while(true){
                persona = (Persona) datain.readObject();
                System.out.printf("Nombre: %s, edad: %d %n", persona.getNombre(), persona.getEdad());
            }
        } catch (EOFException e) { }
        datain.close();
    }
    
}

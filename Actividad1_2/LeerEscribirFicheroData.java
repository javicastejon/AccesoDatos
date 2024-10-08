package ficheros.act02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeerEscribirFicheroData {
    public static void main(String[] args) throws IOException{
        File fichero = new File("C:\\Repos\\DAM2\\ficheros\\act02\\Ejemplo_escritura.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);
        DataOutputStream dataout = new DataOutputStream(fileout);

        //Escritura de datos
        String[] nombres = {"Paco", "Mariana", "Pepon", "Felipon"};
        int[] edades = {48,32,12,27};

        for(int i=0; i<edades.length; i++){
            dataout.writeUTF(nombres[i]);
            dataout.writeInt(edades[i]);
        }
        dataout.close();

        //Lectura de datos
        FileInputStream filein = new FileInputStream(fichero);
        DataInputStream datain = new DataInputStream(filein);
        String n;
        int e;
        try {
            while(true){
                n = datain.readUTF();  //recupera el nombre
                e = datain.readInt();
                System.out.println("Nombre: " + n + ", edad: " + e);
            }
        } catch (EOFException eo) { }
        datain.close();
    }
}

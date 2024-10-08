package ficheros.act02;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerEscribirFicheroAleatorio {
    public static void main(String[] args) throws IOException {
        //Declaracion del fichero aleatorio
        File fichero = new File("C:\\Repos\\DAM2\\ficheros\\act02\\Fichaleatorio.dat");
        RandomAccessFile raf = new RandomAccessFile(fichero, "rw");  //rw - lectura/escritura

        //Set de datos
        String[] apellidos = {"PALOTES","MENTERO","JONES"};
        int[] departamentos = {10,20,30} ;
        Double[] salarios = {2900.90,3447.20,422.55};
        StringBuffer buffer = null;
        int tam = apellidos.length;

        //ESCRITURA FICHERO ALEATORIO
        for(int i=0; i<tam; i++){
            raf.writeInt(i+1); //Creamos un id de empleado
            buffer = new StringBuffer(apellidos[i]);
            //Se define un tamaño fijo de carácteres (recordad la teoria) para el apellido 10.  
            //Como cada carácter son 16bits-2bytes, reservará 10x2bytes = 20bytes para cada apellido
            buffer.setLength(10);  
            raf.writeChars(buffer.toString());  //Apellido
            raf.writeInt(departamentos[i]); //Departamento
            raf.writeDouble(salarios[i]);   //Salario
        }
        raf.close();


        //LECTURA DEL FICHERO
        //Variables para gestion de campos de datos
        int id, departamento, posicion;
        Double salario;
        char apellido[] = new char[10], aux;
        
        posicion = 0; //Posicion inicial del fichero
        RandomAccessFile rafread = new RandomAccessFile(fichero, "r");  //r - lectura
        for(;;){
            rafread.seek(posicion);  //Nos posicionamos al principio del fichero
            id = rafread.readInt(); //El primer campo es el id del empleado
            for(int i=0;i<apellido.length;i++){
                aux = rafread.readChar();
                apellido[i] = aux;
            }

            String apellidoEmp = new String(apellido);  //Conversión array a string
            departamento = rafread.readInt();
            salario = rafread.readDouble();
            if (id>0){
                System.out.printf("ID: %s, Apellido: %s, Dep: %d, Salario: %.2f %n"
                ,id,apellidoEmp.trim(),departamento,salario);
            }
            posicion = posicion + 36; // id-4bytes, Apellido-20bytes, dep-4bytes, salario-8bytes
            
            //Cuando llega al final sale del bucle for
            if(rafread.getFilePointer() == rafread.length())break;
        }
        rafread.close();
    }
    
}

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Práctica 6 - Objetos en ficheros binarios (ObjectInputStream/ObjectOutputStream)
 * Crear un programa que escriba un set de objetos de tipo Persona y 
 * lo grabe a un fichero binario.  Después realizar una lectura de ese fichero
 * y cargarlo a objetos de tipo persona.
 * IMPORTANTE: Añadir throw ClassNotFoundException al método main()
 */
public class Practica6 {
	/*
	 * Creamos la clase Persona que implementa la interfaz Serializable. Esto
	 * significa que los objetos de la clase Persona pueden ser serializados y
	 * deserializados, lo que permite que se almacenen y se recuperen en/desde un
	 * archivo binario de manera efectiva:
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		try {
			// Crear algunas instancias de Persona
			Persona persona1 = new Persona("Paco", 27);
			Persona persona2 = new Persona("Peco", 30);
			Persona persona3 = new Persona("Pico", 22);

			/*
			 * Creamos un ObjectOutputStream y lo utilizamos para escribir cada instancia de
			 * Persona en el archivo. Luego, cerramos el ObjectOutputStream.
			 */
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personas.dat"));
			oos.writeObject(persona1);
			oos.writeObject(persona2);
			oos.writeObject(persona3);
			oos.close();

			System.out.println("Objetos Persona escritos en el fichero binario.");

			/*
			 * Creamos un ObjectInputStream y lo utilizamos para leer cada objeto Persona
			 * desde el archivo. Luego, cerramos el ObjectInputStream.
			 */
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personas.dat"));
			Persona personaLeida1 = (Persona) ois.readObject();
			Persona personaLeida2 = (Persona) ois.readObject();
			Persona personaLeida3 = (Persona) ois.readObject();
			ois.close();

			System.out.println("Objetos Persona leídos del fichero binario:");
			System.out.println("Persona 1: " + personaLeida1.getNombre() + ", Edad: " + personaLeida1.getEdad());
			System.out.println("Persona 2: " + personaLeida2.getNombre() + ", Edad: " + personaLeida2.getEdad());
			System.out.println("Persona 3: " + personaLeida3.getNombre() + ", Edad: " + personaLeida3.getEdad());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 }
	    
}

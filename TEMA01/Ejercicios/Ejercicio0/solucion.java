package TEMA01.Ejercicios.Ejercicio0;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class solucion {
    
    public static void main(String[] args) {
        
        //Definimos el objeto y lo instanciamos al fichero, se introduce el modo de acceso.
            
            try {
            // Creacion del fichero
            File archivo = new File("./TEMA01/Ejercicios/Ejercicio0/datos.txt");
            
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado con éxito.");
                System.out.println();
                }
            
            else {
                System.out.println("El fichero ya existe.");
                System.out.println();
            }
            
            // Escribiendo en el archivo
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("abcdefghijklmnopqrstuvwxyz");
            escritor.close();
            //Pedimos al usuario la posición a la que quiere acceder
            int pos = Integer.parseInt(System.console().readLine("Indica la posición a la que quieres acceder: "));
            //Pedimos el caracter que quiere meter el usuario
            String nuevo = System.console().readLine("Escribe un caracter para sobreescribir en la posición dada: ");
            char nuevoC = nuevo.charAt(0);
            //Creamos el acceso
            RandomAccessFile random = new RandomAccessFile(archivo, "rw");
            // Posicionamos el puntero
            random.seek(pos);
            //Escribimos el nuevo caracter
            random.write(nuevoC);
            //Cerramos el acceso
            random.close();
            
        } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           

    }
}

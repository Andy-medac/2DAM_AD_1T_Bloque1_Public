import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Ejemplo de uso de FileInputStream y FileOutputStream

public class Ejemplo5 {
    
    public static void main(String[] args) {

        String path = "./TEMA01/Ejemplos/texto.txt";
        String pathEscritura = "./TEMA01/Ejemplos/textow.txt";

        // Primer bloque try-catch para la lectura
        try {
 
            FileInputStream entrada = new FileInputStream(path);
            int data;

            //Recorre hasta el final del fichero
            while ((data = entrada.read()) != -1) {
    
                System.out.print((char)data); 
            }
        
            entrada.close();
        } catch (Exception e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }

            
       // Segundo bloque try-catch para la escritura
       try {
            String cadena = "Esto es una prueba de escriturá";
            //Convertimos la cadena en un array de bytes
            byte[] arrayBytes = cadena.getBytes();
            
            FileOutputStream output = new FileOutputStream(pathEscritura);
            output.write(arrayBytes);
            output.close();
            System.out.println("\nFichero escrito");  
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

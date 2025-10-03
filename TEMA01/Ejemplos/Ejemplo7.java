import java.io.BufferedInputStream;
import java.io.FileInputStream;

//Ejemplo: Operaciones con buffer

public class Ejemplo7 {
    
    public static void main(String[] args) {

         try {
            int bufferSize = 12;
        
            BufferedInputStream bufferedInputStream = new BufferedInputStream(
                        new FileInputStream(".\\TEMA01\\Ejemplos\\Texto.txt"));
            
             // Crear un array de bytes para almacenar cada bloque leído
            byte[] buffer = new byte[bufferSize];
            int info;    
            int blockNumber = 1;
            
            while((info = bufferedInputStream.read(buffer)) != -1){
                // Convertir el bloque leído en texto (si es un archivo de texto)
                String contenidoBloque = new String(buffer, 0, info);
                System.out.println("Contenido del bloque " + blockNumber + " (bytes=" + info + "):");
                System.out.println(contenidoBloque);
            
            System.out.println("Fin bloque " + blockNumber);
            blockNumber++;
            }

            bufferedInputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package TEMA01.Ejercicios.Ejercicio1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class solucion {
    public static void main(String[] args) {
        String archivoOrigen  = "./TEMA01/Ejercicios/Ejercicio1/archivo_origen.txt";
        String archivoDestino = "./TEMA01/Ejercicios/Ejercicio1/archivo_destino.txt";  
        // se sobrescribe si existe
        int bufferSize = 2; // tamaño de buffer recomendado

        // try-with-resources: cierra automáticamente los streams
        try {
            
            BufferedInputStream in  = new BufferedInputStream(new FileInputStream(archivoOrigen), bufferSize);
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(archivoDestino, true));

            byte[] buffer = new byte[bufferSize];
            int bytesLeidos;
            int bloque = 1;

            // 5) Leer en bloques y escribir cada bloque en el destino
            while ((bytesLeidos = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesLeidos);   // escribe exactamente lo leído
                System.out.println("Fin copia bloque " + bloque);
                bloque++;
            }

            // 6) Añadir al final del destino la cadena indicada
            String ultimaMod = "\nÚltima modificación: 25-09-2025 15:04:01";
            out.write(ultimaMod.getBytes());

            in.close();
            out.close();

        } catch (FileNotFoundException e) {
            System.err.println("Archivo de origen no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de lectura/escritura: " + e.getMessage());
        }
    }
}

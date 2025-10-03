package TEMA01.Ejercicios.Ejercicio2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class solucion {
    public static void main(String[] args) {
        
        String imagenOrigen= "./TEMA01/Ejercicios/Ejercicio2/davante.jpg"; //49.270 bytes
        String imagenDestino = "./TEMA01/Ejercicios/Ejercicio2/davantecopia.jpg";

        //Defino el buffer de 1024 bytes
        byte[] buffer = new byte[1024];
        int bytesLeidos;
        int contador = 1;

        try {
                
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(imagenOrigen)); 
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(imagenDestino));
                

            while((bytesLeidos = bis.read(buffer)) != -1){
                bos.write(buffer, 0, bytesLeidos);
                System.out.println("Bloque " + contador + " - nº de bytes " + bytesLeidos);
                contador++;
            }
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
               System.out.println("Error " + e.getMessage());
            }

        }    

    }


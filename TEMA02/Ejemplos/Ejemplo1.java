package TEMA02.Ejemplos;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/*El código utiliza tuberías (PipedInputStream y PipedOutputStream) para comunicar dos hilos en Java. Estas tuberías permiten que un hilo escriba datos en una tubería y que otro hilo los lea de la misma tubería. */

public class Ejemplo1 {
    public static void main(String[] args) throws Exception {

        /* Se crea un PipedOutputStream llamado salida. Este será utilizado para escribir datos en la tubería.*/
        final PipedOutputStream salida = new PipedOutputStream();
        /* Se crea un PipedInputStream llamado entrada y se le pasa el PipedOutputStream salida como argumento. Esto conecta entrada y salida para que los datos escritos en salida estén disponibles para ser leídos desde entrada.*/
        final PipedInputStream entrada = new PipedInputStream(salida);
        
        /* Se define un Thread llamado thread1 que ejecutará el siguiente código en un hilo separado:*/
        Thread thread1 = new Thread(new Runnable(){
            @Override
            /* Este hilo escribirá la cadena "Hola por aquí!" en la tubería salida como una secuencia de bytes.*/
            public void run(){

                try {
                    salida.write("Hola por aquí!".getBytes());
                } catch (IOException e) {
                    // TODO: handle exception
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                int data;
                while((data = entrada.read()) != -1){
                System.out.print((char) data);
                //data = entrada.read();
                }
                } catch (IOException e) {
                }
                }
            });
            thread1.start();
            thread2.start();
    }
}

package TEMA02.Ejemplos;

import java.io.CharArrayReader;


/* El código demuestra el uso de las clases CharArrayWriter y CharArrayReader en Java para escribir y leer datos en un array de caracteres (char array) */
public class Ejemplo2 {
    public static void main(String[] args) throws Exception {

        char[] chars = "Hola amigo".toCharArray();
        CharArrayReader charArrayReader = new CharArrayReader(chars);

        int data;
        try {
            while((data = charArrayReader.read()) != -1){
                System.out.print((char)data);
            }
        
            charArrayReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

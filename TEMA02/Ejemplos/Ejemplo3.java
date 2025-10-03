package TEMA02.Ejemplos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;


public class Ejemplo3 {
    public static void main(String[] args) throws Exception {

        try {
            PushbackReader pushbackReader = new PushbackReader(
            new FileReader(".\\TEMA02\\Ejemplos\\Ejemplo3.txt"));
            int data = pushbackReader.read();
            System.out.println((char)data);
            pushbackReader.unread(data);
            data = pushbackReader.read();
            System.out.println((char)data);
            pushbackReader.close();
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

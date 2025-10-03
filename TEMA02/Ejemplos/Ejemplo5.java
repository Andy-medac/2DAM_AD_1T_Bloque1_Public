package TEMA02.Ejemplos;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;


public class Ejemplo5 {
    public static void main(String[] args) throws Exception {

        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(".\\TEMA02\\Ejemplos\\Ejemplo4.txt"));
            String line = lineNumberReader.readLine();
            while(line != null) {
                System.out.println("Contenido de la linea numero:"+ lineNumberReader.getLineNumber());
                System.out.println(line);
                line = lineNumberReader.readLine();
            }
                lineNumberReader.close();
            } catch (IOException e) {
            e.printStackTrace();
            }

    }
}

package TEMA02.Ejemplos;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;


public class Ejemplo4 {
    public static void main(String[] args) throws Exception {

        StreamTokenizer streamTokenizer = new StreamTokenizer(new FileReader(".\\TEMA02\\Ejemplos\\Ejemplo4.txt"));
        //StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader("Hola mi edad es 45"));

        // Configurar para que el carácter de nueva línea sea significativo
        streamTokenizer.eolIsSignificant(true);

        try {
            while(streamTokenizer.nextToken() != StreamTokenizer.TT_EOF){
                if(streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println("Word - "+streamTokenizer.sval);
                } else if(streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println("number - "+streamTokenizer.nval);
                } else if(streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println("Fin");
                }
        }
        } catch (IOException e) {
        e.printStackTrace();
        }

    }
}

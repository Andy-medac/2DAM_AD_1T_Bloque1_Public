package TEMA02.Ejercicios.Ejercicio0;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class solucion {
    
    public static void main(String[] args) {
        
        try {
            // Abrimos el archivo con LineNumberReader
            LineNumberReader lnr = new LineNumberReader(new FileReader(".\\TEMA02\\Ejercicios\\Ejercicio0\\entrada.txt"));
            String linea;

            // Leer línea a línea
            while ((linea = lnr.readLine()) != null) {
                int numPalabras = 0;
                int numNumeros = 0;

                // Creamos un StreamTokenizer para analizar la línea actual
                StreamTokenizer st = new StreamTokenizer(new StringReader(linea));

                // Recorremos los tokens de la línea
                while (st.nextToken() != StreamTokenizer.TT_EOF) {
                    if (st.ttype == StreamTokenizer.TT_WORD) {
                        numPalabras++;
                    } else if (st.ttype == StreamTokenizer.TT_NUMBER) {
                        numNumeros++;
                    }
                }

                // Mostramos el resultado
                System.out.println("Línea " + lnr.getLineNumber() + ": " + linea);
                System.out.println("Palabras: " + numPalabras + ", Números: " + numNumeros);
                System.out.println();
            }

            lnr.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

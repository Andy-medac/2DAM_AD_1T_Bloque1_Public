package Excepciones;

import java.io.FileReader;
import java.io.IOException;

public class ejemplo1checked {
    public static void main(String[] args) {
        // Error de compilación si no pongo el try-catch
        try (FileReader file = new FileReader("archivo")) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

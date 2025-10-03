package Excepciones;

public class ejemplo4Mensajes {
    public static void main(String[] args) {

        int dividendo = 10;
        int divisor = 0;

        try {
            int resultado = dividendo / divisor;
            System.out.println(resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error. " + e.getMessage());
        }

    }
}

package Excepciones;

public interface ejemplo2UnChecked {
    public static void main(String[] args) {
        
        //Error en tiempo de ejecución
        int numeros[] = {1, 2 ,3};
        System.out.println(numeros[5]);
        System.out.println("Error fuera de rango");

        String texto = null;
        int longitud = texto.length();
        System.out.println(longitud);
    }
}

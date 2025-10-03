package Excepciones;

public class ejemplo3StackOverflowError {
    public static void main(String[] args) {
        recursiveFunction();
    }

    public static void recursiveFunction(){
        recursiveFunction();
    }
}

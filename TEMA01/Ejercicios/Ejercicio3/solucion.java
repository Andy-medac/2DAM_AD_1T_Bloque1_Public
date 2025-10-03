import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;

public class solucion {

    static String genero = "";

    //Acceso a datos
    static String guardado = "";
    public static void main(String[] args) {
        
        
        // Crear el marco
        JFrame frame = new JFrame("Formulario matriculación alumno/a");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLayout(new GridLayout(0, 2, 10, 10));

        // Cambiar el color de fondo
        frame.setBackground(java.awt.Color.CYAN);

        // Añadir etiquetas y campos
        frame.add(new JLabel("Nombre y apellidos:"));
        JTextField nombreField = new JTextField();
        frame.add(nombreField);

        //Creamos el email
        frame.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        frame.add(emailField);

        //Creamos la fecha de nacimiento
        frame.add(new JLabel("Fecha de nacimiento:"));
        JTextField fechaField = new JTextField();
        frame.add(fechaField);

        //Creamos el apartado de el género
        frame.add(new JLabel("Género:"));
        JPanel generoPanel = new JPanel();

        //Creamos los botones
        JRadioButton masculinoButton = new JRadioButton("Masculino");
        JRadioButton femeninoButton = new JRadioButton("Femenino");

        //Lo metemos en un grupo para que solo se pueda seleccionar uno
        ButtonGroup generoGroup = new ButtonGroup();
        generoGroup.add(masculinoButton);
        generoGroup.add(femeninoButton);
        generoPanel.add(masculinoButton);
        generoPanel.add(femeninoButton);
        frame.add(generoPanel);

        frame.add(new JLabel("Titulación de acceso:"));
        String[] titulaciones = {"Grado Medio", "Bachiller"};//Sale primero el grado medio ya que es la primer opcion
        JComboBox<String> titulacionComboBox = new JComboBox<>(titulaciones);
        frame.add(titulacionComboBox);

        //Crear las observaciones con un TextArea ya que es un espacio muy grande
        frame.add(new JLabel("Observaciones:"));
        JTextArea observacionesArea = new JTextArea(5, 20);//Le digo que de filas 5 y columnas 20
        frame.add(new JScrollPane(observacionesArea));


        



        // Botones
        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (masculinoButton.isSelected()) {
                    genero = "masculino";
                }else if(femeninoButton.isSelected()){
                    genero = "femenino";
                }else{

                }



                //Parte de acceso a datos
                guardado += "El alumno/a "+nombreField.getText();
                guardado += " con email "+emailField.getText();
                guardado += " nació el "+fechaField.getText();
                guardado += " de género "+genero;
                guardado += " llegó al grado superior de DAM a través de una titulación en "+titulacionComboBox.getSelectedItem();



                // Lógica para guardar
                JOptionPane.showMessageDialog(frame, "Datos guardados.");




            }
        });
        frame.add(guardarButton);

        

        JButton imprimirButton = new JButton("Imprimir");
        imprimirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (masculinoButton.isSelected()) {
                    genero = "masculino";
                }else if(femeninoButton.isSelected()){
                    genero = "femenino";
                }else{

                }
                // Lógica para imprimir
                System.out.println("El alumno "+nombreField.getText()+" con email "+emailField.getText()+" nació el "+fechaField.getText()+" de género "+genero+" llego  al grado superior de DAM a través de "+titulacionComboBox.getSelectedItem()+".");
                JOptionPane.showMessageDialog(frame, "Imprimiendo...");
                nombreField.setText("");
                emailField.setText("");
                fechaField.setText("");
                generoGroup.clearSelection();
                observacionesArea.setText("");

                //Acceso a datos
                try {
                    FileWriter escribir = new FileWriter("./TEMA01/Ejercicios/Ejercicio3/matricula.txt", true);
                    escribir.write(guardado);                    
                    escribir.close();


                } catch (Exception ex) {
                    // 
                }
            }
        });
        frame.add(imprimirButton);

        // Hacer visible el marco
        frame.setVisible(true);
    }
}

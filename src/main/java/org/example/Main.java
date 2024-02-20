package org.example;
import javax.swing.*;

public class Main {
        static JFrame frame = new JFrame("Ingreso de Instrumentos");
    public static void main(String[] args) {
        frame.setContentPane(new ingresoNotas().insertar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
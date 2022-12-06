package co.edu.unbosque.view;

import javax.swing.*;

public class View {
    public String pedirdato(String mensaje){
        return JOptionPane.showInputDialog(mensaje);
    }

    public void mostrarmensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }
}

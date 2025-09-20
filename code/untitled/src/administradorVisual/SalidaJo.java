package administradorVisual;

import inout.Salida;

import javax.swing.*;

public class SalidaJo implements Salida {
    @Override
    public void mostrar(Object dato, Object dato2) {
        JOptionPane.showMessageDialog(null, "El dato que ingresaste en String es "+ dato +"\nEl dato que ingresaste en Int Ascii es: "+ dato2);
    }
}

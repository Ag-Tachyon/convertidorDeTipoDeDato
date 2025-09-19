package administradorVisual;

import inout.Salida;

import javax.swing.*;

public class SalidaJo implements Salida {
    @Override
    public void mostrar(String dato) {
        JOptionPane.showMessageDialog(null, "El dato que ingresaste es "+dato);
    }
}

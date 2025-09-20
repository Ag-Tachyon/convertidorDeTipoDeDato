package administradorVisual;

import inout.Salida;

public class SalidaConsola implements Salida {
    @Override
    public void mostrar(Object dato, Object dato2) {
        System.out.println("Tu dato en String es: " + dato +"\nTu dato en Int Ascii es: " + dato2);
    }
}

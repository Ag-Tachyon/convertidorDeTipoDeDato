package administradorVisual;

import inout.Salida;

public class SalidaConsola implements Salida {
    @Override
    public void mostrar(String dato) {
        System.out.println(dato);
    }
}

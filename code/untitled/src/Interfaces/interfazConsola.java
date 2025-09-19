package Interfaces;
import inout.*;
import administradorVisual.*;

public class interfazConsola implements FabricaInterfaz {
    @Override
    public Entrada crearEntrada() {
        return new EntradaConsola();

    }
    @Override
    public Salida crearSalida() {
        return new SalidaConsola();
    }
}

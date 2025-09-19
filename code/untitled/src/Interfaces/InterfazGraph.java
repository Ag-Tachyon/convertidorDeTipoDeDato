package Interfaces;
import inout.*;
import administradorVisual.*;

public class InterfazGraph implements FabricaInterfaz{
    @Override
    public Entrada crearEntrada() {
        return new EntradaJo();
    }

    @Override
    public Salida crearSalida() {
        return new SalidaJo();
    }
}


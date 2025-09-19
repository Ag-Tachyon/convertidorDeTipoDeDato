import javax.swing.*;
import Interfaces.*;

public class ConvertidorData {
    public static void main(String[] args) {
        FabricaInterfaz fabricaInterfaz;
        String modos[] = {"Consola", "Grafica"};
        int eleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione el modo de entrada/salida:",
                "Modo de Entrada/Salida",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                modos,
                modos[0]
        );
        if (eleccion == JOptionPane.CLOSED_OPTION) {
            return; // Salir si se cierra el diálogo
        }else{
            switch (eleccion){
            case 0:
                fabricaInterfaz = new interfazConsola();
                break;
            case 1:
                fabricaInterfaz = new InterfazGraph();
                break;
            default:
                return;
        }
        String entrada = fabricaInterfaz.crearEntrada().pedir();
        fabricaInterfaz.crearSalida().mostrar(entrada);
    }
}

}
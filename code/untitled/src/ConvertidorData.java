import javax.swing.*;
import Interfaces.*;
import adapter.Adaptador;
import java.util.List;

public class ConvertidorData {
    public static void main(String[] args) {
        FabricaInterfaz fabricaInterfaz;
        Adaptador adapter = new Adaptador();
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
            return; 
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
        List<Integer> num = adapter.stringToIntAscii(entrada);
        fabricaInterfaz.crearSalida().mostrar(entrada, num);
    }
}

}
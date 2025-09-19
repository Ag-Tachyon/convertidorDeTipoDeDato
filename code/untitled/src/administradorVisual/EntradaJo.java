package administradorVisual;
import inout.Entrada;
import javax.swing.JOptionPane;
public class EntradaJo implements Entrada {
    @Override
    public String pedir() {
        String a = JOptionPane.showInputDialog(null,"Introduce un valor (Entero, texto,decimal, caracter):");
        //llamar al adapter que convierta los valores
        return a;
    }
}

package administradorVisual;
import inout.Entrada;
import java.util.Scanner;

public class EntradaConsola implements Entrada {

    @Override
    public String pedir() {
        Scanner scanner = new Scanner(System.in);
        String a;
        System.out.println("Entrada por consola");
        a = scanner.nextLine();
        return a;
    }
}

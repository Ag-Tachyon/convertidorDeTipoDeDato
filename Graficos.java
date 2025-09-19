import java.util.Scanner;
import javax.swing.JOptionPane;

// ===== Interfaces =====
interface Entrada {
    String pedir();
}

interface Salida {
    void mostrar(String mensaje);
}

interface FabricInterfaz {
    Entrada crearEntrada();
    Salida crearSalida();
}

// ===== Implementaciones de Entrada =====
class ConsolaEntrada implements Entrada {
    private Scanner sc = new Scanner(System.in);

    @Override
    public String pedir() {
        System.out.print("Ingrese un dato por consola: ");
        return sc.nextLine();
    }
}

class FrameEntrada implements Entrada {
    @Override
    public String pedir() {
        return JOptionPane.showInputDialog(null, "Ingrese un dato:", "Entrada Frame", JOptionPane.QUESTION_MESSAGE);
    }
}

// ===== Implementaciones de Salida =====
class ConsolaSalida implements Salida {
    @Override
    public void mostrar(String mensaje) {
        System.out.println("Mostrando en consola: " + mensaje);
    }
}

class FrameSalida implements Salida {
    @Override
    public void mostrar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Salida Frame", JOptionPane.INFORMATION_MESSAGE);
    }
}

// ===== Fábricas concretas =====
class FabricConsola implements FabricInterfaz {
    @Override
    public Entrada crearEntrada() {
        return new ConsolaEntrada();
    }

    @Override
    public Salida crearSalida() {
        return new ConsolaSalida();
    }
}

class FabricFrame implements FabricInterfaz {
    @Override
    public Entrada crearEntrada() {
        return new FrameEntrada();
    }

    @Override
    public Salida crearSalida() {
        return new FrameSalida();
    }
}

// ===== Adapter =====
class Adapter {
    public String intToString(int valor) {
        return String.valueOf(valor);
    }

    public int stringToInt(String texto) {
        return Integer.parseInt(texto);
    }

    // Convierte un String a su representación ASCII
    public String stringToAscii(String texto) {
        StringBuilder sb = new StringBuilder();
        for (char c : texto.toCharArray()) {
            sb.append((int) c).append(" ");
        }
        return sb.toString().trim();
    }

    // Convierte una secuencia de códigos ASCII a String
    public String asciiToString(String asciiTexto) {
        String[] codes = asciiTexto.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String code : codes) {
            sb.append((char) Integer.parseInt(code));
        }
        return sb.toString();
    }
}

// ===== Main =====
public class Graficos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Selección de modo
        System.out.println("Seleccione el tipo de gráficos:");
        System.out.println("1. Consola");
        System.out.println("2. Frame");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        FabricInterfaz fabrica;
        if (opcion == 1) {
            fabrica = new FabricConsola();
        } else {
            fabrica = new FabricFrame();
        }

        Entrada entrada = fabrica.crearEntrada();
        Salida salida = fabrica.crearSalida();

        // Pedir dato
        String dato = entrada.pedir();
        salida.mostrar("El dato ingresado es: " + dato);

        // Uso del Adapter
        Adapter adapter = new Adapter();

        System.out.println("Seleccione conversión con el Adapter:");
        System.out.println("1. String -> int y viceversa");
        System.out.println("2. String -> ASCII y viceversa");
        System.out.print("Opción: ");
        int opcionConv = sc.nextInt();
        sc.nextLine();

        if (opcionConv == 1) {
            try {
                int numero = adapter.stringToInt(dato);
                String texto = adapter.intToString(numero);
                salida.mostrar("Convertido de String a int: " + numero + 
                               "\nConvertido de int a String: " + texto);
            } catch (NumberFormatException e) {
                salida.mostrar("El dato ingresado no es un número válido.");
            }
        } else if (opcionConv == 2) {
            // String a ASCII
            String ascii = adapter.stringToAscii(dato);
            salida.mostrar("String -> ASCII: " + ascii);

            // ASCII a String (para probar, convertimos de nuevo)
            String original = adapter.asciiToString(ascii);
            salida.mostrar("ASCII -> String: " + original);
        } else {
            salida.mostrar("Opción no válida.");
        }
    }
}
    
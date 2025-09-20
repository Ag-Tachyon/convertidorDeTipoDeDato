package adapter;

import java.util.ArrayList;
import java.util.List;

public class Adaptador {
    
    public List<Integer> stringToIntAscii(String texto) {
        List<Integer> result = new ArrayList<>();
        
        try {
            int numero = Integer.parseInt(texto);
            result.add(numero);
        } catch (NumberFormatException e) {
            for (int i = 0; i < texto.length(); i++) {
                result.add((int) texto.charAt(i));
            }
        }
        
        return result;
    }
}

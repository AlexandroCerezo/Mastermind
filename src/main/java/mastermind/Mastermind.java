package mastermind;

import java.util.Random;

public class Mastermind {
    private String combinacionSecreta;
    public static final int TAMANO_POR_DEFECTO = 4;
    private Random alea = new Random();

    public Mastermind() {
        this(TAMANO_POR_DEFECTO);
    }

    public Mastermind(int tam) {
        if(tam < 1 || tam > 10) throw new MastermindException("Tamaño no valido: " + tam);
        generaCombinacionSecreta(tam);
    }

    private void generaCombinacionSecreta(int tam) {
        combinacionSecreta = "";
        while(combinacionSecreta.length() < tam) {
            String n = Integer.toString(alea.nextInt(10));
            if(combinacionSecreta.indexOf(n) < 0) {                 // Si no está, la n no está
                combinacionSecreta += n;
            }
        }
    }

    public int getLongitud() {                  // Si me pide la longitud del numero, es la longitud de
        return combinacionSecreta.length();     // la combinación secreta
    }

    private boolean validaCombinacion (String cifras) {
        boolean valida = cifras.matches("\\d{" + combinacionSecreta.length() + "}"); // Si pido en el juego 4, me valida si son exacatamente 4
        if(valida) {
            int pos = 0;
            while(valida && pos < cifras.length()-1) {
                valida = combinacionSecreta.substring(pos + 1). // 3527: Vemos si se repite algun numero
                         indexOf(combinacionSecreta.charAt(pos)) < 0;     // Me da la posicion del caracter lo de < 0
                pos++;
            }
        }
        return valida;
    }

    public Movimiento intento(String cifras) {
        if(!validaCombinacion(cifras)) throw new MastermindException("Cifras no validas: " + cifras);   // Comprobamos si el intento es bueno
        // El intento es bueno
        int col = 0;
        int des = 0;
        for (int pos = 0; pos < cifras.length(); pos++) {
            if(combinacionSecreta.charAt(pos) == cifras.charAt(pos)) {      // He de usar indexOf, puesto que cifras es un String
                col++;
            }else if (combinacionSecreta.indexOf(cifras.charAt(pos)) >= 0){
                des++;
            }
        }
        return new Movimiento(cifras, col, des);
    }

    public String getSecreto() {
        return combinacionSecreta;
    }
}

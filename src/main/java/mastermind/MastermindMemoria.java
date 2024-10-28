package mastermind;

import java.util.ArrayList;
import java.util.List;

public class MastermindMemoria extends Mastermind{
    private List<Movimiento> movimientos;
    public MastermindMemoria() {
        this(TAMANO_POR_DEFECTO);
    }
    public MastermindMemoria(int tamano) {
        super(tamano);
        movimientos = new ArrayList<>();
    }

    @Override
    public Movimiento intento(String cifras) {
        Movimiento movimiento = super.intento(cifras);
        if(movimientos.contains(movimiento)) throw new MastermindException(("El movimiento ya se ha realizado: " + movimiento)); // Lo que vemos es ver si el movimiento indicado es el movimiento que ya se ha realizado
            movimientos.add(movimiento);
            return movimiento;
    }

    public List<Movimiento> movimientos() {
        return movimientos;
    }
}

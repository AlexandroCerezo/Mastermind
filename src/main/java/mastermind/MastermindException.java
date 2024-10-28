package mastermind;

public class MastermindException extends RuntimeException {

    public MastermindException(String msg) {    // Toda excepción tiene dos constructores:
        super(msg);                             //
    }

    public MastermindException() {
        super();
    }


}

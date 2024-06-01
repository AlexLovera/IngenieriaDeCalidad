package ar.com.grupoesfera.repartir.exceptions;

public class MontoDeGastoInvalidoException extends RuntimeException {
    public MontoDeGastoInvalidoException() {
        super("El monto de gasto es inválido.");
    }
    public MontoDeGastoInvalidoException(String message) {
        super(message);
    }
}

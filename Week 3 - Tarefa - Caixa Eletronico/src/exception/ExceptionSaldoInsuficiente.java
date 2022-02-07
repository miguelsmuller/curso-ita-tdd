package exception;

public class ExceptionSaldoInsuficiente extends RuntimeException {
	public ExceptionSaldoInsuficiente(String msg) {
		super(msg);
	}
}

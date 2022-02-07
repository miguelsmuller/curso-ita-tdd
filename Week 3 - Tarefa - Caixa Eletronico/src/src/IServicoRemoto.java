package src;

public interface IServicoRemoto {
	public ContaCorrente RecuperarConta(String numConta);
	public ContaCorrente persistirConta(ContaCorrente conta);
}

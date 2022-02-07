package mocks;

import exception.ExceptionErroNaLeituraDoCartao;
import src.IHardware;

public class MockHardwareContaInvalido implements IHardware{
	@Override
	public String pegarNumeroDaContaCartao() {
		throw new ExceptionErroNaLeituraDoCartao("Não foi possível autenticar o usuário");
	}
	@Override
	public void entregarDinheiro() {}
	@Override
	public void lerEnvelope() {}
}
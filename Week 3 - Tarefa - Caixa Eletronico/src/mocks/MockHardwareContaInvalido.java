package mocks;

import exception.ExceptionErroNaLeituraDoCartao;
import src.IHardware;

public class MockHardwareContaInvalido implements IHardware{
	@Override
	public String pegarNumeroDaContaCartao() {
		throw new ExceptionErroNaLeituraDoCartao("N�o foi poss�vel autenticar o usu�rio");
	}
	@Override
	public void entregarDinheiro() {}
	@Override
	public void lerEnvelope() {}
}
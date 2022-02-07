package mocks;

import exception.ExceptionErroNaRetiradaDoDinheiro;
import src.IHardware;

public class MockHardwareEntregaIndisponivel implements IHardware{
	@Override
	public String pegarNumeroDaContaCartao() {
		return "000001";
	}
	@Override
	public void entregarDinheiro() {
		throw new ExceptionErroNaRetiradaDoDinheiro("N�o foi poss�vel autenticar o usu�rio");
	}
	@Override
	public void lerEnvelope() {}
}
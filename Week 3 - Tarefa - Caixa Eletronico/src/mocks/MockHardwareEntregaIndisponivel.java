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
		throw new ExceptionErroNaRetiradaDoDinheiro("Não foi possível autenticar o usuário");
	}
	@Override
	public void lerEnvelope() {}
}
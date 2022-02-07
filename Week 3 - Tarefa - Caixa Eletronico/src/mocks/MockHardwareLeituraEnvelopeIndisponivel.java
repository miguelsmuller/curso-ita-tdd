package mocks;

import exception.ExceptionErroNaLeituraDoEnvelope;
import src.IHardware;

public class MockHardwareLeituraEnvelopeIndisponivel implements IHardware{
	@Override
	public String pegarNumeroDaContaCartao() {
		return "000001";
	}
	@Override
	public void entregarDinheiro() {}
	@Override
	public void lerEnvelope() {
		throw new ExceptionErroNaLeituraDoEnvelope("N�o foi poss�vel autenticar o usu�rio");
	}
}
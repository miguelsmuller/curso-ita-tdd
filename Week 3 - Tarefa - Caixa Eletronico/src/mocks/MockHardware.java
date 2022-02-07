package mocks;

import src.IHardware;

public class MockHardware implements IHardware {
	@Override
	public String pegarNumeroDaContaCartao() {
		return "000001";
	}
	@Override
	public void entregarDinheiro() {}
	@Override
	public void lerEnvelope() {}
}

package mocks;

import src.ContaCorrente;
import src.IServicoRemoto;

public class MockServicoRemoto implements IServicoRemoto {
	ContaCorrente cntCorr;
	
	public MockServicoRemoto() {
		cntCorr = new ContaCorrente();
	}
	@Override
	public ContaCorrente RecuperarConta(String numConta) {
		this.cntCorr.setSaldo(158.75);
		return cntCorr;
	}
	@Override
	public ContaCorrente persistirConta(ContaCorrente conta) {
		this.cntCorr = conta;
		return this.cntCorr;
	}
}

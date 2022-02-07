package mocks;

import exception.ExceptionRedeIndisponivel;
import src.ContaCorrente;
import src.IServicoRemoto;

public class MockServicoRemotoInconsistente implements IServicoRemoto {
	@Override
	public ContaCorrente RecuperarConta(String numConta) {
		throw new ExceptionRedeIndisponivel("Não foi possível recuperar a conta");
	}
	@Override
	public ContaCorrente persistirConta(ContaCorrente conta) {
		throw new ExceptionRedeIndisponivel("Não foi possível salvar a conta");
	}
}

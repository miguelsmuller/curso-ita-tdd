package src;

import exception.ExceptionErroNaLeituraDoCartao;
import exception.ExceptionErroNaLeituraDoEnvelope;
import exception.ExceptionErroNaRetiradaDoDinheiro;
import exception.ExceptionRedeIndisponivel;
import exception.ExceptionSaldoInsuficiente;

public class CaixaEletronico {
	public IHardware hardware;
	public IServicoRemoto servicoRemoto;
	
	protected String contaFromHardware;
	protected ContaCorrente contaFromServicoRemoto;
	
	public CaixaEletronico(IHardware hrdw, IServicoRemoto srcRmt) {
		this.hardware = hrdw;
		this.servicoRemoto = srcRmt;
	}
	
	public String logar()
	throws ExceptionErroNaLeituraDoCartao, ExceptionRedeIndisponivel {
		this.contaFromHardware = hardware.pegarNumeroDaContaCartao();
		this.contaFromServicoRemoto = servicoRemoto.RecuperarConta(this.contaFromHardware);
		return "Usuário Autenticado";
	}
	
	public Double saldo()
	throws ExceptionRedeIndisponivel {
		return contaFromServicoRemoto.getSaldo();
	}	
	
	public Double sacar(double valorDoSaque) 
	throws ExceptionErroNaRetiradaDoDinheiro, ExceptionRedeIndisponivel {
		double saldoAtual = contaFromServicoRemoto.getSaldo();
		
		if (valorDoSaque > saldoAtual) {
			throw new ExceptionSaldoInsuficiente("Saldo insuficiente");
		}
		
		double novoSaldo = saldoAtual - valorDoSaque;
		
		this.contaFromServicoRemoto.setSaldo(novoSaldo);
		this.hardware.entregarDinheiro();
		this.servicoRemoto.persistirConta(contaFromServicoRemoto);
		this.hardware.entregarDinheiro();
	
		return novoSaldo;
	}

	public Double depositar(double valorDoDeposito) 
	throws ExceptionErroNaLeituraDoEnvelope, ExceptionRedeIndisponivel {
		hardware.lerEnvelope();
		
		double saldoAtual = contaFromServicoRemoto.getSaldo();
		double novoSaldo = saldoAtual + valorDoDeposito;
		
		this.contaFromServicoRemoto.setSaldo(novoSaldo);
		this.servicoRemoto.persistirConta(contaFromServicoRemoto);
		
		return novoSaldo;
	}
}

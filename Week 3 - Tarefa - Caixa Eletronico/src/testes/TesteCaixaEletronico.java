package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.ExceptionErroNaLeituraDoCartao;
import exception.ExceptionErroNaLeituraDoEnvelope;
import exception.ExceptionErroNaRetiradaDoDinheiro;
import exception.ExceptionRedeIndisponivel;
import exception.ExceptionSaldoInsuficiente;
import src.CaixaEletronico;
import src.IHardware;
import src.IServicoRemoto;
import mocks.MockHardware;
import mocks.MockHardwareContaInvalido;
import mocks.MockHardwareEntregaIndisponivel;
import mocks.MockHardwareLeituraEnvelopeIndisponivel;
import mocks.MockServicoRemoto;
import mocks.MockServicoRemotoInconsistente;

public class TesteCaixaEletronico {
	IHardware hrdw;
	IServicoRemoto srcRmt;
	CaixaEletronico cxEle;

	@Test(expected = ExceptionErroNaLeituraDoCartao.class)
    public void testeNumeroDaContaDoCartaoInvalido() {
		hrdw = new MockHardwareContaInvalido();
		srcRmt = new MockServicoRemoto();
		cxEle = new CaixaEletronico(hrdw, srcRmt);
		
		assertEquals("Usuário Autenticado", this.cxEle.logar());
    }
	
	@Test(expected = ExceptionRedeIndisponivel.class)
    public void testeLogarComServicoRemotoIndisponivel() {
		hrdw = new MockHardware();
		srcRmt = new MockServicoRemotoInconsistente();
		cxEle = new CaixaEletronico(hrdw, srcRmt);
		
		assertEquals("Usuário Autenticado", this.cxEle.logar());
    }
	
	@Test()
    public void testeLogarComSucesso() {
		hrdw = new MockHardware();
		srcRmt = new MockServicoRemoto();
		cxEle = new CaixaEletronico(hrdw, srcRmt);
		
		assertEquals("Usuário Autenticado", this.cxEle.logar());
    }
	
	@Test()
    public void testeSaldoSucesso() {
		hrdw = new MockHardware();
		srcRmt = new MockServicoRemoto();
		cxEle = new CaixaEletronico(hrdw, srcRmt);
		this.cxEle.logar();
		
		assertEquals(158.75, cxEle.saldo(), 0.001);
    }
	
	@Test(expected = ExceptionRedeIndisponivel.class)
    public void testeSaldoComErro() {
		hrdw = new MockHardware();
		srcRmt = new MockServicoRemotoInconsistente();
		cxEle = new CaixaEletronico(hrdw, srcRmt);
		cxEle.logar();
		assertEquals(158.75, cxEle.saldo(), 0.001);
    }
	
	@Test()
    public void testeSaqueComSucesso() {
		hrdw = new MockHardware();
		srcRmt = new MockServicoRemoto();
		cxEle = new CaixaEletronico(hrdw, srcRmt);
		
		cxEle.logar();
		double saldoAposSaque = cxEle.sacar(58.75);
		double consultaSaldo = cxEle.saldo();
		
		assertEquals(saldoAposSaque, consultaSaldo, 0.001);
    }
	
	@Test(expected = ExceptionSaldoInsuficiente.class)
    public void testeSaqueComSaldoInsuficiente() {
		hrdw = new MockHardware();
		srcRmt = new MockServicoRemoto();
		cxEle = new CaixaEletronico(hrdw, srcRmt);

		cxEle.logar();
		cxEle.sacar(200.00);
    }
	
	@Test(expected = ExceptionErroNaRetiradaDoDinheiro.class)
    public void testeSaqueHardwareComProblema() {
		hrdw = new MockHardwareEntregaIndisponivel();
		srcRmt = new MockServicoRemoto();
		cxEle = new CaixaEletronico(hrdw, srcRmt);

		cxEle.logar();
		cxEle.sacar(58.75);
    }
	
	@Test(expected = ExceptionRedeIndisponivel.class)
    public void testeSaqueRedeIndisponivelParaPersistirOsDados() {
		hrdw = new MockHardware();
		srcRmt = new MockServicoRemotoInconsistente();
		cxEle = new CaixaEletronico(hrdw, srcRmt);

		cxEle.logar();
		cxEle.sacar(58.75);
		
    }	

	@Test(expected = ExceptionErroNaLeituraDoEnvelope.class)
    public void testeDepositoeHardwareComProblema() {
		hrdw = new MockHardwareLeituraEnvelopeIndisponivel();
		srcRmt = new MockServicoRemoto();
		cxEle = new CaixaEletronico(hrdw, srcRmt);

		cxEle.logar();
		cxEle.depositar(41.25);
    }
	
	@Test()
    public void testeDepositoComSucesso() {
		hrdw = new MockHardware();
		srcRmt = new MockServicoRemoto();
		cxEle = new CaixaEletronico(hrdw, srcRmt);
		
		cxEle.logar();
		double saldoAposDeposito = cxEle.depositar(41.25);
		
		assertEquals(200.00, saldoAposDeposito, 0.001);
    }

	@Test(expected = ExceptionRedeIndisponivel.class)
    public void testeDepositoRedeIndisponivelParaPersistirOsDados() {
		hrdw = new MockHardware();
		srcRmt = new MockServicoRemotoInconsistente();
		cxEle = new CaixaEletronico(hrdw, srcRmt);

		cxEle.logar();
		double saldoAposDeposito = cxEle.depositar(41.25);
		
		assertEquals(200.00, saldoAposDeposito, 0.001);	
    }	
}


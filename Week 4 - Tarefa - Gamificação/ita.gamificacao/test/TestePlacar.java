package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import src.Armazenamento;
import src.ArmazenamentoMock;
import src.IArmazenamento;
import src.Placar;
import src.Ponto;

public class TestePlacar {
	IArmazenamento _storage;
	Placar _board;
	
	@Before
	public void init(){		
		//_storage = new Armazenamento();
		_storage = new ArmazenamentoMock();
		_board = new Placar(_storage);
	}
	
	@Test
	public void testeIniciarPlacar() {	
		assertFalse(_board.isEmpty());
		assertEquals(8, _board.getSize());
	}
	
	@Test
	public void testeRecuperaSomaDePontosDeTodosOsTiposDeUmUsuario() {
		List<Ponto> resultadoExperado = new ArrayList<>();
		resultadoExperado.add(new Ponto("guerra", 25, "estrela"));
		resultadoExperado.add(new Ponto("guerra", 20, "moeda"));
	
		List<Ponto> somatorioDosPontosPorTipo = _board.GetSumFromAllTypesPointsFromUser("guerra");
		
		assertEquals(2, somatorioDosPontosPorTipo.size());
		assertTrue(somatorioDosPontosPorTipo.equals(resultadoExperado));
	}
	
	@Test
	public void testeRecuperaRankingPorUmTipoDePonto() {
		List<Ponto> resultadoExperado = new ArrayList<>();
		resultadoExperado.add(new Ponto("guerra", 25, "estrela"));
		resultadoExperado.add(new Ponto("fernandes", 19, "estrela"));
		resultadoExperado.add(new Ponto("rodrigo", 17, "estrela"));
		
		List<Ponto> somatorioDosPontosPorTipo = _board.GetRankingOfPointType("estrela");
		
		assertEquals(resultadoExperado.get(0).get_value(), somatorioDosPontosPorTipo.get(0).get_value());
		assertEquals(resultadoExperado.get(1).get_value(), somatorioDosPontosPorTipo.get(1).get_value());
		assertEquals(resultadoExperado.get(2).get_value(), somatorioDosPontosPorTipo.get(2).get_value());
	}
}

package test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import src.Armazenamento;
import src.ArmazenamentoMock;
import src.IArmazenamento;
import src.Placar;

public class TesteArmazenamento {
	IArmazenamento _storage;
	Placar _board;
	
	@Before
	public void init(){		
		//_storage = new Armazenamento();
		_storage = new ArmazenamentoMock();
	}
	
	@Test
	public void testeArmazenamentoInserePontos() {	
		Assert.assertFalse(_storage.isEmpty());
		Assert.assertEquals(8, _storage.getSize());
	}
	
	@Test
	public void testeRecuperaPontosDeUmTipoDoUsuario() {				
		int pontosDeUmTipoDeUmUsuario = _storage.getPointOfTypeFromUser("guerra", "estrela"); 
		Assert.assertEquals(25, pontosDeUmTipoDeUmUsuario);
	}
	
	@Test
	public void testeRecuperaUsuariosComPonto() {
		List<String> expectUsuariosComPontosDoTipoInformado = Arrays.asList("guerra", "fernandes", "rodrigo");
		 
		List<String> usuariosComPontosDoTipoInformado = _storage.getUsersWithPoints();
				
		Assert.assertEquals(3, usuariosComPontosDoTipoInformado.size());
		Assert.assertTrue(usuariosComPontosDoTipoInformado.equals(expectUsuariosComPontosDoTipoInformado));
	} 
	
	@Test
	public void testeRecuperaTiposPontosDeUsuario() {
		List<String> expectTiposDePontosQueUmUsuarioPossui = Arrays.asList("estrela", "moeda");
		
		List<String> tiposDePontosQueUmUsuarioPossui = _storage.getPointsTypesFromUser("guerra");
				
		Assert.assertEquals(2, tiposDePontosQueUmUsuarioPossui.size());
		Assert.assertTrue(tiposDePontosQueUmUsuarioPossui.equals(expectTiposDePontosQueUmUsuarioPossui));
	}
}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

public class TesteCamelCase {

	@Test
    public void testeInvalidHaveSpace() {
		HaveSpaceExcepetion thrown = Assertions.assertThrows(HaveSpaceExcepetion.class, () -> {
			List<String> result = CamelCaseToString.converterCamelCase("nome com espaço");
		});
    }
	
	@Test
	public void testeInvalidStartWithNumber() {
		StartWithNumberExcepetion thrown = Assertions.assertThrows(StartWithNumberExcepetion.class, () -> {
			List<String> result = CamelCaseToString.converterCamelCase("10Primeiros");
		});
    }
	
	@Test
	public void testeInvalidHaveSpecialChar() {
		HaveSpecialCharExcepetion thrown = Assertions.assertThrows(HaveSpecialCharExcepetion.class, () -> {
			List<String> result = CamelCaseToString.converterCamelCase("nome#Composto");
		});
    }
	
	@Test
	public void testePalavraUnicaTodaLower() {
		// nome - “nome” 
		List<String> expected = Arrays.asList("nome");
        List<String> result = CamelCaseToString.converterCamelCase("nome");
        assertEquals(expected, result);
    }
	
	@Test
	public void testePalavraUnicaUpperNoInicio() {
		// Nome - “nome” 
		List<String> expected = Arrays.asList("nome");
        List<String> result = CamelCaseToString.converterCamelCase("Nome");
        assertEquals(expected, result);
    }
	
	@Test
	public void testePalavraCompostaComUperNoMeio() {
		// nomeComposto - “nome”, “composto”
		List<String> expected = Arrays.asList("nome", "composto");
        List<String> result = CamelCaseToString.converterCamelCase("nomeComposto");
        assertEquals(expected, result);
    }
	
	@Test
	public void testePalavraCompostaComUpperNoInicioMeio() {
		// NomeComposto - “nome”, “composto”
		List<String> expected = Arrays.asList("nome", "composto");
        List<String> result = CamelCaseToString.converterCamelCase("NomeComposto");
        assertEquals(expected, result);
    }
	
	@Test
	public void testePalavraUnicaTodaUpper() {
		// CPF - “CPF”
		List<String> expected = Arrays.asList("CPF");
        List<String> result = CamelCaseToString.converterCamelCase("CPF");
        assertEquals(expected, result);
    }
	
	@Test
	public void testePalavraCompostaComFullUpperNoFinal() {
		// numeroCPF - “numero”, “CPF”
		List<String> expected = Arrays.asList("numero", "CPF");
        List<String> result = CamelCaseToString.converterCamelCase("numeroCPF");
        assertEquals(expected, result);
    }
	
	@Test
	public void testePalavraCompostaComFullUpperNoMeio() {
		// numeroCPFContribuinte - “numero”, “CPF”, “contribuinte”
		List<String> expected = Arrays.asList("numero", "CPF", "contribuinte");
        List<String> result = CamelCaseToString.converterCamelCase("numeroCPFContribuinte");
        assertEquals(expected, result);
    }
	
	@Test
	public void testePalavraCompostaComNumeroNoMeio() {
		// recupera10Primeiros - “recupera”, “10”, “primeiros” 
		List<String> expected = Arrays.asList("recupera", "10", "primeiros");
        List<String> result = CamelCaseToString.converterCamelCase("recupera10Primeiros");
        assertEquals(expected, result);
    }
}

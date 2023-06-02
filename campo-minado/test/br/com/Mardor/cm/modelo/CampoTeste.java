package br.com.Mardor.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.Mardor.cm.excecao.ExplosaoException;

public class CampoTeste {

	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}
	
	@Test
	void testeVizinhoDistanciaHorizontal1() {
		Campo vizinhoEsquerda = new Campo(3, 2);
		boolean resultadoEsquerda = campo.adicionarVizinho(vizinhoEsquerda);
		assertTrue(resultadoEsquerda);
		
		Campo vizinhoDireita = new Campo(3, 4);
		boolean resultadoDireita = campo.adicionarVizinho(vizinhoDireita);
		assertTrue(resultadoDireita);
	}
	
	@Test
	void testeVizinhoDistanciaVertical1() {
		Campo vizinhoCima = new Campo(2, 3);
		boolean resultadoCima = campo.adicionarVizinho(vizinhoCima);
		assertTrue(resultadoCima);
		
		Campo vizinhoBaixo = new Campo(4, 3);
		boolean resultadoBaixo = campo.adicionarVizinho(vizinhoBaixo);
		assertTrue(resultadoBaixo);
	}
	
	@Test
	void testeVizinhoDistanciaDiagonal1() {
		Campo vizinhoCimaEsquerda = new Campo(2, 2);
		boolean resultadoCimaEsquerda = campo.adicionarVizinho(vizinhoCimaEsquerda);
		assertTrue(resultadoCimaEsquerda);
		
		Campo vizinhoCimaDireita = new Campo(2, 4);
		boolean resultadoCimaDireita = campo.adicionarVizinho(vizinhoCimaDireita);
		assertTrue(resultadoCimaDireita);
		
		Campo vizinhoBaixoEsquerda = new Campo(4, 2);
		boolean resultadoBaixoEsquerda = campo.adicionarVizinho(vizinhoBaixoEsquerda);
		assertTrue(resultadoBaixoEsquerda);
		
		Campo vizinhoBaixoDireita = new Campo(4, 4);
		boolean resultadoBaixoDireita = campo.adicionarVizinho(vizinhoBaixoDireita);
		assertTrue(resultadoBaixoDireita);
	}
	
	@Test
	void testeNãoVizinho1() {
		Campo vizinho = new Campo(1, 1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}	
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}	
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}	
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}	
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}	
	
	@Test
	void testeAbrirComVizinhos1() {

		Campo campo11 = new Campo(1,1);
		
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	
	@Test
	void testeAbrirComVizinhos2() {
		
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,2);
		campo12.minar();
		
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}	
	
}

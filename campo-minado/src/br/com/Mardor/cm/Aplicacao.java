package br.com.Mardor.cm;

import br.com.Mardor.cm.modelo.Tabuleiro;
import br.com.Mardor.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		new TabuleiroConsole(tabuleiro);
		
	}
}
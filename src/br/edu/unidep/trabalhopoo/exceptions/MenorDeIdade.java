package br.edu.unidep.trabalhopoo.exceptions;

public class MenorDeIdade extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public MenorDeIdade(String mensagem) {
		super(mensagem);
	}
}

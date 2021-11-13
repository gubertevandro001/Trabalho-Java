package br.edu.unidep.trabalhopoo.collections;

import java.util.ArrayList;
import java.util.List;

import br.edu.unidep.trabalhopoo.models.Pessoa;

public class Pessoas {
	
	private static List<Pessoa> pessoas = new ArrayList<>();
	
	
	public static void adicionarPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	
	public static void removerPessoa(Pessoa pessoa) {
		pessoas.remove(pessoa);
	}
	
	public static void mostrarPessoas() {
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}
}

package br.edu.unidep.trabalhopoo.collections;

import java.util.ArrayList;
import java.util.List;

import br.edu.unidep.trabalhopoo.models.Funcionario;


public class Funcionarios {

	private static List<Funcionario> funcionarios = new ArrayList<>();
	
	public static List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public static void adicionarFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	public static void removerFuncionario(Funcionario funcionario) {
		funcionarios.remove(funcionario);
	}
	
	public static void mostrarFuncionarios() {
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}
	}
}


package br.edu.unidep.trabalhopoo.collections;

import java.util.ArrayList;
import java.util.List;

import br.edu.unidep.trabalhopoo.models.Cliente;

public class Clientes {
	
	private static List<Cliente> clientes = new ArrayList<>();
	
	public static List<Cliente> getClientes() {
		return clientes;
	}
	
	public static void adicionarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public static void removerCliente(Cliente cliente) {
		clientes.remove(cliente);
	}
	
	public static void mostrarClientes() {
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
}

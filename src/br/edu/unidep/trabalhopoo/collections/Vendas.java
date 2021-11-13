package br.edu.unidep.trabalhopoo.collections;

import java.util.ArrayList;
import java.util.List;

import br.edu.unidep.trabalhopoo.models.Venda;

public class Vendas {
	
	private static List<Venda> vendas = new ArrayList<>();
	
	
	public static List<Venda> getVendas() {
		return vendas;
	}

	public static void adicionarVenda(Venda venda) {
		vendas.add(venda);
	}
	
	public static void removerVenda(Venda venda) {
		vendas.remove(venda);
	}
	
	public void mostrarVendas() {
		for (Venda venda : vendas) {
			System.out.println(venda);
		}
	}
}

package br.edu.unidep.trabalhopoo.collections;

import java.util.ArrayList;
import java.util.List;

import br.edu.unidep.trabalhopoo.models.Produto;

public class Produtos {
	
	public static List<Produto> produtos = new ArrayList<>();

	public static List<Produto> getProdutos() {
		return produtos;
	}

	public static void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public static void removerProduto(Produto produto) {
		produtos.remove(produto);
	}
	
	public static void alterarEstoqueProduto(int codigoProduto, int quantidade) {
		for (Produto p : produtos) {
			if (p.getCodigoProduto() == codigoProduto) {
				p.setQuantidade(p.getQuantidade() - quantidade);
			}
		}
	}
}

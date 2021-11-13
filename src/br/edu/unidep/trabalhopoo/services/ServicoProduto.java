package br.edu.unidep.trabalhopoo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.edu.unidep.trabalhopoo.collections.Produtos;
import br.edu.unidep.trabalhopoo.exceptions.DadosInvalidos;
import br.edu.unidep.trabalhopoo.exceptions.DataInvalida;
import br.edu.unidep.trabalhopoo.models.Produto;
import br.edu.unidep.trabalhopoo.repositorys.RepositorioProduto;

public class ServicoProduto implements RepositorioProduto {
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	Scanner sc = new Scanner(System.in);
	

	@Override
	public void cadastrarProduto() {
		
		try {
			System.out.print("\nDescrição: ");
			String descricao = sc.next(); sc.nextLine();
			System.out.print("Categoria: ");
			String categoria = sc.nextLine();
			System.out.print("Unidade de Medida: ");
			String unidadeMedida = sc.nextLine();
			System.out.print("Marca: ");
			String marca = sc.nextLine();
			System.out.print("Código de Barras: ");
			String codigoBarras = sc.nextLine();
			System.out.print("Preço de Compra R$: ");
			double precoCompra = sc.nextDouble();
			System.out.print("Preço de Venda R$: ");
			double precoVenda = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();
			System.out.print("Data de Vencimento (DD/MM/YYYY): ");
			Date dataVencimento = sdf.parse(sc.next());
			
			Produto produto = new Produto(descricao, categoria, unidadeMedida, marca, codigoBarras, precoCompra, precoVenda, quantidade, dataVencimento);
			Produtos.adicionarProduto(produto);
		}
		catch (ParseException e) {
			throw new DataInvalida("\nData Inválida!\n");
		}
		catch (InputMismatchException e) {
			throw new DadosInvalidos("\nDados Inválidos!\n");
		}
		
	}

	@Override
	public void excluirProduto() {
		
		try {
			System.out.print("\nInforme o Código do Produto que Deseja Excluir: ");
			int codigo = sc.nextInt();
			
			Produto produto = Produtos.getProdutos().stream().filter(p -> p.getCodigoProduto() == codigo).findFirst().orElse(null);
			
			if (produto != null) {
				Produtos.removerProduto(produto);
			}
			else {
				System.out.println("\nProduto não Encontrado!\n");
			}
		}
		catch (InputMismatchException e) {
			throw new DadosInvalidos("\nDados Inválidos!\n");
		}
	}

	@Override
	public void mostrarProduto() {
		for (Produto p : Produtos.getProdutos()) {
			System.out.println(p.toString());
		}
	}
}

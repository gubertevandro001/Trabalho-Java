package br.edu.unidep.trabalhopoo.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import br.edu.unidep.trabalhopoo.collections.Clientes;
import br.edu.unidep.trabalhopoo.collections.Funcionarios;
import br.edu.unidep.trabalhopoo.collections.Produtos;
import br.edu.unidep.trabalhopoo.collections.Vendas;
import br.edu.unidep.trabalhopoo.exceptions.DadosInvalidos;
import br.edu.unidep.trabalhopoo.models.Cliente;
import br.edu.unidep.trabalhopoo.models.Funcionario;
import br.edu.unidep.trabalhopoo.models.Produto;
import br.edu.unidep.trabalhopoo.models.Venda;
import br.edu.unidep.trabalhopoo.repositorys.RepositorioVenda;

public class ServicoVenda implements RepositorioVenda {
	
	Scanner sc = new Scanner(System.in);

	@Override
	public void cadastrarVenda() {
		
		try {
			System.out.print("\nInforme o Tipo da Venda a Ser Realizada:\n\n1 - Venda Informal (Sem Informações de Cliente e Funcionário)\n2 - Venda Formal (Obrigátorio a Informação de Cliente e Funcionário)\n\nInforme: ");
			int tipoVenda = sc.nextInt();
			
			if (tipoVenda == 1) {
				vendaInformal();
			}
			else if (tipoVenda == 2) {
				vendaFormal();
			}
			else {
				System.out.println("\nOpção Inválida!");
				cadastrarVenda();
			}
		}
		catch (InputMismatchException e) {
			throw new DadosInvalidos("\nDados Inválidos!");
		}
		
	}

	@Override
	public void excluirVenda() {
		
		try {
			System.out.print("\nInforme o Número da Venda Que Deseja Excluir: ");
			int codigoExcluir = sc.nextInt();
			
			Venda vendaExcluir = Vendas.getVendas().stream().filter(vex -> vex.getCodigoVenda() == codigoExcluir).findFirst().orElse(null);
			
			if (vendaExcluir != null) {
				Vendas.removerVenda(vendaExcluir);
			}
			else {
				System.out.println("\nVenda Não Encontrada!");
			}	
		}
		catch (InputMismatchException e) {
			throw new DadosInvalidos("\nDados Inválidos!");
		}
	}

	@Override
	public void mostrarVenda() {
		System.out.print("\nQuais Vendas Deseja Visualizar?\n\n1 - Vendas Formais\n2 - Vendas Informais\n\nInforme: ");
		int opcaoVenda = sc.nextInt();
		
		if (opcaoVenda == 1) {
			for (Venda v : Vendas.getVendas()) {
				if (v.getCliente() == null) {
				}
				else {
					System.out.println(v.toString());
				}
			}
		}
		else if (opcaoVenda == 2) {
			for (Venda v : Vendas.getVendas()) {
				if (v.getCliente() == null) {
					System.out.println(v.toStringInformal());
				}
				else {
				}
			}
		}
		else {
			System.out.println("\nOpção Inválida!");
			mostrarVenda();
		}
	}
	
	public void vendaInformal() {
		
		Venda venda = new Venda();
		
		try {
			if (Produtos.getProdutos().isEmpty()) {
				System.out.println("\nImpossível Realizar a Venda! Não Existe Nenhum Produto Cadastrado!");
				return;
			}
			else {
				System.out.println("\nLista de Produtos Disponíveis: " + "\n");
				System.out.println("\n");
				for (Produto prod : Produtos.getProdutos()) {
					System.out.println("[ Código: " + prod.getCodigoProduto() + " | " + "Nome: " + prod.getDescricao() + " | " + "R$: " + prod.getPrecoVenda() +  " | " + "Estoque: " + prod.getQuantidade() + " ]");
				}
			}
			
			boolean comprando = true;
			
			while (comprando) {
				
				System.out.print("\nInforme o Código do Produto: ");
				int codigo = sc.nextInt();
						
				Produto prod = Produtos.getProdutos().stream().filter(p -> p.getCodigoProduto() == codigo).findFirst().orElse(null);
				Produto prod1 = venda.getProdutos().stream().filter(p1 -> p1.getCodigoProduto() == codigo).findFirst().orElse(null);
				
				if (prod != null) {
					if (prod1 != null) {
						System.out.println("\nProduto Já Informado! Agrupando Saldo...");
						System.out.print("\nInforme a Quantidade: ");
						venda.alterarProdutoVenda(codigo, sc.nextInt());
						comprando = true;
					}
					else {
						System.out.print("\nInforme a Quantidade: ");
						int quantidade = sc.nextInt();

						Produtos.alterarEstoqueProduto(codigo, quantidade);
						venda.adicionarProduto(prod);
						
					}
				}
				else {
					System.out.println("\nProduto Não Encontrado!");
					comprando = true;
				}
			
				System.out.print("\nDeseja Continuar Comprando? \n\n1 - Sim\n2 - Não\n\nInforme: ");
				int opcao = sc.nextInt();
				
				if (opcao == 1) {
					comprando = true;
				}
				else {
					venda.setDataVenda(new Date());
					venda.calcularValorTotal();
					Vendas.adicionarVenda(venda);
					comprando = false;
				}
			}
		}
		catch (InputMismatchException e) {
			throw new DadosInvalidos("\nDados Inválidos!");
		}
	}
	
	public void vendaFormal() {
		
		Venda venda = new Venda();
		
		try {
			if (Clientes.getClientes().isEmpty()) {
				System.out.println("\nImpossível Realizar a Venda! Não existe Nenhum Cliente Cadastrado!");
				return;
			}
			else if (Funcionarios.getFuncionarios().isEmpty()) {
				System.out.println("\nImpossível Realizar a Venda! Não existe Nenhum Funcionário Cadastrado!");
				return;
			}
			else if (Produtos.getProdutos().isEmpty()) {
				System.out.println("\nImpossível Realizar a Venda! Não Existe Nenhum Produto Cadastrado!");
				return;
			}
			else {
				for (Funcionario f : Funcionarios.getFuncionarios()) {
					System.out.println("\n[ Código: " + f.getCodigoFuncionario() + " | " +  "Nome: " + f.getNome() + " ]");
				}
				
				System.out.print("\nInforme o Código do Funcionário Que Irá Realizar a Venda: ");
				int codigoFunc = sc.nextInt();

				Funcionario f = Funcionarios.getFuncionarios().stream().filter(fc -> fc.getCodigoFuncionario() == codigoFunc).findFirst().orElse(null);
				
				if (f != null) {
					System.out.println("\nVerificando Funcionário...");
					Thread.sleep(5);
					System.out.println("\nFunciónario Ok!");
					venda.setFuncionario(f);
				}
				else {
					System.out.println("\nFuncionário Não Encontrado!");
					vendaFormal();
				}
			}
			
			boolean clienteNaoEncontrado = true;
			
			while (clienteNaoEncontrado) {
				
				for (Cliente c : Clientes.getClientes()) {
					System.out.println("\n[ Código: " + c.getCodigoCliente() + " | " + "Nome: " + c.getNome() + "]");
				}
				
				System.out.print("\nInforme o Código do Cliente: ");
				int codigoClt = sc.nextInt();
				
				Cliente c = Clientes.getClientes().stream().filter(cl -> cl.getCodigoCliente() == codigoClt).findFirst().orElse(null);
				
				if (c != null) {
					System.out.println("\nVerificando Cliente...");
					Thread.sleep(5);;
					System.out.println("\nCliente Ok!");
					venda.setCliente(c);
					clienteNaoEncontrado = false;
				}
				else {
					System.out.println("\nCliente Não Encontrado!");
					clienteNaoEncontrado = true;
				}
			}
			
			System.out.println("\nChecando Todas as Informações...");
			Thread.sleep(20);
			System.out.println("\nInformações Ok!");
			
			boolean produtoNaoEncontrado = true;
			
			while (produtoNaoEncontrado) {
				
				for (Produto p : Produtos.getProdutos()) {
					System.out.println("\n[ Código: " + p.getCodigoProduto() + " | " + p.getDescricao() + " | " + "R$: " + p.getPrecoVenda()  + " | " + "Estoque: " + p.getQuantidade() + " ]");
				}
				
				System.out.print("\nInforme o Código do Produto: ");
				int codigoProd = sc.nextInt();
				
				Produto p = Produtos.getProdutos().stream().filter(pr -> pr.getCodigoProduto() == codigoProd).findFirst().orElse(null);
				Produto p1 = venda.getProdutos().stream().filter(p2 -> p2.getCodigoProduto() == codigoProd).findFirst().orElse(null);
				
				if (p != null) {
					if (p1 != null) {
						System.out.println("\nProduto Já Informado! Agrupando Saldo...");
						System.out.print("\nInforme a Quantidade: ");
						venda.alterarProdutoVenda(codigoProd, sc.nextInt());
						produtoNaoEncontrado = true;
					}
					else {
						System.out.print("\nInforme a Quantidade: ");
						int quantidade = sc.nextInt();
							
						Produtos.alterarEstoqueProduto(codigoProd, quantidade);
						venda.adicionarProduto(p);
					}
					
					System.out.print("\nDeseja Continuar Comprando? \n\n1 - Sim\n2- Não\n\nInforme: ");
					int opcao = sc.nextInt();
					
					if (opcao == 1) {
						produtoNaoEncontrado = true;
					}
					else {
						venda.setDataVenda(new Date());
						venda.calcularValorTotal();
						venda.calcularICMS();
						Vendas.adicionarVenda(venda);
						produtoNaoEncontrado = false;
						clienteNaoEncontrado = false;
					}
				}
				else {
					System.out.println("\nProduto Não Encontrado!");
					produtoNaoEncontrado = true;
				}
			}
		}
		catch (InputMismatchException e) {
			throw new DadosInvalidos("\nDados Inválidos!");
		}
		catch (InterruptedException e) {
			System.out.println("\nSeção Interrompida!");
		}
	}
}
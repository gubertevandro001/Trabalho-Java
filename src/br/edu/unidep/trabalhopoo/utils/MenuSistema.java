package br.edu.unidep.trabalhopoo.utils;

import java.util.Scanner;

import br.edu.unidep.trabalhopoo.collections.Produtos;
import br.edu.unidep.trabalhopoo.exceptions.DadosInvalidos;
import br.edu.unidep.trabalhopoo.exceptions.DataInvalida;
import br.edu.unidep.trabalhopoo.services.ServicoCliente;
import br.edu.unidep.trabalhopoo.services.ServicoFuncionario;
import br.edu.unidep.trabalhopoo.services.ServicoProduto;
import br.edu.unidep.trabalhopoo.services.ServicoRelatorioVenda;
import br.edu.unidep.trabalhopoo.services.ServicoVenda;

public class MenuSistema {
	
	Scanner sc = new Scanner(System.in);
	
	ServicoProduto servicoProduto = new ServicoProduto();
	ServicoCliente servicoCliente = new ServicoCliente();
	ServicoFuncionario servicoFuncionario = new ServicoFuncionario();
	ServicoVenda servicoVenda = new ServicoVenda();
	ServicoRelatorioVenda servicoRelatorioVenda = new ServicoRelatorioVenda();
	
	
	public void menuPrincipal() {
		
		try {
		    System.out.print("\n----------Automa��o Comercial----------\n\n1 - Produtos\n2 - Clientes\n3 - Funcion�rios\n4 - Vendas\n5 - Relat�rios\n\nInforme: ");
		    int opcaoPrincipal = sc.nextInt();
		    
		    switch(opcaoPrincipal) {
		    
		    case 1:
		    	menuProdutos();
		    	break;
		    case 2:
		    	menuClientes();
		    	break;
		    case 3:
		    	menuFuncionarios();
		    	break;
		    case 4:
		    	menuVendas();
		    	break;
		    case 5:
		    	menuRelatorios();
		    	break;
		    case 6:
		    	System.out.println("Op��o Inv�lida!");
		    	menuPrincipal();
		    }
		}
		catch (DadosInvalidos e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void menuProdutos() {
		try {
		    System.out.print("\n----------Automa��o Comercial (Produtos)----------\n\n1 - Cadastrar Produto\n2 - Excluir Produto\n3 - Mostrar Produtos\n4 - Menu Principal\n\nInforme: ");
		    int opcaoProduto = sc.nextInt();
		    
		    switch(opcaoProduto) {
		    
		    case 1:
		    	servicoProduto.cadastrarProduto();
		    	menuProdutos();
		    	break;
		    case 2:
		    	servicoProduto.excluirProduto();
		    	menuProdutos();
		    	break;
		    case 3:
		    	servicoProduto.mostrarProduto();
		    	menuProdutos();
		    	break;
		    case 4:
		    	menuPrincipal();
		    	break;
		    default:
		    	System.out.println("Op��o Inv�lida!");
		    	menuProdutos();
		    }
		}
		catch (DataInvalida | DadosInvalidos e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void menuClientes() {
		
		try {
			System.out.print("\n----------Automa��o Comercial (Clientes)----------\n\n1 - Cadastrar Cliente\n2 - Excluir Cliente\n3 - Mostrar Clientes\n4 - Menu Principal\n\nInforme: ");
			int opcaoCliente = sc.nextInt();
			
            switch(opcaoCliente) {
		    
		    case 1:
		    	servicoCliente.cadastrarCliente();
		    	menuClientes();
		    	break;
		    case 2:
		    	servicoCliente.excluirCliente();
		    	menuClientes();
		    	break;
		    case 3:
		    	servicoCliente.mostrarCliente();
		    	menuClientes();
		    	break;
		    case 4:
		    	menuPrincipal();
		    	break;
		    default:
		    	System.out.println("Op��o Inv�lida!");
		    	menuClientes();
		    }
		}
		catch (DataInvalida | DadosInvalidos e) {
			System.out.println(e.getMessage());
		}
	}
	
    public void menuFuncionarios() {
		
		try {
			System.out.print("\n----------Automa��o Comercial (Funcion�rios)----------\n\n1 - Cadastrar Funcion�rio\n2 - Excluir Funcion�rio\n3 - Mostrar Funcion�rios\n4 - Menu Principal\n\nInforme: ");
			int opcaoFuncionario = sc.nextInt();
			
            switch(opcaoFuncionario) {
		    
		    case 1:
		    	servicoFuncionario.cadastrarFuncionario();
		    	menuFuncionarios();
		    	break;
		    case 2:
		    	servicoFuncionario.excluirFuncionario();
		    	menuFuncionarios();
		    	break;
		    case 3:
		    	servicoFuncionario.mostrarFuncionario();
		    	menuFuncionarios();
		    	break;
		    case 4:
		    	menuPrincipal();
		    	break;
		    default:
		    	System.out.println("Op��o Inv�lida!");
		    	menuFuncionarios();
		    }
		}
		catch (DataInvalida | DadosInvalidos e) {
			System.out.println(e.getMessage());
		}
	} 
    
    public void menuVendas() {
		
		try {
			System.out.print("\n----------Automa��o Comercial (Vendas)----------\n\n1 - Cadastrar Venda\n2 - Excluir Venda\n3 - Mostrar Vendas\n4 - Menu Principal\n\nInforme: ");
			int opcaoVenda = sc.nextInt();
			
            switch(opcaoVenda) {
		    
		    case 1:
		    	servicoVenda.cadastrarVenda();
		    	menuVendas();
		    	break;
		    case 2:
		    	servicoVenda.excluirVenda();
		    	menuVendas();
		    	break;
		    case 3:
		    	servicoVenda.mostrarVenda();
		    	menuVendas();
		    	break;
		    case 4:
		    	menuPrincipal();
		    	break;
		    default:
		    	System.out.println("Op��o Inv�lida!");
		    	menuVendas();
		    }
		}
		catch (DadosInvalidos e) {
			System.out.println(e.getMessage());
		}
	}
    
    public void menuRelatorios() {
    	
    	try {
    		System.out.print("\n----------Automa��o Comercial (Relat�rios)----------\n\n1 - Gerar Relat�rio de Vendas\n2 - Mostrar Relat�rio de Vendas\n3 - Menu Principal\n\nInforme: ");
			int opcaoRelatorio = sc.nextInt();
			
			switch (opcaoRelatorio) {
			
			case 1:
				servicoRelatorioVenda.gerarRelatorioVenda();
				menuRelatorios();
				break;
			case 2:
				servicoRelatorioVenda.imprimirRelatorioVenda();
				menuRelatorios();
				break;
			case 3:
				menuPrincipal();
				break;
			default:
				System.out.println("Op��o Inv�lida!");
				menuRelatorios();
			}
    	}
    	catch (DadosInvalidos e) {
    		System.out.println(e.getMessage());
    	}
    }
}

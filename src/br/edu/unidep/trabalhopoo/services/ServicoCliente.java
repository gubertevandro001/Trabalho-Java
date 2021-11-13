package br.edu.unidep.trabalhopoo.services;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.edu.unidep.trabalhopoo.collections.Clientes;
import br.edu.unidep.trabalhopoo.collections.Pessoas;
import br.edu.unidep.trabalhopoo.exceptions.DadosInvalidos;
import br.edu.unidep.trabalhopoo.exceptions.DataInvalida;
import br.edu.unidep.trabalhopoo.models.Cliente;
import br.edu.unidep.trabalhopoo.repositorys.RepositorioCliente;

public class ServicoCliente implements RepositorioCliente {
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void cadastrarCliente() {
		
		try {
			System.out.print("\nNome: ");
			String nome = sc.nextLine();
			System.out.print("CPF: ");
			String cpf = sc.nextLine();
			System.out.print("RG: ");
			String rg = sc.nextLine();
			System.out.print("Data de Nascimento (DD/MM/YYYY): ");
			Date dataNascimento = sdf.parse(sc.nextLine());
			System.out.print("Sexo: ");
			char sexo = sc.nextLine().charAt(0);
			System.out.print("Número do Celular: ");
			String numeroCelular = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Endereço: ");
			String endereco = sc.nextLine();
			System.out.print("Bairro: ");
			String bairro = sc.nextLine();
			System.out.print("CEP: ");
			String cep = sc.nextLine();
			System.out.print("Cidade: ");
			String cidade = sc.nextLine();
			System.out.print("Estado: ");
			String estado = sc.nextLine();
			System.out.print("Data de Cadastro (DD/MM/YYYY): ");
			Date dataCadastro = sdf.parse(sc.nextLine());
			System.out.print("Limite de Crédito: ");
			double limiteCredito = sc.nextDouble();
			
			Cliente cliente = new Cliente(nome, cpf, rg, dataNascimento, sexo, numeroCelular, email, endereco, bairro, cep, cidade, estado, dataCadastro, limiteCredito);
			cliente.calcularIdade();
			Clientes.adicionarCliente(cliente);
			Pessoas.adicionarPessoa(cliente);
			System.out.println("\n" + cliente.mostrarIdade() + "\n");

			
		}
		catch (InputMismatchException e) {
			throw new DadosInvalidos("\nDados Inválidos!\n");
		}
		catch (ParseException e) {
			throw new DataInvalida("\nData no Formato Inválido!\n");
		}
	}

	@Override
	public void excluirCliente() {
		try {
		    System.out.print("\nInforme o Código do Cliente que Deseja Excluir: ");
		    int codigoCliente = sc.nextInt();
		    
		    Cliente cliente = Clientes.getClientes().stream().filter(c -> c.getCodigoCliente() == codigoCliente).findFirst().orElse(null);
		    
		    if (cliente != null) {
		    	Clientes.removerCliente(cliente);
		    }
		    else {
		    	System.out.println("\nCliente não encontrado\n");
		    }
		}
		catch (InputMismatchException e) {
			throw new DadosInvalidos("\nCódigo Inválido!\n");
		}
	}

	@Override
	public void mostrarCliente() {
		Clientes.mostrarClientes();
	}
}

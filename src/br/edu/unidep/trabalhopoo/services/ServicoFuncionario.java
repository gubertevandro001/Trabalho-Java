package br.edu.unidep.trabalhopoo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.edu.unidep.trabalhopoo.collections.Funcionarios;
import br.edu.unidep.trabalhopoo.collections.Pessoas;
import br.edu.unidep.trabalhopoo.exceptions.DadosInvalidos;
import br.edu.unidep.trabalhopoo.exceptions.DataInvalida;
import br.edu.unidep.trabalhopoo.models.Funcionario;
import br.edu.unidep.trabalhopoo.repositorys.RepositorioFuncionario;

public class ServicoFuncionario implements RepositorioFuncionario{
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	Scanner sc = new Scanner (System.in);

	@Override
	public void cadastrarFuncionario() {
		
		try {
			System.out.println("\nNome: ");
			String nome = sc.next();
			System.out.println("CPF: ");
			String cpf = sc.next();
			System.out.println("RG: ");
			String rg = sc.next();
			System.out.println("Data de Nascimento (DD/MM/YYYY): ");
			Date dataNascimento = sdf.parse(sc.next());
			System.out.println("Sexo: ");
			char sexo = sc.next().charAt(0);
			System.out.println("Número do Celular: ");
			String numeroCelular = sc.next();
			System.out.println("Email: ");
			String email = sc.next();
			System.out.println("Endereço: ");
			String endereco = sc.next();
			System.out.println("Bairro: ");
			String bairro = sc.next();
			System.out.println("CEP: ");
			String cep = sc.next();
			System.out.println("Cidade: ");
			String cidade = sc.next();
			System.out.println("Estado: ");
			String estado = sc.next();
			System.out.println("Cargo: ");
			String cargo = sc.next();
			System.out.println("Número CTPS: ");
			String numeroCtps = sc.next();
			System.out.println("Salário R$: ");
			double salario = sc.nextDouble();
			System.out.println("Regime de Trabalho (Integral|Parcial): ");
			String regime = sc.next();
			System.out.println("Data de Admissão (DD/MM/YYYY): ");
			Date dataAdmissao = sdf.parse(sc.next());
			
			System.out.println("Este é o seu Trabalho Atual?\n1 - Sim \n2 - Não\nInforme: ");
			int opcao = sc.nextInt();
			
			if (opcao == 1) {
				Date dataDemissao1 = sdf.parse("00/00/0000");
				Funcionario funcionario = new Funcionario(nome, cpf, rg, dataNascimento, sexo, numeroCelular, email, endereco, bairro, cep, cidade, estado, cargo, numeroCtps, salario, regime, dataAdmissao, dataDemissao1);
				Funcionarios.adicionarFuncionario(funcionario);
				Pessoas.adicionarPessoa(funcionario);
				funcionario.mostrarIdade();
			}
			else {
				System.out.print("Data de demissão (DD/MM/YYYY): ");
				Date dataDemissao2 = sdf.parse(sc.next());
				Funcionario funcionario = new Funcionario(nome, cpf, rg, dataNascimento, sexo, numeroCelular, email, endereco, bairro, cep, cidade, estado, cargo, numeroCtps, salario, regime, dataAdmissao, dataDemissao2);
				Funcionarios.adicionarFuncionario(funcionario);
				Pessoas.adicionarPessoa(funcionario);
				funcionario.mostrarIdade();
			}
		}
		catch (InputMismatchException e) {
			throw new DadosInvalidos("Dados Inválidos!");
		}
		catch (ParseException e) {
			throw new DataInvalida("Data no Formato Inválido!");
		}
	}

	@Override
	public void excluirFuncionario() {
		
		try {
			System.out.print("\nInforme o Código do Funcionario que Deseja Excluir?: ");
			int codigo = sc.nextInt();
			
			Funcionario funcionario = Funcionarios.getFuncionarios().stream().filter(f -> f.getCodigoFuncionario() == codigo).findFirst().orElse(null);
			
			if (funcionario != null) {
				Funcionarios.removerFuncionario(funcionario);
			}
			else {
				System.out.println("Funcionario Não Encontrado!");
			}
		}
		catch (InputMismatchException e) {
			throw new DadosInvalidos("Dados Inválidos!");
		}
		
	}

	@Override
	public void mostrarFuncionario() {
		Funcionarios.mostrarFuncionarios();
	}
}

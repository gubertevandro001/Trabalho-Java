package br.edu.unidep.trabalhopoo.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.edu.unidep.trabalhopoo.exceptions.MenorDeIdade;
import br.edu.unidep.trabalhopoo.utils.ValidadorCodigo;

public class Cliente extends Pessoa {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static final Random random = new Random();
	
	public static List<Integer> codigosCliente = new ArrayList<>();
	
	private Integer codigoCliente = ValidadorCodigo.validaCodigo(random.nextInt(100), codigosCliente);
	private Date dataCadastro;
	private double limiteCredito;
	
	public Cliente() {
	}

	public Cliente(String nome, String cpf, String rg, Date dataNascimento,
			char sexo, String numeroCelular, String email, String endereco, String bairro, String cep, String cidade,
			String estado, Date dataCadastro, double limiteCredito) {
		super(nome, cpf, rg, dataNascimento, sexo, numeroCelular, email, endereco, bairro, cep,
				cidade, estado);
		this.dataCadastro = dataCadastro;
		this.limiteCredito = limiteCredito;
	}
	
	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	@Override
	public int calcularIdade() {
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
		cal.setTime(getDataNascimento());
		cal1.setTime(new Date());
		int anoNascimento = cal.get(Calendar.YEAR);
		int anoAtual = cal1.get(Calendar.YEAR);
		setIdade(anoAtual - anoNascimento);
		return getIdade();
	}
	
	public String mostrarIdade() {
		int idade = calcularIdade();
		
		if (idade >= 16 && idade < 18) {
			return "Cliente poderá ter um cadastro desde que tenha aprovação de um responsável";
		}
		else if (idade >= 18) {
			return "Cliente poderá ter um cadastro sujeito a consulta SPC";
		}
		else {
			throw new MenorDeIdade("Não poderá ter um cadastro devido idade ser menor do que 16 anos");
		}
	}
	
	public String toString() {
		return super.toString() + "\nID Cliente: " + codigoCliente + "\nData de Cadastro: " + sdf.format(dataCadastro) + "\nLimite de Crédito R$: " + limiteCredito;
	}
}

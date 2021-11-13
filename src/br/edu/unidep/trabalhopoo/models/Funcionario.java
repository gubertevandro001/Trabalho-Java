package br.edu.unidep.trabalhopoo.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.edu.unidep.trabalhopoo.exceptions.MenorDeIdade;
import br.edu.unidep.trabalhopoo.utils.ValidadorCodigo;


public class Funcionario extends Pessoa {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static final Random random = new Random();
	
	public static List<Integer> codigosFuncionario = new ArrayList<>();
	
	private Integer codigoFuncionario = ValidadorCodigo.validaCodigo(random.nextInt(100), codigosFuncionario);
	private String cargo;
	private String numeroCtps;
	private Double salario;
	private String regime;
	private Date dataAdmissao;
	private Date dataDemissao;
	
	public Funcionario() {
	}

	public Funcionario(String nome, String cpf, String rg, Date dataNascimento,
			char sexo, String numeroCelular, String email, String endereco, String bairro, String cep, String cidade,
			String estado, String cargo, String numeroCtps, Double salario, String regime, Date dataAdmissao,
			Date dataDemissao) {
		super(nome, cpf, rg, dataNascimento, sexo, numeroCelular, email, endereco, bairro, cep,
				cidade, estado);
		this.cargo = cargo;
		this.numeroCtps = numeroCtps;
		this.salario = salario;
		this.regime = regime;
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
	}
	
	public Integer getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(Integer codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNumeroCtps() {
		return numeroCtps;
	}

	public void setNumeroCtps(String numeroCtps) {
		this.numeroCtps = numeroCtps;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
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
			return "Colaborador poderá ser vinculado a empresa como Menor Aprendiz";
		}
		else if (idade >= 18) {
			return "Colaborador poderá ser vinculado a empresa com contrato efetivo";
		}
		else {
			throw new MenorDeIdade("Não poderá ter um vinculo a empresa");
		}
	}
	
	public String toString() {
		return super.toString() + "\nCodFunc: " + codigoFuncionario + "\nCargo: " + cargo + "\nNúmero CTPS: " + numeroCtps + "\nSalário R$: " + salario +
				"\nRegime: " + regime + "\nData de Admissão: " + sdf.format(dataAdmissao) + "\nData de Demissão: " + sdf.format(dataDemissao);
	}
}

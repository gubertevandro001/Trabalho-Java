package br.edu.unidep.trabalhopoo.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.edu.unidep.trabalhopoo.utils.ValidadorCodigo;


public abstract class Pessoa {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static final Random random = new Random();
	
	public static List<Integer> codigosPessoa = new ArrayList<>();
	
	private Integer codigoPessoa = ValidadorCodigo.validaCodigo(random.nextInt(100), codigosPessoa);
	private String nome;
	private String cpf;
	private String rg;
	private Date dataNascimento;
	private Integer idade;
	private char sexo;
	private String numeroCelular;
	private String email;
	private String endereco;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	
	public Pessoa() {
	}

	public Pessoa(String nome, String cpf, String rg, Date dataNascimento,
			char sexo, String numeroCelular, String email, String endereco, String bairro, String cep, String cidade,
			String estado) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.numeroCelular = numeroCelular;
		this.email = email;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Integer getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(Integer codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	public abstract int calcularIdade();
	
	public String toString() {
		StringBuilder stb = new StringBuilder();
		stb.append("\nID Pessoa: " + codigoPessoa + "\nNome: " + nome + "\nCPF: " + cpf + "\nRG: " + rg);
		stb.append("\nData de Nascimento: " + sdf.format(dataNascimento) + "\nIdade: " + idade + "\nSexo: " + sexo);
		stb.append("\nNúmero do Celular: " + numeroCelular + "\nEmail: " + email + "\nEndereço: " + endereco + "\nBairro: " + bairro);
		stb.append("\nCEP: " + cep + "\nCidade: " + cidade + "\nEstado: " + estado);
		
		return stb.toString();
	}
}

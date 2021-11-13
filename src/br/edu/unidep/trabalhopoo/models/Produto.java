package br.edu.unidep.trabalhopoo.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.edu.unidep.trabalhopoo.utils.ValidadorCodigo;

public class Produto {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static final Random random = new Random();
	
	private static List<Integer> codigosProduto = new ArrayList<>();
	
	private Integer codigoProduto = ValidadorCodigo.validaCodigo(random.nextInt(100), codigosProduto);
	private String descricao;
	private String categoria;
	private String unidadeMedida;
	private String marca;
	private String codigoBarras;
	private Double precoCompra;
	private Double precoVenda;
	private Integer quantidade;
	private Date dataVencimento;
	
	
	public Produto() {
	}


	public Produto(String descricao, String categoria, String unidadeMedida, String marca,
			String codigoBarras, Double precoCompra, Double precoVenda, Integer quantidade, Date dataVencimento) {
		super();
		this.descricao = descricao;
		this.categoria = categoria;
		this.unidadeMedida = unidadeMedida;
		this.marca = marca;
		this.codigoBarras = codigoBarras;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
		this.dataVencimento = dataVencimento;
	}


	public Integer getCodigoProduto() {
		return codigoProduto;
	}


	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getUnidadeMedida() {
		return unidadeMedida;
	}


	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getCodigoBarras() {
		return codigoBarras;
	}


	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}


	public Double getPrecoCompra() {
		return precoCompra;
	}


	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}


	public Double getPrecoVenda() {
		return precoVenda;
	}


	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Date getDataVencimento() {
		return dataVencimento;
	}


	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public String toString() {
		StringBuilder stb = new StringBuilder();
		
		stb.append("\nID Produto: " + codigoProduto + "\nDescrição: " + descricao + "\nCategoria: " + categoria);
		stb.append("\nUnidade de Medida: " + unidadeMedida + "\nMarca: " + marca + "\nCódigo de Barras: " + codigoBarras);
		stb.append("\nPreço de Compra R$: " + precoCompra + "\nPreço de Venda R$: " + precoVenda + "\nQuantidade: " + quantidade + "\nData de Vencimento: " + dataVencimento);
		
		return stb.toString();
	}
	
	

}

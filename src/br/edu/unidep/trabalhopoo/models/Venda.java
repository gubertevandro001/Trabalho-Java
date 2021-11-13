package br.edu.unidep.trabalhopoo.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.edu.unidep.trabalhopoo.interfaces.Imposto;
import br.edu.unidep.trabalhopoo.utils.TabelaIcms;
import br.edu.unidep.trabalhopoo.utils.ValidadorCodigo;

public class Venda implements Imposto{
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static final Random random = new Random();
	
	private static List<Integer> codigosVenda = new ArrayList<>();
	
	private Integer codigoVenda = ValidadorCodigo.validaCodigo(random.nextInt(100), codigosVenda);
	private Cliente cliente;
	private Funcionario funcionario;
	private Date dataVenda;
	private Double valorTotal;

	private List<Produto> produtosVenda = new ArrayList<>();
	
	
	public Venda() {
	}

	public Venda(Cliente cliente, Funcionario funcionario, Date dataVenda) {
		super();
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.dataVenda = dataVenda;
	}

	public Integer getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(Integer codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public List<Produto> getProdutos() {
		return produtosVenda;
	}

	public void adicionarProduto(Produto produto) {
		produtosVenda.add(produto);
	}
	
	public void alterarProdutoVenda(int codigo, int quantidade) {
		for (Produto produto : produtosVenda) {
			if (codigo == produto.getCodigoProduto()) {
				produto.setQuantidade(quantidade + produto.getQuantidade());
			}
		}
	}
	
	@Override
	public double calcularICMS() {
		if (getCliente().getEstado().equals("PR")) {
			return valorTotal * TabelaIcms.ICMS_PARANA;
		}
		else {
			return valorTotal * TabelaIcms.ICMS_OUTROS_ESTADOS; 
		}
	}
	
	public double mostrarIcms() {
		double icms = calcularICMS();
		return icms;
	}
	
	public double calcularValorTotal() {
		double vtotal = 0;
		for (Produto produto : produtosVenda) {
			vtotal += produto.getQuantidade() * produto.getPrecoVenda();
		}
		setValorTotal(vtotal);
		return valorTotal;
	}
	
	public String toString() {
		return "\nID Venda: " + codigoVenda + "\nCliente: " + getCliente().getNome() + "\nFuncionario: " + getFuncionario().getNome() + "\nData da Venda: " + sdf.format(dataVenda) + "\nValor Total R$: " +
				+ valorTotal + "\nValor ICMS R$: " + mostrarIcms();
	}
	
	public String toStringInformal() {
		return "\nID Venda: " + codigoVenda + "\nData da Venda: " + sdf.format(dataVenda) + "\nValor Total R$: " + valorTotal + "\n";
		
	}
}

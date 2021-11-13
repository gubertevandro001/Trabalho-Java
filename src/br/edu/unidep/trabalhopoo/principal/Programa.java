package br.edu.unidep.trabalhopoo.principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import br.edu.unidep.trabalhopoo.collections.Vendas;
import br.edu.unidep.trabalhopoo.models.Cliente;
import br.edu.unidep.trabalhopoo.models.Funcionario;
import br.edu.unidep.trabalhopoo.models.Pessoa;
import br.edu.unidep.trabalhopoo.models.Venda;
import br.edu.unidep.trabalhopoo.services.ServicoCliente;
import br.edu.unidep.trabalhopoo.services.ServicoProduto;
import br.edu.unidep.trabalhopoo.services.ServicoVenda;
import br.edu.unidep.trabalhopoo.utils.MenuSistema;

public class Programa {
	
	public static void main (String[] args) {
		
		MenuSistema menu = new MenuSistema();
		
		menu.menuPrincipal();
	}
}

package br.edu.unidep.trabalhopoo.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unidep.trabalhopoo.collections.Vendas;
import br.edu.unidep.trabalhopoo.models.Venda;

public class ServicoRelatorioVenda {
	
	List<String> infosVenda = new ArrayList<>();
	
	int countVendasFormais = 0;
	int countVendasInformais = 0;
	
	
	public void gerarRelatorioVenda() {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("C://PerfLogs//venda.txt", true))) {
			
			if (Vendas.getVendas().isEmpty()) {
				System.out.println("\nNenhuma Venda Informal!");
			}
			else {
				for (Venda venda : Vendas.getVendas()) {
					countVendasInformais += 1;
					bw.append(String.valueOf(venda.toStringInformal()));
			   }
				System.out.println("\nTotal de Vendas Informais Gravadas: " + countVendasInformais);
			}
			
			if (Vendas.getVendas().isEmpty()) {
				System.out.println("\nNenhuma Venda Formal!");
			}
			else {
				for (Venda venda : Vendas.getVendas()) {
					if (venda.getCliente() == null) {
					}
					else {
						countVendasFormais += 1;
						bw.append(String.valueOf(venda));
					}
					System.out.println("\nTotal de Vendas Formais Gravadas: " + countVendasFormais);
			   }
			}
			
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void imprimirRelatorioVenda() {
		
		try (BufferedReader br = new BufferedReader(new FileReader("C://PerfLogs//venda.txt"))) {
			
			String imprimir = br.readLine();
			
			while (imprimir != null) {
				infosVenda.add(imprimir);
				imprimir = br.readLine();
			}
			
			System.out.println("\nVendas Registradas");
			
			for (String infoVenda : infosVenda) {
				System.out.println(infoVenda);
			}
			
			infosVenda.clear();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

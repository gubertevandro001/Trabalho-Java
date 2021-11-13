package br.edu.unidep.trabalhopoo.utils;

import java.util.List;
import java.util.Random;

public class ValidadorCodigo {
	
	public static Random random = new Random();

	
	public static int validaCodigo(Integer codigo, List<Integer> codigos) {
		if (codigos.isEmpty()) {
			codigos.add(codigo);
		}
		else {
			for (Integer cod : codigos) {
				if (cod == codigo) {
					codigo = random.nextInt(100);
				}
				else {
					codigos.add(codigo);
					return codigo;
				}
			}
		}
		return codigo;
		
	}
}

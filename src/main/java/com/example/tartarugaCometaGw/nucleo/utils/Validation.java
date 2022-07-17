package com.example.tartarugaCometaGw.nucleo.utils;

import java.util.InputMismatchException;

public class Validation {
	
	public String removerMascara(String str){ return str.replaceAll("\\D", ""); }
	
	public boolean isCNPJ(String CNPJ) {
	    if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
	        CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
	        CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
	        CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
	        CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
	       (CNPJ.length() != 14))
	       return(false);

	    char dig13, dig14;
	    int sm, i, r, num, peso;

	    try {
	      sm = 0;
	      peso = 2;
	      for (i=11; i>=0; i--) {
	        num = (int)(CNPJ.charAt(i) - 48);
	        sm = sm + (num * peso);
	        peso = peso + 1;
	        if (peso == 10)
	           peso = 2;
	      }

	      r = sm % 11;
	      if ((r == 0) || (r == 1))
	         dig13 = '0';
	      else dig13 = (char)((11-r) + 48);

	      sm = 0;
	      peso = 2;
	      for (i=12; i>=0; i--) {
	        num = (int)(CNPJ.charAt(i)- 48);
	        sm = sm + (num * peso);
	        peso = peso + 1;
	        if (peso == 10)
	           peso = 2;
	      }

	      r = sm % 11;
	      if ((r == 0) || (r == 1))
	         dig14 = '0';
	      else dig14 = (char)((11-r) + 48);

	      if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
	         return(true);
	      else return(false);
	    } catch (InputMismatchException erro) {
	        return(false);
	    }
	  }

	 public static String imprimeCNPJ(String CNPJ) {
	    return(CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." +
	      CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
	      CNPJ.substring(12, 14));
	  }
	  
	 // -------------------------------------------------------------------
	 
    private final int[] PESO_CPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

	public boolean isValidCpf(String cpf) {
		cpf = removerMascara(cpf);	
		String cpfSomenteDigitos = cpf.replaceAll("\\D", "");
		
		if ((cpfSomenteDigitos == null) || (cpfSomenteDigitos.length() != 11) || cpfSomenteDigitos.equals("00000000000")
				|| cpfSomenteDigitos.equals("11111111111") || cpfSomenteDigitos.equals("22222222222")
				|| cpfSomenteDigitos.equals("33333333333") || cpfSomenteDigitos.equals("44444444444")
				|| cpfSomenteDigitos.equals("55555555555") || cpfSomenteDigitos.equals("66666666666")
				|| cpfSomenteDigitos.equals("77777777777") || cpfSomenteDigitos.equals("88888888888")
				|| cpfSomenteDigitos.equals("99999999999")) {
			return false;
		}
		
		Integer digito1 = calcularDigitoCpf(cpfSomenteDigitos.substring(0, 9), PESO_CPF);
		Integer digito2 = calcularDigitoCpf(cpfSomenteDigitos.substring(0, 9) + digito1, PESO_CPF);

		return cpfSomenteDigitos.equals(cpfSomenteDigitos.substring(0, 9) + digito1.toString() + digito2.toString());
	}
		
	private int calcularDigitoCpf(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	public static String formatCPF(String cpf) {
		Validation vl = new Validation();
		cpf = vl.removerMascara(cpf);
		String cpfFormatado = cpf.substring(0,3)+"."+cpf.substring(3,6)+"."+cpf.substring(6,9)+"-"+cpf.substring(9,11);
		return cpfFormatado;
	}
}


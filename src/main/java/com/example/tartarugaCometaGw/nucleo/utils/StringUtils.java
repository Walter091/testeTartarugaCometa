package com.example.tartarugaCometaGw.nucleo.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class StringUtils {

	public static String formatarCpf(String cpf) {
		cpf = cpf.replaceAll("\\D", ""); // Removo todos os caracteres não-numéricos
		String mascara = "###.###.###-##";
		
		try {
			javax.swing.text.MaskFormatter formatadorCpf = new javax.swing.text.MaskFormatter(mascara);
			javax.swing.JFormattedTextField txtCpf = new javax.swing.JFormattedTextField(formatadorCpf);
			txtCpf.setText(cpf);
			return txtCpf.getText();
			
		} catch (java.text.ParseException e) {
			e.printStackTrace();
			return "";
		}
		
	}
	
	public static String formatedDinheiro(Float valor) {
		Locale localeBR = new Locale("pt","BR");
		double valorReal = valor;
		NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);

		return dinheiro.format(valorReal);
		
	}
}

package com.craftcoder.java8;

import java.util.function.Predicate;

public class StringFormatter {

	public void formataPeloTamanho(String texto) {
		if (texto.length() > 5) {
			System.out.println("Formatando o Texto: " + texto);
		}
	}

	public void formataPelaInicial(String texto) {;
		if (texto.startsWith("J")) {
			System.out.println("Formatando o Texto: " + texto);
		}
	}

	public void format(Predicate<String> filter, String texto) {
		if (filter.test(texto)) {
			System.out.println("Formatando o Texto: " + texto);
		}
	}

}

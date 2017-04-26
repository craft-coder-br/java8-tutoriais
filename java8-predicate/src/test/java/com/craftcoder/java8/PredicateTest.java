package com.craftcoder.java8;

import static org.junit.Assert.assertTrue;

import java.util.function.Predicate;

import org.junit.Test;

public class PredicateTest {

	@Test
	public void deveriaFormatarPeloTamanho() throws Exception {
		StringFormatter formatter = new StringFormatter();

		formatter.formataPeloTamanho("CDI e Spring - Craft Coder");
	}

	@Test
	public void deveriaFormatarPelaInicial() throws Exception {
		StringFormatter formatter = new StringFormatter();

		formatter.formataPelaInicial("Java 8 - Craft Coder");
	}

	@Test
	public void deveriaTestarOTamanhoDoTexto() throws Exception {
		Predicate<String> filtro = new Predicate<String>() {

			@Override
			public boolean test(String texto) {
				return texto.length() > 5;
			}
		};

		boolean ehMaiorQue5 = filtro.test("CDI e Spring - Craft Coder");

		assertTrue(ehMaiorQue5);
	}

	@Test
	public void deveriaTestarOTamanhoDoTextoComPredicate() throws Exception {
		Predicate<String> filtroPorTamanho = new Predicate<String>() {

			@Override
			public boolean test(String texto) {
				return texto.length() > 5;
			}
		};

		StringFormatter formatter = new StringFormatter();

		formatter.format(filtroPorTamanho, "CDI e Spring - Craft Coder");
	}

	@Test
	public void deveriaTestarOTamanhoDoTextoComPredicateUsandoLambda() throws Exception {
		Predicate<String> filtroPorTamanho = texto -> texto.length() > 5;

		StringFormatter formatter = new StringFormatter();

		formatter.format(filtroPorTamanho, "CDI e Spring - Craft Coder");
	}

	@Test
	public void deveriaTestarOTamanhoDoTextoComPredicateUsandoLambdaInline() throws Exception {
		StringFormatter formatter = new StringFormatter();

		formatter.format(texto -> texto.length() > 5, "CDI e Spring - Craft Coder");
		formatter.format(texto -> texto.startsWith("J"), "Java 8 - Craft Coder");
		formatter.format(texto -> texto.equals("Java 8"), "Java 8");
	}

}

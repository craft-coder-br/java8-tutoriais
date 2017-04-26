package com.craftcoder.java8;

import java.util.function.Consumer;

import org.junit.Test;

public class ConsumerTest {

	@Test
	public void deveriaImprimirNoConsole() throws Exception {
		Printer printer = new Printer();

		printer.imprimeNoConsole("Minha Mensagem");
	}

	@Test
	public void deveriaImprimirNoArquivo() throws Exception {
		Printer printer = new Printer();

		printer.imprimeNoArquivo("Minha Mensagem");
	}

	@Test
	public void deveriaUsarUmConsumerParaImpressao() throws Exception {
		Consumer<String> operacao = new Consumer<String>() {

			@Override
			public void accept(String texto) {
				System.out.println("Executando operacao malandra: " + texto);
			}
		};

		operacao.accept("Parametro da Operacao");
	}

	@Test
	public void deveriaImprimirNoConsoleDeUmaFormaMaisGenericaUsandoClasseAnonima() throws Exception {
		Consumer<String> consolePrinter = new Consumer<String>() {

			@Override
			public void accept(String texto) {
				System.out.println("Imprime no Console: " + texto);
			}
		};

		Printer printer = new Printer();

		printer.imprime(consolePrinter, "Minha Mensagem");
	}

	@Test
	public void deveriaImprimirNoConsoleDeUmaFormaMaisGenericaUsandoJava8Lambda() throws Exception {
		Consumer<String> consolePrinter = texto -> System.out.println("Imprime no Console: " + texto);

		imprime(consolePrinter, "Minha Mensagem");
	}

	@Test
	public void deveriaImprimirNoConsolePassandoOLambdaComoParametro() throws Exception {
		imprime(texto -> System.out.println("Imprime no Console: " + texto), "Minha Mensagem");
	}

	public void imprime(Consumer<String> printer, String mensagem) {
		printer.accept(mensagem);
	}

}

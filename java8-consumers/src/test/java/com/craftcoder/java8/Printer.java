package com.craftcoder.java8;

import java.util.function.Consumer;

public class Printer {

	public void imprimeNoConsole(String mensagem) {
		System.out.println("Imprime no Console: " + mensagem);
	}

	public void imprimeNoArquivo(String mensagem) {
		System.out.println("Imprime no Arquivo: " + mensagem);
	}

	public void imprime(Consumer<String> printer, String mensagem) {
		printer.accept(mensagem);
	}

}

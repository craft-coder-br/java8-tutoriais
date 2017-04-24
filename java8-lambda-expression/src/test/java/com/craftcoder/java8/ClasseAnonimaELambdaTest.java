package com.craftcoder.java8;

import org.junit.Test;

public class ClasseAnonimaELambdaTest {

	private String mensagem = "Rodando com sucesso";

	@Test
	public void deveriaUsarClasseAnonimaParaORunnable() throws Exception {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("Rodando dentro da Classe Anônima!");
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
	}

	@Test
	public void deveriaUsarClasseAnonimaParaORunnableUsandoAVariavelDeInstancia() throws Exception {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println(mensagem);
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
	}

	@Test
	public void deveriaUsarClasseAnonimaParaORunnableUsandoSuaPropriaVariavelDeInstancia() throws Exception {
		Runnable runnable = new Runnable() {

			private String mensagem = "Dentro do objeto criado pela classe anônima";
			@Override
			public void run() {
				System.out.println(this.mensagem);
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
	}

	@Test
	public void deveriaUsarLambdaParaORunnable() throws Exception {
		Runnable runnable = () -> System.out.println("Rodando com Lambda!");

		Thread thread = new Thread(runnable);
		thread.start();
	}

	@Test
	public void deveriaUsarLambdaParaORunnableUsandoAVariavelDeInstancia() throws Exception {
		Runnable runnable = () -> System.out.println(mensagem);

		Thread thread = new Thread(runnable);
		thread.start();
	}

	@Test
	public void deveriaUsarLambdaParaORunnableUsandoSeuProprioAtributo() throws Exception {
		Runnable runnable = () -> {
			String mensagem = "Dentro do Lambda"; //warning

			System.out.println(this.mensagem); //usando da instância da classe ClasseAnonimaELambdaTest
		};

		Thread thread = new Thread(runnable);
		thread.start();
	}

}

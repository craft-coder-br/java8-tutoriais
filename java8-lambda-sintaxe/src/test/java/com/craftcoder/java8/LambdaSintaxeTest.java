package com.craftcoder.java8;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;

import org.junit.Test;

public class LambdaSintaxeTest {

	@Test
	public void deveriaUsarClasseAnonima() throws Exception {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("Rodando com Runnable");
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
	}

	@Test
	public void deveriaUsarLambdaExpression() throws Exception {
		Runnable runnable = () -> System.out.println("Rodando com Runnable");

		Thread thread = new Thread(runnable);
		thread.start();
	}

	@Test
	public void deveriaUsarClasseAnonimaEFunction() throws Exception {
		Function<String, Integer> converter = new Function<String, Integer>() {

			@Override
			public Integer apply(String numeroComoString) {
				return Integer.valueOf(numeroComoString);
			}
		};

		Integer resultado = converter.apply("10");

		assertEquals(10, resultado, 0);
	}

	@Test
	public void deveriaUsarLambdaEFunction() throws Exception {
		Function<String, Integer> converter = numeroComoString -> Integer.valueOf(numeroComoString);

		Integer resultado = converter.apply("10");

		assertEquals(10, resultado, 0);
	}

}

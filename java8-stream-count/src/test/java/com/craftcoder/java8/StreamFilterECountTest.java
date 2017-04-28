package com.craftcoder.java8;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

public class StreamFilterECountTest {

	@Test
	public void deveriaFiltrarOsElementosPares() throws Exception {
		List<Integer> numeros = Arrays.asList(1, 4, 6, 8, 9, 10);

		numeros
			.stream()
			.filter(new Predicate<Integer>() {

				@Override
				public boolean test(Integer numero) {
					return numero % 2 == 0;
				}
			});
	}

	@Test
	public void deveriaFiltrarOsElementosParesUsandoLambda() throws Exception {
		List<Integer> numeros = Arrays.asList(1, 4, 6, 8, 9, 10);

		long quantidade = numeros
			.stream()
			.filter(numero -> numero % 2 == 0)
			.count();

		assertEquals(4, quantidade);
	}

}

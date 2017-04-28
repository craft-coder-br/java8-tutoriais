package com.craftcoder.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

public class StreamFilterTest {

	@Test
	public void deveriaFiltrarMaioresQue5EPares() throws Exception {
		List<Integer> numeros = Arrays.asList(1, 4, 6, 8, 9, 10);

		List<Integer> listaFinal = new ArrayList<>();
		for (Integer numero: numeros) {
			if (numero > 5 && numero % 2 == 0) {
				listaFinal.add(numero);
			}
		}

		System.out.println(listaFinal);
	}

	@Test
	public void deveriaFiltrarMaioresQue5EParesUsandoStream() throws Exception {
		List<Integer> numeros = Arrays.asList(1, 4, 6, 8, 9, 10);

		numeros
			.stream()
			.filter(new Predicate<Integer>() {

				@Override
				public boolean test(Integer numero) {
					return numero > 5 && numero % 2 == 0;
				}
			});
	}

	@Test
	public void deveriaFiltrarMaioresQue5UsandoStream() throws Exception {
		List<Integer> numeros = Arrays.asList(1, 4, 6, 8, 9, 10);

		numeros
			.stream()
			.filter(new Predicate<Integer>() {

				@Override
				public boolean test(Integer numero) {
					return numero > 5;
				}
			});
	}

	@Test
	public void deveriaFiltrarMaioresQue5EParesComPredicateDiferentes() throws Exception {
		List<Integer> numeros = Arrays.asList(1, 4, 6, 8, 9, 10);

		numeros
			.stream()
			.filter(numero -> numero > 5)
			.filter(numero -> numero % 2 == 0);
	}

	@Test
	public void deveriaFiltrarMaioresQue5EParesRetornandoUmaLista() throws Exception {
		List<Integer> numeros = Arrays.asList(1, 4, 6, 8, 9, 10);

		List<Integer> listaFiltrada = numeros
			.stream()
			.filter(numero -> numero > 5)
			.filter(numero -> numero % 2 == 0)
			.collect(Collectors.toList());

		System.out.println(listaFiltrada);
	}

}

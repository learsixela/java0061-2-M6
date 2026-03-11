package com.biblioteca.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void testSumar() {
		Calculadora calculadora = new Calculadora();
		int resultado = calculadora.sumar(2, 3);
		assertEquals(5, resultado);
	}

}

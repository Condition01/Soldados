package view;

import java.util.Random;

import controller.Fila;

public class Main {
	public static void main(String[] args) {
		Fila fila = new Fila(5);
		fila.enfileirar(1);
		fila.enfileirar(2);
		fila.enfileirar(3);
		fila.enfileirar(4);
		fila.enfileirar(5);
		fila.soldados();

	}
}

package controller;

import java.lang.reflect.Array;
import java.util.Random;

public class Fila {
	private int[] fila;
	private int primeiro;
	private int ultimo;
	private int size;
	
	
	public Fila(int size) {
		this.fila = new int[size];
		this.primeiro = -1;
		this.ultimo = -1;
		this.size = 0;
	}
	
	public boolean isFull() {
		int size = this.fila.length -1;
		if(this.primeiro > this.ultimo) {
			return this.ultimo+1 == this.primeiro;
		}else {
			if(this.ultimo != this.primeiro) {
				return this.ultimo%size == this.primeiro;
			}
		return false;
			
		}	
	}
	
	public boolean isEmpty() {
		return this.ultimo == -1;
	}
	
	public void enfileirar(int element) {
		if(isEmpty()) {
			this.fila[++this.ultimo] = element;
			this.primeiro = this.ultimo;
		}else if(isFull()){
			System.err.println("Fila cheia!");
		}else {
			int size =this.fila.length - 1;
			if(this.ultimo == size) {
				this.ultimo = this.ultimo%size;
				this.fila[ultimo] = element;
			}else {
				this.fila[++this.ultimo] = element;
			}
		}
	}
	
	public int desinfileirar() {
		if(isEmpty()) {
			System.out.println("Fila vazia! ");
			return 0;
		}else if(this.size == 1) {
			int temp = this.fila[this.primeiro];
			this.primeiro = - 1;
			this.ultimo = this.primeiro;
			return temp;
		}else {
			int size = this.fila.length-1;
			if(this.primeiro == size) {
				int temp = this.fila[this.primeiro];
				this.primeiro = this.primeiro%size;
				return temp;
			}else {
				int temp = this.fila[this.primeiro];
				this.primeiro++;
				return temp;
			}
		}
	}
	
	public int showFront()throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException();
		}else {
			return this.primeiro;
		}
	}
	
	public void soldados() {
		int tamanho = 5;
		int ponteiro = this.primeiro;
		int size = this.fila.length-1;
		while(tamanho > 1) {
			Random num = new Random();
			int sorteio = (num.nextInt(6)+1);
			int sinal = (num.nextInt(2));
			if(sinal == 1) {
				sorteio = sorteio * (-1);
			}
			while(sorteio != 0) {
				if(sorteio <= 0) {
					if(ponteiro == size) {
						ponteiro = 0;
						sorteio++;
					}else {
						sorteio++;
						ponteiro++;
					}
				}else {
					if(ponteiro == 0) {
						ponteiro = size;
						sorteio--;
					}else {
						sorteio--;
						ponteiro--;
					}
				}
			}
			if(this.fila[ponteiro] != 0) {
				this.fila[ponteiro] = 0;
				tamanho --;
			}
			
		}
		for(int element : this.fila) {
			if(element != 0) {
				System.out.println(element + " venceu!");
			}
			
		}
	}
}

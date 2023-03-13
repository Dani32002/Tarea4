package Pregunta2;

import java.io.IOException;
import java.util.ArrayList;

import modulo.Carga;

public class Pregunta2 {
	public static void main(String[] args) throws NumberFormatException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Carga carga = new Carga();
		//String algoritmo = Carga.class.getPackage().getName() + "." + args[0];
		//@SuppressWarnings("deprecation")
		//AlgoritmoGrafoComponentes calculadora = (AlgoritmoGrafoComponentes) Class.forName(algoritmo).newInstance();
		ArrayList<ArrayList<Integer>> matriz = carga.cargarMatriz(args[0]);
		BFS bfs = new BFS();
		long inicioTiempo = System.currentTimeMillis();
		ArrayList<ArrayList<Integer>> respuesta = bfs.algoritmo(matriz);
		long finalTiempo = System.currentTimeMillis();
		
		System.out.print("{");
		for (ArrayList<Integer> fila: respuesta) {
			System.out.print("{");
			for (int i = 0; i < fila.size(); i++) {
				if (i == fila.size() - 1) {
					System.out.print(fila.get(i));
				} else {
					System.out.print(fila.get(i) + ",");
				}
			}
			System.out.print("}");
		}
		System.out.print("{");
		System.out.println("Tiempo Total (milisegundos): "+(finalTiempo-inicioTiempo));
	}
}

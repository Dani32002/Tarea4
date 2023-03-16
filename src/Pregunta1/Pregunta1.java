package Pregunta1;

import java.io.IOException;
import java.util.ArrayList;

import modulo.Carga;

public class Pregunta1 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NumberFormatException, IOException {
		Carga carga = new Carga();
		String algoritmo = Pregunta1.class.getPackage().getName() + "." + args[0];
		@SuppressWarnings("deprecation")
		AlgoritmoGrafoCostoMin calculadora = (AlgoritmoGrafoCostoMin) Class.forName(algoritmo).newInstance();
		ArrayList<ArrayList<Integer>> matriz = carga.cargarMatriz(args[1]);
		
		long inicioTiempo = System.currentTimeMillis();
		ArrayList<ArrayList<Integer>> respuesta = calculadora.algoritmo(matriz);
		long finalTiempo = System.currentTimeMillis();
		
		System.out.println("MATRIZ DE COSTOS MINIMOS: ");
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
			if (respuesta.indexOf(fila) != respuesta.size()- 1) {
				System.out.print("}\n");
			} else {
				System.out.print("}");
			}
		}
		System.out.print("}\n");
		System.out.println("Tiempo Total (milisegundos): "+(finalTiempo-inicioTiempo));
	}
}

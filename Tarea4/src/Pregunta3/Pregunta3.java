package Pregunta3;

import java.io.IOException;
import java.util.ArrayList;
import modulo.Carga;

public class Pregunta3 {
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		Carga carga = new Carga();
		ArrayList<ArrayList<Integer>> matriz = carga.cargarMatriz(args[0]);
		DFS dfs = new DFS();
		long inicioTiempo = System.currentTimeMillis();
		Boolean respuesta = dfs.algoritmo(matriz);
		long finalTiempo = System.currentTimeMillis();
		
		System.out.println(respuesta);
		
		System.out.println("Tiempo Total (milisegundos): "+(finalTiempo-inicioTiempo));
	}
}

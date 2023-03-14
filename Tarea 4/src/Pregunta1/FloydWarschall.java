package Pregunta1;

import java.util.ArrayList;

public class FloydWarschall implements AlgoritmoGrafoCostoMin {

	@Override
	public ArrayList<ArrayList<Integer>> algoritmo(ArrayList<ArrayList<Integer>> matriz) {
		int[][] res = floydWarschall(matriz);
		ArrayList<ArrayList<Integer>> retorno = new ArrayList<>();
		for (int i = 0; i < res.length; i++) {
			ArrayList<Integer> fila = new ArrayList<>();
			for (int j = 0; j < res.length; j++) {
				fila.add(res[i][j]);
			}
			retorno.add(fila);
		}
		
		return retorno;
	}
	
	public int[][] floydWarschall(ArrayList<ArrayList<Integer>> matriz) {
		int[][] resultado = new int[matriz.size()][matriz.size()];
		int k = 0;
		while (k < matriz.size() + 1) {
			int i = 0;
			while (i < matriz.size()) {
				int j = 0;
				while (j < matriz.size()) {
					if (k == 0) {
						resultado[i][j] = matriz.get(i).get(j);
					} else if (i != k-1 && j != k-1) {
						if (resultado[i][k-1] != 2147483647 && resultado[k-1][j] != 2147483647){
							if (resultado[i][j] <= resultado[i][k-1] + resultado[k-1][j]) {
								resultado[i][j] = resultado[i][j];
							} else {
								resultado[i][j] = resultado[i][k-1] + resultado[k-1][j];
							}
						} else {
							if (resultado[i][j] <= (int)Double.POSITIVE_INFINITY) {
								resultado[i][j] = resultado[i][j];
							} else {
								resultado[i][j] = (int)Double.POSITIVE_INFINITY;
							}
						}
					}
					j++;
				}
				i++;
			}
			k++;
		}
		return resultado;
		
	}
	
}

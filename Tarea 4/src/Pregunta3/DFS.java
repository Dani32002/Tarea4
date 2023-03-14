package Pregunta3;

import java.util.ArrayList;

public class DFS implements AlgoritmoGrafoCiclos {
	
	int tiempo = 0; 

	@Override
	public Boolean algoritmo(ArrayList<ArrayList<Integer>> matriz) {
		int[] inicios = new int[matriz.size()];
		int[] finales = new int[matriz.size()];
		int[] estado = new int[matriz.size()];
		DFSAlgo(inicios, finales, estado,  matriz);
		for (int z = 0; z < matriz.size(); z++) {
			for (int y = 0; y < matriz.get(z).size(); y++) {
				if (matriz.get(z).get(y) != 2147483647 && inicios[z] > inicios[y] && finales[z] < finales[y]) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void DFSAlgo(int[] inicios, int[] finales, int[] estado, ArrayList<ArrayList<Integer>> matriz) {
		tiempo = 0;
		for (int i = 0; i < matriz.size(); i++) {
			inicios[i] = (int)Double.NEGATIVE_INFINITY;
			finales[i] = (int)Double.NEGATIVE_INFINITY;
			estado[i] = 0;
		}
		for (int j = 0; j < matriz.size(); j++) {
			if (estado[j] == 0) {
				visitaDFS(inicios, finales, estado, j, matriz);
			}
		}
		
	}
	public void visitaDFS(int[] inicios, int[] finales, int[] estado, int vertice, ArrayList<ArrayList<Integer>> matriz) {
		tiempo++;
		estado[vertice] = 1;
		inicios[vertice] = tiempo;
		for (int h = 0; h < matriz.get(vertice).size(); h++) {
			if (matriz.get(vertice).get(h) != 2147483647 && estado[h] == 0) {
				visitaDFS(inicios, finales, estado, h, matriz);
			}
		}
		tiempo++;
		estado[vertice] = 2;
		finales[vertice] = tiempo;
	}
	
}

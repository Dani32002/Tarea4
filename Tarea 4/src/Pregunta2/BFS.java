package Pregunta2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS implements AlgoritmoGrafoComponentes {

	@Override
	public ArrayList<ArrayList<Integer>> algoritmo(ArrayList<ArrayList<Integer>> matriz) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> componentes = new ArrayList<>();
		ArrayList<Integer> faltantes = new ArrayList<>();
		for (int j = 0; j < matriz.size(); j++) faltantes.add(j);
		for (int i = 0; i < matriz.size(); i++) {
			if (faltantes.contains(i)) {
				ArrayList<Integer> resp = BFSAlgoritmo(matriz, i);
				componentes.add(resp);
				for (int k = 0; k < resp.size(); k++) faltantes.remove(faltantes.indexOf(resp.get(k)));
			}
		}
		return componentes;
	}
	
	public ArrayList<Integer> BFSAlgoritmo(ArrayList<ArrayList<Integer>> matriz, int inicio) {
		Queue<Integer> fila = new LinkedList<>();
		ArrayList<Integer> componente = new ArrayList<>();
		ArrayList<Integer> visitados = new ArrayList<>();
		visitados.add(inicio);
		fila.add(inicio);
		while (fila.size() > 0) {
			int vertice = fila.remove();
			componente.add(vertice);
			for (int i = 0; i < matriz.get(vertice).size(); i++) {
				int valor = matriz.get(vertice).get(i);
				if (matriz.get(vertice).get(i) != 2147483647 && matriz.get(vertice).get(i) != 0 && !visitados.contains(i)) {
					visitados.add(i);
					fila.add(i);
				}
			}
		}
		return componente;
	}
}

package Pregunta1;

import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra implements AlgoritmoGrafoCostoMin{

	@Override
	public ArrayList<ArrayList<Integer>> algoritmo(ArrayList<ArrayList<Integer>> matriz) {
		ArrayList<ArrayList<Integer>> D = new ArrayList<ArrayList<Integer>>();
		for (int k = 0; k<matriz.size(); k++) {
			ArrayList<Integer> C = DijkstraImplementacion(matriz, k);
			D.add(C);
		}
		return D;
	}
	
	
	public ArrayList<Integer> DijkstraImplementacion(ArrayList<ArrayList<Integer>> matriz, int inicio) {
		ArrayList<Integer> R = new ArrayList<Integer>();
		ArrayList<Integer> C = new ArrayList<Integer>();
		ArrayList<Integer> P = new ArrayList<Integer>();
		
		R.add(inicio);
		for (int i = 0; i<matriz.get(inicio).size(); i++) {
			C.add(i, matriz.get(inicio).get(i));
			P.add(i);
			
		}
		while (!R.equals(P)){
			int w = inicio;
			for (int j = 0; j<matriz.get(inicio).size(); j++) {
				if (!R.contains(j) && (w == inicio || C.get(j)<C.get(w))){
					w = j;
				}
			}
			R.add(w);
			Collections.sort(R);
			for(int s = 0; s<matriz.get(inicio).size(); s++) {
				if(!R.contains(s)) {
					if (matriz.get(w).get(s) == 2147483647) {
						C.set(s, C.get(s));
					}
					else {
						C.set(s, Math.min(C.get(s),C.get(w)+ matriz.get(w).get(s)));
					}
					
				}
			}
		}
		return C;
	}

	
}
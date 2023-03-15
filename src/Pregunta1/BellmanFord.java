package Pregunta1;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;
import java.util.List;

public class BellmanFord implements AlgoritmoGrafoCostoMin {

	@Override
	public ArrayList<ArrayList<Integer>> algoritmo(ArrayList<ArrayList<Integer>> matriz) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> lista_final = new ArrayList<>();
		for (int i=0; i < matriz.size(); i++) {
			int [] fila = bellmanFord(matriz, i);
			lista_final.add(cambioArray(fila));
		}
	    return lista_final;
	}
	
	public int[] bellmanFord(ArrayList<ArrayList<Integer>> matriz, int origen){
		int tamanio = matriz.size();
	    int[] distancias = new int[tamanio];
	    Arrays.fill(distancias, (int)Double.POSITIVE_INFINITY);
	    distancias[origen] = 0;
	    for (int i = 1; i < tamanio; i++) {
	        for (int u = 0; u < tamanio; u++) {
	            if (distancias[u] != (int)Double.POSITIVE_INFINITY) {
	                List<Integer> vertices = matriz.get(u);
	         
	                for (int v = 0; v < tamanio; v++) {
	                    int peso = vertices.get(v);
	                    if(distancias[u] != (int)Double.POSITIVE_INFINITY) {
	                    	if (peso != (int)Double.POSITIVE_INFINITY && distancias[u] + peso < distancias[v]) {
		                    	distancias[v] = Math.min(distancias[u] + peso, distancias[v]);
		                    }
	                    }else{
	                    	if (peso != (int)Double.POSITIVE_INFINITY && (int)Double.POSITIVE_INFINITY < distancias[v]) {
		                    	distancias[v] = distancias[v];
		                    }
	                    }
	                }
	            }
	        }
	    }
	    return distancias;
	}
	
	public static ArrayList<Integer> cambioArray(int[] arreglo) {
	    ArrayList<Integer> lista = new ArrayList<>();
	    for (int i = 0; i < arreglo.length; i++) {
	        lista.add(arreglo[i]);
	    }
	    return lista;
	}
}
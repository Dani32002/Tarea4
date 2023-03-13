package Pregunta1;

import java.io.IOException;

import modulo.Carga;

public class Pregunta1 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NumberFormatException, IOException {
		Carga carga = new Carga();
		String algoritmo = Carga.class.getPackage().getName() + "." + args[0];
		@SuppressWarnings("deprecation")
		AlgoritmoGrafoCostoMin calculadora = (AlgoritmoGrafoCostoMin) Class.forName(algoritmo).newInstance();
		carga.cargarMatriz(args[1]);
		
		long inicioTiempo = System.currentTimeMillis();
		
		long finalTiempo = System.currentTimeMillis();
		System.out.println("Tiempo Total (milisegundos): "+(finalTiempo-inicioTiempo));
	}
}

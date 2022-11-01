import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Figurita {
	//private Random random;
	private int numero;
	private int valorBase;
	private String nombrePais;
	private Fabrica f = new Fabrica() ;
	private String premio;
	
	
	public Figurita(int numero, int valorBase, String nombrePais) {
		super();
		this.numero = numero;
		this.valorBase = valorBase;
		this.nombrePais = nombrePais;
	}
	
	
	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public int getValorBase() {
		return valorBase;
	}


	public void setValorBase(int valorBase) {
		this.valorBase = valorBase;
	}


	public String getNombrePais() {
		return nombrePais;
	}


	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}


	double calcularValorFigurita(int numero) {
		//Fabrica fabrica = new Fabrica();
		return f.calcularValorBase(nombrePais, numero);
	}
	
	public void crearFiguritasTradicional () {
		for(int i=0;i<4;i++) {	
			String[] paises = f.generarPaisesClasificados();
			int indiceAleatorio = aleatorio(0,paises.length-1);
			String pais = paises[indiceAleatorio];
			System.out.println("Pais: " + pais + "_Su valor es: " + 
			calcularValorFigurita(this.numero /* o numero ?*/)
			+ "numero de figurita es: " + (this.numero));
		}
		
	}
	static int aleatorio(int minimo, int maximo) {
		return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	} //metodo Random
}

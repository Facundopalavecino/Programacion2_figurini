
import java.util.concurrent.ThreadLocalRandom;

public class FiguritaTop10 extends Figurita {
	private Fabrica f = new Fabrica();
	private String premioTop10;
	//private String sede;
	//private String año;
	
	public FiguritaTop10(int numero, int valorBase, String nombrePais,int numeroJug) {
		super(numero, valorBase, nombrePais, numeroJug);
		// TODO Auto-generated constructor stub
	}
	
	double valorFigTop10 (int numero) {
		return f.generarValorBase(getNombrePais(), getNumeroID());
	
	}
	static int aleatorio(int minimo, int maximo) {
		return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}
	
}


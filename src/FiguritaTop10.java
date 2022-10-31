import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class FiguritaTop10 extends Figurita {
	private Fabrica f = new Fabrica();
	private String premioTop10;
	//private String sede;
	//private String año;
	
	public FiguritaTop10(int numero, int valorBase, String nombrePais) {
		super(numero, valorBase, nombrePais);
		// TODO Auto-generated constructor stub
	}
	
	double valorFigTop10 (int numero) {
		return f.calcularValorBase(getNombrePais(), getNumero());
	}
	public void crearFiguritasTop10() {
		for(int i=0;i<4;i++) {
			Map<String, String[]> paises = f.generarPaisesPorMundial(); //ya genera sede y año
			int indiceAleatorio = aleatorio(0,paises.size() - 1);
			String[] pais = paises.get(indiceAleatorio);
			System.out.println("Pais: "+ pais + "Su valor es:"+
			valorFigTop10(getNumero()));
		}
	}
	static int aleatorio(int minimo, int maximo) {
		return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}
	
}

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Album {
	protected int codigoID;
	private String premio;
	private int sorteoInstantaneo;
	private boolean estaCompleto;
	protected HashMap<Integer,Figurita> pegadas;
	
	
	public Album() {
		super();
		pegadas = new HashMap<Integer,Figurita>();
	}
	
	public HashMap<Integer, Figurita> getPegadas() {
		return pegadas;
	}


	public void setPegadas(HashMap<Integer, Figurita> pegadas) {
		this.pegadas = pegadas;
	}


	
}

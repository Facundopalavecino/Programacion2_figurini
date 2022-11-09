import java.util.ArrayList;
import java.util.HashMap;

public abstract class Album {
	protected int codigoID;
	protected String premio;
	protected int sorteoInstantaneo;
	protected boolean estaCompleto;
	protected HashMap<Integer,Figurita> pegadas;
	
	
	
	
	public Album(int codigoID, int sorteoInstantaneo) {
		super();
		this.codigoID = codigoID;
		this.sorteoInstantaneo = sorteoInstantaneo;
		this.estaCompleto=false;
		pegadas = new HashMap<Integer,Figurita>();
	}


	protected abstract HashMap<Integer, Figurita> getPegadas();


	


	
}

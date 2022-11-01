import java.util.ArrayList;
import java.util.HashMap;

public abstract class Album {
	private int codigoID;
	private String premio;
	private int sorteoInstantaneo;
	private boolean estaCompleto;
	HashMap<Integer,Figurita> pegadas;
	
	
	public Album() {
		super();
		pegadas = new HashMap<Integer,Figurita>();
	}
	
	

	
}

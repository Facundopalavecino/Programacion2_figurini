import java.util.ArrayList;
import java.util.HashMap;

public abstract class Album {
	//private Figurita figuritas;
	private String codigoID;
	private String premio;
	private boolean estaCompleto;
	//private HashMap <String, int v> a;
	private String tipoAlbum;
	private ArrayList <Figurita> figuritas;
	
	public Album(String tipoAlbum, String codigoID) {
		super();
		this.tipoAlbum = tipoAlbum;
		this.codigoID = codigoID;
		//ArrayList<Figurita> figuritas;
		
	}
//	public Album(ArrayList<Figurita> figuritas) {
//		figuritas = new ArrayList();
//	}
//	public void crearAlbum(Fabrica f) {
//		f.crearAlbumTradicional(this.tipoAlbum, this.codigoID);
//	}
	
}

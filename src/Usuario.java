import java.util.HashMap;
import java.util.LinkedList;

public class Usuario {
	private String nombreUsuario;
	private int dni;
	private Album tipoAlbum;
	private HashMap <Integer,String> figuritasRepetidas = new HashMap<>();
	// private ArrayList<Figuritas> figuritas;
	private Figurita[] figuritas;
	//private Conjunto<Figurita> figRepetidas; 
	
	public Usuario(int dni,String nombreUsuario,  
		Album tipoAlbum) {
		super();
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		this.tipoAlbum = tipoAlbum;
	}
	
	void guardarFiguritasRepetidas(Figurita[] figuritas) {
		LinkedList figuritasRepetidas = new LinkedList();
		for (int i=0;i<figuritas.length;i++)
			figuritasRepetidas.add(figuritas);
	}
	boolean intercambiar(int numero) {
		return false;
	}
	
	void crearAlbum(String tipoAlbum) {
	//	Album albumUsuario = new Album();
	}
	public String devolverTipoAlbum(){
		return (" " + this.tipoAlbum);
	}
	
	boolean completoAlbum() {
		return false;
	}
	boolean tieneAlbum(Album a) {
		return true;
	}
	
	
	
	
}

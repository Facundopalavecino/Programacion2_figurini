import java.util.LinkedList;

public class Usuario {
	private String nombreUsuario;
	private int dni;
	private Album tipoAlbum;
	private Figurita [] figuritasRepetidas;
	// private ArrayList<Figuritas> figuritas;
	private Figurita figuritas;
	//private Conjunto<Figurita> figRepetidas; 
	
	public Usuario(int dni,String nombreUsuario,  
		Album tipoAlbum) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.dni = dni;
		this.tipoAlbum = tipoAlbum;
	}
	void pegarFigurita(int numero) {
		
	}
	void guardarFiguritasRepetidas(Figurita figuritas) {
		LinkedList figuritasRepetidas = new LinkedList();
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

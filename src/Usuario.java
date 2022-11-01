import java.util.HashMap;
import java.util.LinkedList;

public class Usuario {
	private String nombreUsuario;
	private int dni;
	private Album album;
	private HashMap <Integer,Figurita> figuritasRepetidas;
	
	
	public Usuario(int dni,String nombreUsuario,String tipoAlbum) {
		super();
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		figuritasRepetidas = new HashMap<Integer,Figurita>();
		//crearAlbum(tipoAlbum);
		
	}
	
	private void crearAlbum(String tipoAlbum2) {
		// TODO Auto-generated method stub
		if(tipoAlbum2 == "Tradicional") {
			Album n = new AlbumTradicional(dni);
		}
		else if (tipoAlbum2 == "Web") {
			Album n = new AlbumWeb(20+dni);
		} 
		else if (tipoAlbum2 == "Extendido") {
			Album n = new AlbumExtendido(dni);
		}else {
			 throw new RuntimeException("este tipo de album no existe"); 
		}
		
	}

	void guardarFiguritasRepetidas(Figurita[] figuritas) {
		LinkedList figuritasRepetidas = new LinkedList();
		for (int i=0;i<figuritas.length;i++)
			figuritasRepetidas.add(figuritas);
	}
	
	boolean intercambiar(int numero) {
		return false;
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

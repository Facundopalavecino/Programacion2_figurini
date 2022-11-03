import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Usuario {
	private String nombreUsuario;
	private int dni;
	private Album album;
	private HashMap <Integer,Figurita> figuritasRepetidas;
	private ArrayList<Figurita>figDeJug;
	
	
	public Usuario(int dni,String nombreUsuario,String tipoAlbum) {
		super();
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		figuritasRepetidas = new HashMap<Integer,Figurita>();
		crearAlbum(tipoAlbum);
		
	}
	
	private void crearAlbum(String tipoAlbum2) {
		// TODO Auto-generated method stub
		if(tipoAlbum2 == "Tradicional") {
			album  = new AlbumTradicional(dni+20);
		}
		else if (tipoAlbum2 == "Web") {
			album  = new AlbumWeb(20+dni);
		} 
		else if (tipoAlbum2 == "Extendido") {
			album  = new AlbumExtendido(dni+20);
		}else {
			 throw new RuntimeException("este tipo de album no existe"); 
		}
		
	}

	private void guardarFiguritasRepetidas(Figurita fig) {
		figuritasRepetidas.put(fig.getNumeroID(), fig);
	}
	
	/*pregunta si la figura ya esta pegada en el album sino esta la pega, si ya esta la guarda en figuritas
	repetidas*/
	public boolean agregarFig(Figurita f){   
		if(!album.getPegadas().containsKey(f.getNumeroID())) {
			album.getPegadas().put(f.getNumeroID(),f);
		}
		else {
			guardarFiguritasRepetidas(f);
		}
		
		return false;
		
	}
	
	boolean intercambiar(int numero) {
		return false;
	}
	
	
	boolean completoAlbum() {
		return false;
	}
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
}

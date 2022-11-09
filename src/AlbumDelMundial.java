import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


public class AlbumDelMundial implements IAlbumDelMundial {
	
	private HashMap<Integer,Usuario>usuario;
	private Fabrica f;
	

	public AlbumDelMundial() { //constructor// 
		super();
		usuario = new HashMap<Integer,Usuario>();
	}
	
	
	@Override
	public int registrarParticipante(int dni, String nombre, String tipoAlbum) {
		// TODO Auto-generated method stub
		try {
		if(!EstaRegistrado(dni) && tipoAlbum(tipoAlbum)) {
			usuario.put(dni,new Usuario(dni,nombre,tipoAlbum));
			return dni;
		
			}
		}
		catch(RuntimeException ex){
			System.out.println("el usuario ya fue ingresado");
		}
		return dni;
		
	}


	@Override
	public void comprarFiguritas(int dni) {
		// TODO Auto-generated method stub
		try {
			if(usuario.containsKey(dni)) {// pregunta si el usuario existe 
				List<Figurita> sobre =f.generarSobre();// si existe genera un sobre
				for(Figurita fig : sobre) { // recorre las figuritas que crea el sobre
					usuario.get(dni).agregarFig(fig);// 
					}
				}
			}catch(RuntimeException ex){
				throw new RuntimeException("el usuario no existe");
			}
		
		
	}
	



	@Override
	public void comprarFiguritasTop10(int dni) {
		if(usuario.containsKey(dni)) {
		}
	}

	@Override
	public void comprarFiguritasConCodigoPromocional(int dni) {
		// TODO Auto-generated method stub
		if(usuario.containsKey(dni)) {   /// pregunta si contiene la clave dni
			if(usuario.get(dni).getAlbum() instanceof AlbumWeb){	// pregunta si es de tipo album web
				AlbumWeb album = (AlbumWeb)usuario.get(dni).getAlbum(); // castea
				if(!album.isCodUsado()) { // if el codigo no fue utilizado agrega las figuritas 
					for(Figurita fig : f.generarSobre()){ // genera el sobre y lo recorre
						usuario.get(dni).agregarFig(fig); // agrega fig
						}
					album.setCodUsado(true);
					}
				throw new RuntimeException("el codigo promocional ya fue utilizado");
				}
			throw new RuntimeException("el album de este usuario no es de tipo AlbumWeb");
			}
		throw new RuntimeException("no esta registrado");
		}

	@Override
	public List<String> pegarFiguritas(int dni) {
		if(usuario.containsKey(dni)) {
		   for(Figurita i :usuario.get(dni).getFiguritasDelJug()) {
			   if(!usuario.get(dni).getAlbum().getPegadas().containsKey(i.getNumeroID())) {
				   usuario.get(dni).getAlbum().pegadas.put(i.getNumeroID(),new Figurita(i.getNumeroID(), i.getValorBase(), i.getNombrePais(), i.getNumeroJugador()));
			   }else {
				   usuario.get(dni).guardarFiguritasRepetidas(i);
			   }
		   }
		}
		throw new RuntimeException("no esta registrado");
	}

	@Override
	public boolean llenoAlbum(int dni) {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String aplicarSorteoInstantaneo(int dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int buscarFiguritaRepetida(int dni) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean intercambiar(int dni, int codFigurita) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intercambiarUnaFiguritaRepetida(int dni) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String darNombre(int dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String darPremio(int dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listadoDeGanadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> participantesQueCompletaronElPais(String nombrePais) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private boolean tipoAlbum(String tipoAlbum) {
		// TODO Auto-generated method stub
		if(tipoAlbum=="Web") {
			return true;
		}
		else if(tipoAlbum=="Tradicional") {
			return true;
		}
		else if(tipoAlbum=="Extendido") {
			return true;
		}
		return false;
	}
 
	private boolean EstaRegistrado(int dni) {
		// TODO Auto-generated method stub
		return usuario.containsKey(dni);	
	}
}

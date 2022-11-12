import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


public class AlbumDelMundial implements IAlbumDelMundial {
	
	private HashMap<Integer,Usuario>usuario;
	private Fabrica f = new  Fabrica();
	

	public AlbumDelMundial() { //constructor// 
		super();
		usuario = new HashMap<Integer,Usuario>();
	}
	
	
	@Override
	public int registrarParticipante(int dni, String nombre, String tipoAlbum) {
		if(!EstaRegistrado(dni) && tipoAlbum(tipoAlbum)) {
			usuario.put(dni,new Usuario(dni,nombre,tipoAlbum));
			return dni;
			}
		new RuntimeException("el usuario ya esta Registrado");
		return -1;
	}


	@Override
	public void comprarFiguritas(int dni) {
		// TODO Auto-generated method stub
		try {	
		if(EstaRegistrado(dni)) {
				List<Figurita> sobre = f.generarSobre();
				for(Figurita fig : sobre) {
				usuario.get(dni).agregarFig(fig);
				}
			}
		}catch(RuntimeException ex){
			
			new RuntimeException("el participante no esta Registrado"); 
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
		
		if(EstaRegistrado(dni)) {   /// pregunta si contiene la clave dni
			if(usuario.get(dni).getAlbum() instanceof AlbumWeb){	// pregunta si es de tipo album web
				AlbumWeb album = (AlbumWeb)usuario.get(dni).getAlbum(); // castea
				if(!album.isCodUsado()) { // if el codigo no fue utilizado agrega las figuritas
					List<Figurita> sobre = f.generarSobre();
					for(Figurita fig : sobre){ // genera el sobre y lo recorre
						usuario.get(dni).agregarFig(fig); // agrega fig
						}
					album.setCodUsado(true);
					}
				new RuntimeException("el codigo promocional ya fue utilizado");
				}
			new RuntimeException("el album de este usuario no es de tipo AlbumWeb");
			}
		new RuntimeException("no esta registrado");
		}

	@Override
	public List<String> pegarFiguritas(int dni) {
		List<String> listaFig = new ArrayList<String>();
		if(usuario.containsKey(dni)) {
		   for(Figurita i :usuario.get(dni).getFiguritasDelJug()) {
			   if(!usuario.get(dni).getAlbum().getPegadas().containsKey(i.getNumeroID())) {
				   usuario.get(dni).getAlbum().pegadas.put(i.getNumeroID(),new Figurita(i.getNumeroID(), i.getValorBase(), i.getNombrePais(), i.getNumeroJugador()));
				   listaFig.add(i.getNumeroID() + i.getNombrePais());
			   }
				   usuario.get(dni).guardarFiguritasRepetidas(i);
		   }return listaFig; 
		}
		new RuntimeException("no esta registrado");
		return null;
	}

	@Override
	public boolean llenoAlbum(int dni) {
		if(EstaRegistrado(dni)) {
			return usuario.get(dni).getAlbum().estaCompleto();
		}return false; // lanzar excepcion
	}




	@Override/// 
	public String aplicarSorteoInstantaneo(int dni) {
		// TODO Auto-generated method stub
		if (EstaRegistrado(dni)){
			if(usuario.get(dni).getAlbum() instanceof AlbumTradicional) {
				AlbumTradicional album = (AlbumTradicional)usuario.get(dni).getAlbum();
				if(album.isUsoCodigo()==true) {
					String premio = f.generarPremiosParaSorteoInstantaneo()[Fabrica.random(0, 2)];
					return premio;
				}
			}
		}
		new RuntimeException("No esta registrado");
		return " ";
		
		
	}
	
	@Override
	public int buscarFiguritaRepetida(int dni) {
		// TODO Auto-generated method stub
		if(EstaRegistrado(dni)) {
			if(usuario.get(dni).getRepetidas().isEmpty()){
				return -1;
			}
			for(int i :usuario.get(dni).getRepetidas().keySet()) {
				return i;
			}
		}
		return 0;
	}

	@Override
	public boolean intercambiar(int dni, int codFigurita) {
		// TODO Auto-generated method stub
		for(Figurita fig : usuario.get(dni).getFiguritasDelJug()){
			
		}
		return true;
	}

	@Override
	public boolean intercambiarUnaFiguritaRepetida(int dni) {
		// TODO Auto-generated method stub
		if(EstaRegistrado(dni)) { 
				if (tieneRepetidas(dni)){ // preguntamos si tiene repetidas
					for(Figurita fig : usuario.get(dni).getRepetidas().values()){ //recorremos las figuritas del usuario
						for(int dni2 : usuario.keySet()) { //vemos si hay otro usuario con mismo tipo de album
							if(compararAlbunes(dni,dni2)){ //comparo 
									for(Figurita figurita : usuario.get(dni).getRepetidas().values()) { //recorrimos las figuritas por valor, solo las repetidas
										if(figurita.getValorBase() == fig.getValorBase()) { // si tienen mismo valor base
											if(!usuario.get(dni).getAlbum().getPegadas().containsKey(figurita.getNumeroID())){ //si no la tiene pegada, intercambia
												usuario.get(dni).getAlbum().pegadas.put(figurita.getNumeroID(), figurita);
												usuario.get(dni2).getAlbum().pegadas.put(fig.getNumeroID(), fig);
												return true;
											}
										}
									}
							}
						}
					}	
				} 
		}
		new RuntimeException ("No esta registrado");
		return false;
	}

	private Figurita mismoValorBase(Figurita fig,int dni) {
		for(Figurita figurita : usuario.get(dni).getRepetidas().values()) {
			if(fig.getValorBase() == figurita.getValorBase()) {
				return figurita;
			}
		}
		return null;
	}


	private boolean compararAlbunes(int dni, int dni2) {
		// TODO Auto-generated method stub
		return usuario.get(dni).getAlbum().getClass().equals(usuario.get(dni2).getAlbum().getClass());
	}


	private boolean tieneRepetidas(int dni) {
		return !usuario.get(dni).getRepetidas().isEmpty();
	}

	@Override
	public String darNombre(int dni) {
		if(EstaRegistrado(dni)) {
			return usuario.get(dni).getNombre();
		}else {
			new RuntimeException("el dni no esta registrado");
			}
		return "";
	}

	@Override
	public String darPremio(int dni) {
		if(EstaRegistrado(dni)) {
			if(usuario.get(dni).getAlbum().estaCompleto()) {
				return usuario.get(dni).getAlbum().getPremio();
			}new RuntimeException("no tiene completo el album");
		} new RuntimeException("no esta registrado");
		
		return null;
		
	}

	@Override
	public String listadoDeGanadores() {
		String cadena = new String ();
		for(int i:usuario.keySet()) {
			if(llenoAlbum(i)) {
				cadena= "nombre" + cadena + usuario.get(i).getNombre()+ " " + "premio" + usuario.get(i).getAlbum().premio + " "; 
			}
		}return cadena;
	}

	@Override
	public List<String> participantesQueCompletaronElPais(String nombrePais) {
		ArrayList<String> lista = new ArrayList<String>();
		for (int u:usuario.keySet()) {
			if(usuario.get(u).getAlbum().DevolverCompletoPais(nombrePais)) {
			lista.add(usuario.get(u).getNombre());
			}
		}
		return lista;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Album Del Mundial";
	}
}

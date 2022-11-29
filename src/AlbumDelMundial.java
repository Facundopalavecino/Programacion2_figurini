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
		if(!usuario.containsKey(dni) && tipoAlbum(tipoAlbum)) {
			usuario.put(dni,new Usuario(dni,nombre,tipoAlbum));
			return dni;
			}else{
		 throw new RuntimeException("el usuario ya esta Registrado");
		}
	}

	@Override
	public void comprarFiguritas(int dni) {
		if(EstaRegistrado(dni)) {
				List<Figurita> sobre = f.generarSobre();
				for(Figurita fig : sobre) {
				usuario.get(dni).agregarFig(fig);
				}
			}else {
		throw new RuntimeException("el participante no esta Registrado"); 
			}
	}
	@Override
	public void comprarFiguritasTop10(int dni) {
		if(EstaRegistrado(dni)) {
			if(usuario.get(dni).getAlbum() instanceof AlbumExtendido) {
				AlbumExtendido album = (AlbumExtendido)usuario.get(dni).getAlbum();
				List<FiguritaTop10> sobre = f.generarSobreTop10();
				for(FiguritaTop10 figu : sobre) {
					if(!album.top10.containsKey(figu.getCodID())) {
						album.top10.put(figu.getCodID(),figu);
					}
				}
				
			} throw new RuntimeException("el tipo de album no es de tipo Extendido");
		} new RuntimeException("el usuario no esta registrado");
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
				}else {
			 throw new RuntimeException("el album de este usuario no es de tipo AlbumWeb");
			}
		}
		new RuntimeException("no esta registrado");
		}

	@Override
	public List<String> pegarFiguritas(int dni) {
		List<String> listaFig = new ArrayList<String>();
		if(EstaRegistrado(dni)) {
		   for(Figurita i :usuario.get(dni).getFiguritasDelJug()) {
			   if(!usuario.get(dni).getAlbum().getPegadas().containsKey(i.getNumeroID())) {
				   usuario.get(dni).getAlbum().pegadas.put(i.getNumeroID(),new Figurita(i.getNumeroID(), i.getValorBase(), i.getNombrePais(), i.getNumeroJugador()));
				   listaFig.add(i.getNumeroJugador()  +" "+ i.getNombrePais());
			   }else{
				   usuario.get(dni).guardarFiguritasRepetidas(i);
			   }
		   }
		   return listaFig; 
		}
		return null;
	}

	@Override
	public boolean llenoAlbum(int dni) {
		if(EstaRegistrado(dni)) {
			return usuario.get(dni).getAlbum().estaCompleto();
		}throw new RuntimeException();
	}


	@Override/// 
	public String aplicarSorteoInstantaneo(int dni) {
		// TODO Auto-generated method stub
		String mensaje ="el album ya fue usado";
			if (EstaRegistrado(dni)){
				if(tieneAlbumTradicional(dni)) {
					AlbumTradicional album = (AlbumTradicional)usuario.get(dni).getAlbum();
					if(album.isUsoCodigo()==false) {
						 String premio = f.generarPremiosParaSorteoInstantaneo()[1];
						return premio;	
						}
					else {
							return mensaje;
						}
					}
				else {
					throw new RuntimeException();
				}
			}else {
				throw new RuntimeException("no esta Registrado;");
		}
			
	}
	
	private boolean tieneAlbumTradicional(int dni) {
		if( usuario.get(dni).getAlbum() instanceof AlbumTradicional) {
			return true;
		}else{ 
			return false;
		}
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
		if(EstaRegistrado(dni) && usuario.get(dni).getRepetidas().containsKey(codFigurita)) {
				Figurita fig = usuario.get(dni).getRepetidas().get(codFigurita);
				for(int usuario2: usuario.keySet()) {
					if(tieneMismoTipoAlbum(dni,usuario2)) {
						if(!usuario.get(usuario2).getAlbum().pegadas.containsKey(codFigurita) && !usuario.get(usuario2).getRepetidas().containsKey(codFigurita)) {
							if(!usuario.get(usuario2).getRepetidas().isEmpty()) {
								for(int i : usuario.get(usuario2).getRepetidas().keySet()) {
									if(fig.getValorBase()<= usuario.get(usuario2).getRepetidas().get(i).getValorBase()) {
										Figurita repetida = usuario.get(usuario2).getRepetidas().get(i);
										usuario.get(dni).getAlbum().pegadas.put(i, repetida);
										usuario.get(usuario2).getAlbum().pegadas.put(codFigurita, fig);
									}
								}
							}
						}
							
					}
				}
			}
		return false;
	}
		

	private boolean tieneMismoTipoAlbum(int dni, int i) {
		return usuario.get(dni).getAlbum().getClass().equals(usuario.get(i).getAlbum().getClass());
	}

	
	//////el test no da true ya que pregunta si el usuario tiene repetidas y como el usuario 1 no tiene repetidas sale
	//////pero el programa funciona correctamente 
	//////
	@Override
	public boolean intercambiarUnaFiguritaRepetida(int dni) {
		// TODO Auto-generated method stub
		if(EstaRegistrado(dni)) { 
			if(!usuario.get(dni).getAlbum().pegadas.isEmpty()) {
				if(tieneRepetidas(dni)){///    si tuviera figuritas repetidas entraria en el if y daria true si encuentra otro usuario con el mismo album
					int codRepetida=traerUnaRepetida(dni);
					Figurita repetida= usuario.get(dni).getRepetidas().get(codRepetida);
					for(int usuario2 :usuario.keySet()) {
						if(tieneMismoTipoAlbum(dni,usuario2)) {
							if(!usuario.get(usuario2).getAlbum().pegadas.containsKey(codRepetida) && 
								!usuario.get(usuario2).getRepetidas().containsKey(codRepetida)) {
								for(int i : usuario.get(usuario2).getRepetidas().keySet()){// recorro repetidas usuario 2
									if(repetida.getValorBase()<= usuario.get(usuario2).getRepetidas().get(i).getValorBase()) {
										return true;
									}	
								}
							}
						}
					}
				}
			}return false;	
		}
	throw new RuntimeException("el usuario no esta Registrado");	
	}
	
	
	private int traerUnaRepetida(int dni) {
		int fig=0;
		for(int i : usuario.get(dni).getRepetidas().keySet()) {
			fig=i;
		}
		return fig;
	}


	private boolean tieneRepetidas(int dni) {
		return !usuario.get(dni).getRepetidas().isEmpty();
	}
	
	
	

	@Override
	public String darNombre(int dni) {
		if(EstaRegistrado(dni)) {
			return usuario.get(dni).getNombre();
		}
		throw new RuntimeException("el dni no esta registrado");
		
	}

	@Override
	public String darPremio(int dni) {
		if(EstaRegistrado(dni)) {
			if(usuario.get(dni).getAlbum().estaCompleto()) {
				return usuario.get(dni).getAlbum().getPremio();
			}new RuntimeException("no tiene completo el album");
		}throw new RuntimeException("no esta registrado");
		
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
		if(tipoAlbum.equals("Web")) {
			return true;
		}
		else if(tipoAlbum.equals("Tradicional")) {
			return true;
		}
		else if(tipoAlbum.equals("Extendido")) {
			return true;
		}
		new Exception("el tipo no es valido");
		return false;
	}
 
	private boolean EstaRegistrado(int dni) {
		if(usuario.containsKey(dni)) {
			return true;
		}else {
		throw new RuntimeException("no esta Registrado");
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Album Del Mundial";
	}
}

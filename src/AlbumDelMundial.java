import java.util.HashMap;
import java.util.List;


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
		if(!usuario.containsKey(dni)) {
			usuario.put(dni,new Usuario(dni,nombre,tipoAlbum));
			System.out.println("usuariofueingresado" + dni);
			return dni;
		}
		else{
			throw new RuntimeException("este usuario ya esta registrado");
		}		
		
	}

	@Override
	public void comprarFiguritas(int dni) {
		// TODO Auto-generated method stub
		if(usuario.containsKey(dni)) {  // pregunta si el usuario existe 
			for(Figurita f : f.generarSobre()) { // recorre las figuritas que crea el sobre
				usuario.get(dni).agregarFig(f);// 
			}
			
		}else {
			throw new RuntimeException("este usuario no esta registrado");
		}
		
	}
	
	
	@Override
	public void comprarFiguritasTop10(int dni) {
		// TODO Auto-generated method stub

	}

	@Override
	public void comprarFiguritasConCodigoPromocional(int dni) {
		// TODO Auto-generated method stub
		if(usuario.get(dni).getAlbum().getClass() != null) {}

	}

	@Override
	public List<String> pegarFiguritas(int dni) {
		// TODO Auto-generated method stub
		return null;
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

}

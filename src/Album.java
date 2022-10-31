import java.util.ArrayList;
import java.util.HashMap;

public abstract class Album {
	private String codigoID;
	private String premio;
	private int sorteoInstantaneo;
	private boolean estaCompleto;
	private String tipoAlbum;
	private ArrayList <Figurita> figuritas;
	private Usuario usuario;
	public Album(String codigoID, String tipoAlbum,int sorteoInstantaneo) {
		super();
		this.codigoID = codigoID;
		this.tipoAlbum = tipoAlbum;
		this.sorteoInstantaneo = sorteoInstantaneo;
	}
	public int getSorteoInstantaneo() {
		return sorteoInstantaneo;
	}
	public void setSorteoInstantaneo(int sorteoInstantaneo) {
		this.sorteoInstantaneo = sorteoInstantaneo;
	}
	public String getCodigoID() {
		return codigoID;
	}
	public void setCodigoID(String codigoID) {
		this.codigoID = codigoID;
	}
	public String getPremio() {
		return premio;
	}
	public void setPremio(String premio) {
		this.premio = premio;
	}
	public boolean isEstaCompleto() {
		return estaCompleto;
	}
	public void setEstaCompleto(boolean estaCompleto) {
		this.estaCompleto = estaCompleto;
	}
	public String getTipoAlbum() {
		return tipoAlbum;
	}
	public void setTipoAlbum(String tipoAlbum) {
		this.tipoAlbum = tipoAlbum;
	}
	public ArrayList<Figurita> getFiguritas() {
		return figuritas;
	}
	public void setFiguritas(ArrayList<Figurita> figuritas) {
		this.figuritas = figuritas;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void generarAlbum() {
		
	}
	
	
}

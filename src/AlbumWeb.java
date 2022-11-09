import java.util.HashMap;

public class AlbumWeb extends Album {

	private int codigoPromocional;
	private boolean codUsado;

	public AlbumWeb(int CodId, int DniParaSorteo,int CodPromocional) {
		super(CodId, DniParaSorteo);
		this.codigoPromocional=CodPromocional;
		this.premio="camiseta";
		this.pegadas=new HashMap<Integer,Figurita>();
	}


	public int getCodigoPromocional() {
		return codigoPromocional;
	}


	public void setCodigoPromocional(int codigoPromocional) {
		this.codigoPromocional = codigoPromocional;
	}


	public boolean isCodUsado() {
		return codUsado;
	}


	public void setCodUsado(boolean codUsado) {
		this.codUsado = codUsado;
	}
	
	
	@Override
	public HashMap<Integer, Figurita> getPegadas() {
		return pegadas;
	}

}

import java.util.ArrayList;
import java.util.HashMap;

public class AlbumTradicional extends Album{


	public AlbumTradicional(int CodId,int ParaSorteo){
		super(CodId,ParaSorteo);
		this.premio="pelota";
		this.estaCompleto=false;
		this.pegadas=new HashMap<Integer,Figurita>();
	}

	
	@Override
	public HashMap<Integer, Figurita> getPegadas() {
		return pegadas;
	}


	@Override
	public boolean DevolverCompletoPais(String nombrePais) {
		// TODO Auto-generated method stub
		int cont=0;
		for(Figurita f :pegadas.values()) {
			if(f.getNombrePais()== nombrePais) {
				cont++;
			}
		}return cont == 12;
	}


	@Override
	protected boolean estaCompleto() {
		// TODO Auto-generated method stub
		return super.estaCompleto();
	}

	public String getPremio(){
		return this.premio;
	}

	
	
      


}

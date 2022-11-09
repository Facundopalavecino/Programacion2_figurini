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
      


}

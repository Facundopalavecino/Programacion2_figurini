import java.util.HashMap;

public class AlbumExtendido extends Album {
	HashMap<Integer,FiguritaTop10> top10;


	public AlbumExtendido(int codID, int CodSorteo) {
		// TODO Auto-generated constructor stub
		super(codID,CodSorteo);
		this.pegadas = new HashMap<Integer,Figurita>();
		this.top10= new HashMap<Integer,FiguritaTop10>();
		this.premio="pelota Y viaje";
	}


	public HashMap<Integer, FiguritaTop10> getTop10() {
		return top10;
	}


	public void setTop10(HashMap<Integer, FiguritaTop10> top10) {
		this.top10 = top10;
	}
	
	@Override
	public HashMap<Integer, Figurita> getPegadas() {
		return pegadas;
	}
	
	public boolean completo() { // recorro las figuritas que tiene pegadas si es igual a 12x32 es que lo completo
		int cont=0;
		for(int i : pegadas.keySet()){
		}
		return cont==12*32;
	}
	

}

import java.util.HashMap;

public class AlbumExtendido extends Album {
	HashMap<Integer,FiguritaTop10> top10;


	public AlbumExtendido(int i) {
		// TODO Auto-generated constructor stub
		super();
		codigoID=i;
		pegadas = new HashMap<Integer,Figurita>();
		top10= new HashMap<Integer,FiguritaTop10>();
	}
	
	

}

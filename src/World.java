import java.net.*;
import java.util.*;


public class World {
	
	private Random r;
	private static final int WORLDDIMX = 10;
	private static final int WORLDDIMY = 10;
	private Tile[][] globe = new Tile[WORLDDIMX][WORLDDIMY];
	ArrayList<Tile> populatedTiles;
	ArrayList<Society> societies;
	

	
	public World() {
		createWorld();
		r = new Random();
		societies = new ArrayList<Society>();
		populatedTiles = new ArrayList<Tile>();
	}
	
	public Tile addSociety(Society a){
		societies.add(a);
		while(true){
			int xpos = r.nextInt(WORLDDIMX);
			int ypos = r.nextInt(WORLDDIMY);
			Tile temp = globe[xpos][ypos];
			if(!populatedTiles.contains(temp)){
				populatedTiles.add(temp);
				return temp;
			}
		}
		
	}
	
	private void createWorld(){
		for(int i=0; i<WORLDDIMX; i++){
			for(int j=0; j<WORLDDIMY; j++){
				globe[i][j]=new Tile();
			}
		}
	}
	
}

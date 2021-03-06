//f=farm
//F=forest
//M=mountain
//G=greenland
//p=starting center
//h=house

import java.util.*;
public class Tile {
      Resources[][] terrain;
      Random rand = new Random();
      private static final int FOREST = 0;
      private static final int MOUNTAIN = 1;
      private static final int GRASSLAND = 2;
  	  private ArrayList<Integer> placesBeingWorked=new ArrayList<Integer>();
      
      public Tile(){
    	  terrain = new Resources[5][5];
    	  for(int i=0;i<5;i++)
    		  for(int j=0;j<5;j++)
    		  {
    			  switch (rand.nextInt(3)){
    			  case FOREST: terrain[i][j] = new Forest(); break;
    			  case MOUNTAIN: terrain[i][j] = new Mountains(); break;
    			  case GRASSLAND: terrain[i][j] = new Grassland(); break;
    			  }
    		  }   	  
      }
      
      public ArrayList<String> getTerrains(){
    	  ArrayList<String> terrains = new ArrayList<String>(25);
    	  for(int i=0; i<5;i++){
    		  for(int j=0; j<5; j++){
    			  terrains.add(terrain[i][j].getImageURL());    		  }
    	  }
    	  return terrains;
      }
      
      public int getWidth(){
    	  return terrain.length;
      }
      
      public int getHeight(){
    	  return terrain[0].length;
      }
      
  	public ArrayList<Integer> getBlocksUsed(){
		return placesBeingWorked;
	}
  	
  	public void clearBlocks(){
  		placesBeingWorked.clear();
  	}
  	
  	public void addBlock(int block){
  		placesBeingWorked.add(block);
  	}
  	
  	public Resources getType(int gridNumber){
  		int x = gridNumber%terrain.length;
  		int y = gridNumber/terrain.length;
  		return terrain[x][y];
  	}
}

import java.util.*;

public class WorkParty {
	Random r=new Random();
	int farmmod,minemod,resourcemod;
	int location; //not needed to be a field?
	Human[] members;
	Tile myTile;
	Resources myResource;
	
	public WorkParty(Human[] party, Tile gLocation){
		
		farmmod=0;
		minemod=0;
		resourcemod=0;
		members = party;
		determineMods();
		myTile= gLocation;
		assignBlock();
	}
	
	private void determineMods(){
		for(int i=0;i<members.length;i++)
		{
			farmmod+=members[i].chromosomes[1];
			minemod+=members[i].chromosomes[2];
		    resourcemod+=members[i].chromosomes[6];
		}
		farmmod=farmmod/members.length;
		minemod=minemod/members.length;
		resourcemod=resourcemod/members.length;
	}
	
	private void assignBlock(){
		int size = myTile.getWidth()*myTile.getHeight();
		int spot = r.nextInt(size);
		while(myTile.getBlocksUsed().contains(spot)){
			spot = r.nextInt(size);
		}
		myTile.addBlock(spot);
		myResource = myTile.getType(spot);
		location = spot;
	}
	
	public void gather(){
		
	}
}

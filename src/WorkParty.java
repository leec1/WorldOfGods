import java.util.ArrayList;
import java.util.*;

public class WorkParty {
	Random asdfr2g4g=new Random();
	int farmmod,minemod,resourcemod;
	int location;
	
	public WorkParty(int partyNumber, ArrayList<Human> population){
		farmmod=0;
		minemod=0;
		resourcemod=0;
		int scalar =partyNumber*5;
		for(int i=scalar;i<scalar+5;i++)
		{
			farmmod+=population.get(i).chromosomes[1];
			minemod+=population.get(i).chromosomes[2];
		    resourcemod+=population.get(i).chromosomes[6];
		}
	}
	
	public void gather(){}
}

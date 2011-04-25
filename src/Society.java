import java.util.*;
public class Society {
	ArrayList<Human> population;
	Random rand = new Random();
	int maxSize;
	int localTraits[];
	int[] localCharacteristics;
	static final int MORTALITYRATE=15;
	static final int INITPOPSIZE=20;
	static final int INITFOOD=60;
	static final int MALE = 1;
	static final int FEMALE = 0;
	int food,metal,wood;
	ArrayList<Tile> cTiles;
	World myWorld;
	int[] placesbeingworked=new int[25];
	
	public Society(int traits[], World world)
	{
		food=INITFOOD;
		metal=0;
		wood=0;
		cTiles = new ArrayList<Tile>();
		myWorld = world;
		maxSize=INITPOPSIZE;
		localTraits=traits;
		population = new ArrayList<Human>(INITPOPSIZE);
		for(int i=0;i<INITPOPSIZE;i++)
			population.add(new Human(localTraits));
		localCharacteristics=new int[8];
		determineAverages();
		 
	 }
	public void breed()
	{
		if(determineAbleToBreed()){
		determineOnes();
		ArrayList<Human> newpop = new ArrayList<Human>();
		while(population.size()>1){
			Human a = population.remove(rand.nextInt(population.size()));
			Human b = population.remove(rand.nextInt(population.size()));
				if(a.getSex()!=b.getSex())
				{
					newpop.add(a);
					newpop.add(b);
					newpop.add(new Human(a,b));
				}
				else{
					newpop.add(a);
					newpop.add(b);
				}
		}	
		for(int i=0;i<newpop.size(); i++)
		{
			if(rand.nextInt(100)<MORTALITYRATE)
				newpop.remove(i);
		}
	population=newpop;
	if(population.size()>maxSize)
		maxSize=population.size();
	determineAverages();
		}
	}
	private boolean determineAbleToBreed() {
	
		return false;
	}
	public int maxSize(){return maxSize;}
	public String toString(){
		String s = "";
		for(int i=0;i<population.size();i++)
		{
			s+=population.get(i)+"\n";
		}
		return s;
	}
	
	public void determineOnes()
	{
		if(population.size()>1){
		int minpos=0;
		Human max,worst;
		if(population.get(0).returnAverage()>population.get(1).returnAverage())
		{
			max=population.get(0);
			worst=population.get(1);
			minpos=1;
		}
		else
		{
			max=population.get(1);
			worst=population.get(0);
		}
		for(int i=1;i<population.size();i++){
			if(max.returnAverage()<population.get(i).returnAverage())
				max=population.get(i);
			if(worst.returnAverage()>population.get(i).returnAverage()){
				minpos=i;
				worst=population.get(i);}
			
		}
		population.remove(minpos);
		population.add(max);		
		}
		
	}
	
	private void determineAverages(){
		if(!population.isEmpty()){
		int[] sums = new int[population.get(0).getChromosomes().length];
		int popSize = population.size();
		
		for(int i=0; i<popSize; i++){
			Human temp = population.get(i);
			for(int j=0; j<temp.getChromosomes().length; j++){
				sums[j]+=temp.getChromosomes()[j];
			}
		}
		for(int i = 0 ; i< sums.length; i++){
			//System.out.print(sums[i]/popSize + " ");
			localCharacteristics[i] = sums[i]/popSize;
		}
		}
	}
	
	public int[] getCharacteristics(){	
		return localCharacteristics;
	}
	
	public int getPopSize(){
		return population.size();
	}
	
	public double[] getSexBreakdown(){
		int males=0;
		int popSize = population.size();
		for(int i=0; i<popSize; i++){

			if(population.get(i).getSex()==MALE) males++;
		}
		double[] results = new double[2];
		results[0]= males/(double)popSize;
		results[1]= (popSize-males)/(double)popSize;
		return results;
	}
	
	public void associateTile(Tile t){
		cTiles.add(t);
	}
	
	public Tile getTile(){
		return cTiles.get(0);
	}
	public void step(){
		gatherResources();
		breed();
	}
	private void gatherResources() {
		ArrayList<WorkParty> workparty = new ArrayList<WorkParty>();
		int numparties = population.size()/5;
		for(int i=0;i<numparties;i++){
			workparty.add(new WorkParty(i,population));
		for(int k=0;k<workparty.size();k++){
			
			workparty.get(k).gather();
		}
		
			
		}
		
	}
}


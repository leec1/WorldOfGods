import java.util.*;
public class Human {
	int chromosomes[];
	Random rand = new Random();
	private int sex;
	int s,a,i,c,e;
	static final int INITSD=6;
	static final int CROSSOVER=4;
	static final int DRASTICCROSS=15;
	static final int MALE=1;
	static final int FEMALE=0;
	public Human(int workparty){
		
	}
public Human(int[] traits)
{	s=traits[0];
	a=traits[1];
	i=traits[2];
	c=traits[3];
	e=traits[4];
	chromosomes=new int[8];
	createChromosomes();
	decideSex();
}
public Human(Human a, Human b){
	decideSex();
	
	
	geneticCrossover(a.getChromosomes(),b.getChromosomes());
}

public int[] getChromosomes(){return chromosomes;}
void createChromosomes()
{
	 chromosomes[0]=a+i+c+50+rand.nextInt(2*INITSD)-INITSD;
	 chromosomes[1]=-s-e-c+50+rand.nextInt(2*INITSD)-INITSD;
	 chromosomes[2]=s+e+c+50+rand.nextInt(2*INITSD)-INITSD;
	 chromosomes[3]=s+a-c+50+rand.nextInt(2*INITSD)-INITSD;
	 chromosomes[4]=-a-i+e+50+rand.nextInt(2*INITSD)-INITSD;
	 chromosomes[5]=a+s-i+50+rand.nextInt(2*INITSD)-INITSD;
	 chromosomes[6]=e+a+c+50+rand.nextInt(2*INITSD)-INITSD;
	 chromosomes[7]=-i-c-a+50+rand.nextInt(2*INITSD)-INITSD;
}
void decideSex()
{
	if(rand.nextInt(101)<50)
		sex=MALE;
		else
		sex=FEMALE;
}
public int getSex(){return sex;}
private void geneticCrossover(int[] a, int[] b){
	chromosomes=new int[a.length];
	for(int i=0;i<a.length;i++)
	{
		
		if(rand.nextInt(100)<90)
		   chromosomes[i]=(a[i]+b[i])/2+rand.nextInt(2*CROSSOVER)-CROSSOVER;
		else
			chromosomes[i]=(a[i]+b[i])/2+rand.nextInt(2*DRASTICCROSS)-DRASTICCROSS;
		
	}
	
}
public String toString()
{
	String s="";
	for(int i=0;i<chromosomes.length;i++)
		s+=chromosomes[i]+" ";
	return s;
}
public double returnAverage(){
	int sum=0;
	for(int i=0;i<chromosomes.length;i++)
	{
		sum+=chromosomes[i];
	}
	return sum/(double)chromosomes.length;
}

}




public class Grassland extends Resources{
	public Grassland(){
		super();
		super.imageURL="grass.gif";
	}
	
	public Boolean useResources(int numUsed){
		System.out.println("Deplete Deplete Deplete");
		return super.useResources(numUsed);
	}


	public Boolean checkRegenerate(){
		if(!super.usedUp && super.checkRegenerate()){
			System.out.println("Nutrionionize!");
			return true;
		}
		else return false;
	}
}

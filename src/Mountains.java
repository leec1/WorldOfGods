
public class Mountains extends Resources{
	public Mountains(){
		super();
		super.imageURL="mtns.gif";
		
	}
	public Boolean useResources(int numUsed){
		System.out.println("Mine Mine Mine");
		return super.useResources(numUsed);
	}

	public Boolean checkRegenerate(){
		if(!super.usedUp && super.checkRegenerate()){
			System.out.println("NEW VEIN!");
			return true;
		}
		else return false;
	}
	
}

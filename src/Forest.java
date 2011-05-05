public class Forest extends Resources {
	public Forest(){
		super();
		super.imageURL="forest.gif";
		
	}
	
	public Boolean useResources(int numUsed){
		System.out.println("Chop Chop Chop");
		return super.useResources(numUsed);
	}
	
	public Boolean checkRegenerate(){
		if(!super.usedUp && super.checkRegenerate()){
			System.out.println("Grow Grow Grow");
			return true;
		}
		else return false;
	}
}

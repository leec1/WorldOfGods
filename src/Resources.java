import java.util.*;

abstract class Resources {
	
	private final static int MAXRESOURCES = 5;
	protected String imageURL;
	private int quantity;
	protected Random r;
	protected Boolean usedUp;
	
	public Resources(){
		r = new Random();
		setQuantity();
	}
	

	public String getImageURL(){return imageURL;}
	
	private void setQuantity(){
		quantity = r.nextInt(MAXRESOURCES)+1;
	}
	
	protected Boolean useResources(int numUsed){
		if(numUsed > quantity) return false;
		else{
			quantity-=numUsed;
			return true;
		}
	}
	
	protected Boolean checkRegenerate(){
		if(r.nextInt(100)<15){
			quantity++;
			return true;
		}
		else return false;
	}
}

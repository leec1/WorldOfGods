import java.net.MalformedURLException;

//fighting-agressiveness interactionType culture type
//farming-culture societyType economic type(com)
//mining-culture type, society type, economic type(capital)
//mating-society type,agresiveness 
//trading-interaction,agressiveness, economic type
//exploring-agressiveness, societal type, interaction type
//resource finding-economic type, agressiveness, culture type
//morale-agressiveness, interaction, culture(ART)


public class Executor {
	static int societyType;
	static int agressiveness;
	static int interactionType;
	static int cultureType;
	static int economicType;
	
	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		int traits[]= new int[5];
		
		//Pat(10) vs mat
		societyType = Integer.parseInt(args[0]);
		//Passive vs agressive(10)
		agressiveness =Integer.parseInt(args[1]);
		//Diplo vs militaristic(10)
		interactionType=Integer.parseInt(args[2]);
		//Science(10) vs art
		cultureType=Integer.parseInt(args[3]);
		//Communism vs capitilism(10)
		economicType=Integer.parseInt(args[4]);
		traits[0]=societyType;
		traits[1]=agressiveness;
		traits[2]=interactionType;
		traits[3]=cultureType;
		traits[4]=economicType;
		World world = new World();
		Society soc = new Society(traits, world);
		soc.associateTile(world.addSociety(soc));
		MFGUI gui = new MFGUI(soc);
		for(int i=0;i<100;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			soc.step();
			gui.repaintLabels();
			}

		//Society soc = new Society(traits);
		//new MFGUI(soc);
	}

}

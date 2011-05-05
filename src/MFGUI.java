import java.net.URL;
import java.util.*;
import java.awt.*;

import javax.swing.*;

public class MFGUI {
	ImageIcon mnt,forest,grass;
	static JFrame mainFrame;
	static JLabel[] stats;
	static JPanel statScreen;
	static JPanel mainPanel;
	static Society user;
	JPanel cMap;
	String[] statNames = {"Fighting Stats:","Farming Stats:","Mining Stats:","Mating Stats:","Trading Stats:","Exploring Stats:","Resource Gathering Stats:","Morale Stats:"};
	
	/*public static void main(String[] args){
		int[] test = new int[5];
		for(int i=0; i<test.length; i++) test[i]=i;
		System.out.println("HERE");
		Society soc = new Society(test);
		new MFGUI(soc);
		for(int i=0;i<100;i++){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		soc.breed();
		repaintLabels();
		}
		
	}*/
	
	public MFGUI(Society user){
		stats=new JLabel[22];
		this.user= user;
		mainFrame = new JFrame();
		mainFrame.setSize(800, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildFrame();
		mainFrame.pack();
		mainFrame.setVisible(true);

	}
	
	private void buildFrame(){
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2,3));
		mainPanel.add(buildLogIn());
		mainPanel.add(buildStatScreen());
		mainPanel.add(buildWorldMap());
		mainPanel.add(buildOptions());
		mainPanel.add(buildPopMap());
		mainPanel.add(buildView());
		mainFrame.add(mainPanel);
	}
	
	private JPanel buildPopMap() {
		cMap = new JPanel();
			
		cMap.setLayout(new GridLayout(5,5,0,0));
		
		ArrayList<String> urls = user.getTile().getTerrains();
		for(int i=0; i<urls.size();i++){
			cMap.add(new JLabel(new ImageIcon(urls.get(i))));
		}
		return cMap;
	}

	private JPanel buildView() {
		// TODO Auto-generated method stub
		return new JPanel();
	}

	private JPanel buildOptions() {
		// TODO Auto-generated method stub
		return new JPanel();
	}

	private JPanel buildWorldMap() {
		// TODO Auto-generated method stub
		return new JPanel();
	}

	private JPanel buildStatScreen() {
		statScreen = new JPanel();
		int[] info = user.getCharacteristics();
		int popSize = user.getPopSize();
		double[] sexes = user.getSexBreakdown();
		
		statScreen.setLayout(new GridLayout(info.length+3,2));
		
		stats[0]=new JLabel("Population:");
		stats[1]=new JLabel(String.format("%d",popSize));
		stats[2]=new JLabel("Male Percentage:");
		stats[3]=new JLabel(String.format("%.2f", sexes[0]));
		stats[4]=new JLabel("Female Percentage:");
		stats[5]=new JLabel(String.format("%.2f", sexes[1]));
		stats[6]=new JLabel(statNames[0]);
		stats[7]=new JLabel(String.format("%d",info[0]));
		stats[8]=new JLabel(statNames[1]);
		stats[9]=new JLabel(String.format("%d",info[1]));
		stats[10]=new JLabel(statNames[2]);
		stats[11]=new JLabel(String.format("%d",info[2]));
		stats[12]=new JLabel(statNames[3]);
		stats[13]=new JLabel(String.format("%d",info[3]));
		stats[14]=new JLabel(statNames[4]);
		stats[15]=new JLabel(String.format("%d",info[4]));
		stats[16]=new JLabel(statNames[5]);
		stats[17]=new JLabel(String.format("%d",info[5]));
		stats[18]=new JLabel(statNames[6]);
		stats[19]=new JLabel(String.format("%d",info[6]));
		stats[20]=new JLabel(statNames[7]);
		stats[21]=new JLabel(String.format("%d",info[7]));
		for(int i=0; i<stats.length; i++){ statScreen.add(stats[i]);}
		return statScreen;
	}

	private JPanel buildLogIn(){
		// TODO Auto-generated method stub
		return new JPanel();
	}
	
	public void repaintLabels(){
		int[] info = user.getCharacteristics();
		int popSize = user.getPopSize();
		double[] sexes = user.getSexBreakdown();
		
		stats[1].setText(String.format("%d",popSize));
		stats[3].setText(String.format("%.2f", sexes[0]));
		stats[5].setText(String.format("%.2f", sexes[1]));
		stats[7].setText(String.format("%d",info[0]));
		stats[9].setText(String.format("%d",info[1]));
		stats[11].setText(String.format("%d",info[2]));
		stats[13].setText(String.format("%d",info[3]));
		stats[15].setText(String.format("%d",info[4]));
		stats[17].setText(String.format("%d",info[5]));	
		stats[19].setText(String.format("%d",info[6]));
		stats[21].setText(String.format("%d",info[7]));
	}
	
	
}

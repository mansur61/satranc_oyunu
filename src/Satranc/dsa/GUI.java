package Satranc.dsa;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Graphics;

public class GUI  {
	
	
	public static void main(String[] args)
	{
		JFrame frame=new JFrame("Santranç Oyunu");
		frame.setSize(800, 600);
		Tahta bb=new Tahta();
		frame.add(bb);
		//frame.dispose(); pencereyi görünür kýlmaz enable()--> görünür kýlar
		frame.setVisible(true);
		//frame.show();//-->Ayný Kod //frame.setVisible(true);	
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	
}

package Satranc.dsa;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Graphics;

public class GUI  {
	
	
	public static void main(String[] args)
	{
		JFrame frame=new JFrame("Santran� Oyunu");
		frame.setSize(800, 600);
		Tahta bb=new Tahta();
		frame.add(bb);
		//frame.dispose(); pencereyi g�r�n�r k�lmaz enable()--> g�r�n�r k�lar
		frame.setVisible(true);
		//frame.show();//-->Ayn� Kod //frame.setVisible(true);	
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	
}

package Satranc.dsa;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;


public abstract class Taslar extends Kareler{
	public static Kareler kare[][]=new Kareler[8][8];
	public abstract void Hareket( Kareler kare[][]);
	
}

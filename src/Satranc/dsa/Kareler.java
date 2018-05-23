package Satranc.dsa;

import java.awt.Button;
import java.awt.Image;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;

public  class Kareler extends JButton{
	public  static Point p=new Point();
	public static int a,b;
	public int sira1,sira2;
	public Boolean karsi=true;
	public	Kareler(){
		
	}
	
	public  Point Location(){
		return p;
	}
	
	public Point gettranslate(){
		return p;
	}
}

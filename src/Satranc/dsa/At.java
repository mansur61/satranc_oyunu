package Satranc.dsa;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class At extends JButton{
	
	public static Kareler kare[]=new Kareler[64];		
	public Icon icon;
	public static int i;
		
	public  At(Icon resim,int index){
		
		setIcon(resim);
		//Hareket(index);
	}
	
	public void setIcon(Icon resim){
		
		this.icon = resim;
	}
	
	public Icon getImageIcon(){
		
		return this.icon;
	}

}

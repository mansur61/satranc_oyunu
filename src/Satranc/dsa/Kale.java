package Satranc.dsa;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Kale {
	
	public static Kareler kare[]=new Kareler[4];		
	public Icon icon;		
		
public  Kale(Icon resim){
	
	setIcon(resim);
}

public void setIcon(Icon resim){
	
	this.icon = resim;
}

public Icon getImageIcon(){
	
	return this.icon;
}
}

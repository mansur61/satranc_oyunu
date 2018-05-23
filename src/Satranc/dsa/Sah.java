package Satranc.dsa;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Sah {
	public static Kareler kare[]=new Kareler[4];		
	public Icon icon;		
		
	public  Sah(Icon resim){
		
		setIcon(resim);
	}
	
	public void setIcon(Icon resim){
		
		this.icon = resim;
	}
	
	public Icon getImageIcon(){
		return this.icon;
	}
}

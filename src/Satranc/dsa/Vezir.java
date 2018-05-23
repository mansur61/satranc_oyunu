package Satranc.dsa;

import javax.swing.Icon;

public class Vezir {
	public static Kareler kare[]=new Kareler[4];		
	public Icon icon;		
		
		public  Vezir(Icon resim){
			
			setIcon(resim);
		}
		
		public void setIcon(Icon resim){
			
			this.icon = resim;
		}
		
		public Icon getImageIcon(){
			
			return this.icon;
		}
}

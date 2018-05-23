package Satranc.dsa;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Fil {
			public static Kareler kare[]=new Kareler[4];		
			public Icon icon;		
				
		public  Fil(Icon resim){
			
			setIcon(resim);
		}
		
		public void setIcon(Icon resim){
			
			this.icon = resim;
		}
		
		public Icon getImageIcon(){
			
			return this.icon;
		}
		

	
}



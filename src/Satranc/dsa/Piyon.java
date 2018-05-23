package Satranc.dsa;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Piyon extends Taslar{// JPanel,
	
	public static Kareler kare[][]=new Kareler[8][8];		
	public  Icon icon;		
	JPanel panel;	
	JButton buton;
	 Tahta tahta_al;
	 ImageIcon kare_al[][]=new ImageIcon[8][8];
	 boolean Koordinat_söyle;
		public  Piyon(Icon resim,Kareler[][] kare){
			//buton=new JButton();
			panel=new JPanel();
			//panel.add(this);	
			setIcon(resim);

			Hareket(kare);	
			
			try{
					Hareket(kare);				
			}
			catch(Exception istisna){
				System.err.printf("%s\n ",istisna.getMessage());
				istisna.printStackTrace();
			
			}
			
		}

		public void setIcon(Icon resim){	
			this.icon = resim;
		}
		public  Icon getImageIcon(){	
			return this.icon;
		}
		
		
	
		@Override
		public void Hareket(Kareler[][] kare) {
			
			for( int i=0;i<8;i++){
				for( int j=0;j<8;j++){
					
					kare[j][i]=new Kareler();
					panel.add(kare[j][i]);
					
				
				}//içteki for sonu
			}//dýþtaki for sonu
			
		}
		
	
		
}

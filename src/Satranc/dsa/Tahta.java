package Satranc.dsa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tahta extends JPanel {

	public static Kareler[][] kare = new Kareler[8][8];
	ImageIcon kare_al[][] = new ImageIcon[8][8];
	ImageIcon resim_copy[][] = new ImageIcon[8][8];
	int index, x, y;

	public Fil siyah_filo1 = new Fil(ikonlar[2]);
	public Fil siyah_filo2 = new Fil(ikonlar[5]);
	public At siyah_at1 = new At(ikonlar[1], index);
	public At siyah_at2 = new At(ikonlar[6], index);
	public Piyon siyah_piyon = new Piyon(ikonlar[8], kare);
	public Kale siyah_kale1 = new Kale(ikonlar[0]);
	public Kale siyah_kale2 = new Kale(ikonlar[7]);
	public Sah siyah_vezir = new Sah(ikonlar[3]);
	public Vezir siyah_sah = new Vezir(ikonlar[4]);
	// Kahverengi taslar
	public Fil kahve_filo1 = new Fil(ikonlar[12]);
	public Fil kahve_filo2 = new Fil(ikonlar[15]);
	public At kahve_at1 = new At(ikonlar[11], index);
	public At kahve_at2 = new At(ikonlar[16], index);
	public Kale kahve_kale1 = new Kale(ikonlar[10]);
	public Kale kahve_kale2 = new Kale(ikonlar[17]);
	public Piyon kahve_piyon = new Piyon(ikonlar[9], kare);
	public Sah kahve_vezir = new Sah(ikonlar[13]);
	public Vezir kahve_sah = new Vezir(ikonlar[14]);
	public static Point p = new Point();
	Kareler k = new Kareler();
	public static String isimler[] = {
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/black-rook.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/black-knight.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/black-bishop.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/black-queen.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/black-king.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/black-bishop.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/black-knight.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/black-rook.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/black-pawn.png",
			// Kahverengi Taslar
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/white-pawn.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/white-rook.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/white-knight.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/white-bishop.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/white-queen.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/white-king.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/white-bishop.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/white-knight.png",
			"C:/Users/mansuremin/OneDrive/Resimler/Resimler/white-rook.png" };


	public static Icon ikonlar[] = { new ImageIcon((isimler[0])), new ImageIcon((isimler[1])),
			new ImageIcon((isimler[2])), new ImageIcon((isimler[3])), new ImageIcon((isimler[4])),
			new ImageIcon((isimler[5])), new ImageIcon((isimler[6])), new ImageIcon((isimler[7])),
			new ImageIcon((isimler[8])), new ImageIcon((isimler[9])), new ImageIcon((isimler[10])),
			new ImageIcon((isimler[11])), new ImageIcon((isimler[12])), new ImageIcon((isimler[13])),
			new ImageIcon((isimler[14])), new ImageIcon((isimler[15])), new ImageIcon((isimler[16])),
			new ImageIcon((isimler[17]))

	};

	public Tahta() {

		super(new GridLayout(8, 8));

		int m = 0;
		int n = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				if (i == 0) {
					kare_al[i][j] = (ImageIcon) ikonlar[m];// siyah taslar
					resim_copy[i][j] = kare_al[i][j];
					m++;
				}
				if (i == 1) {
					kare_al[i][j] = (ImageIcon) ikonlar[8];// siyah piyon
					resim_copy[i][j] = kare_al[i][j];
				}
				if (i == 6) {
					kare_al[i][j] = (ImageIcon) ikonlar[9];// kahve piyon
					resim_copy[i][j] = kare_al[i][j];

				}

				if (i == 7) {
					kare_al[i][j] = (ImageIcon) ikonlar[10 + n];// kahve taslar
					resim_copy[i][j] = kare_al[i][j];
					n++;
				}

			}
		}
		// ilk for
		for (int i = 0; i < 8; i++) {

			if ((i == 2) && (i == 3) && (i == 4) && (i == 5)) {
				continue;
			}

			for (int x = 0; x < 8; x++) {
				kare[i][x] = new Kareler();
				add(kare[i][x]);
				if (i % 2 == 0 && x % 2 == 1) {
					kare[i][x].setBackground(Color.BLUE);
				}
				if (i % 2 == 1 && x % 2 == 0) {
					kare[i][x].setBackground(Color.BLUE);
				}
				if (i == 0 && (x == 0 || x == 7)) {
					kare[i][x].setIcon(siyah_kale1.getImageIcon());
					// kare_al[i][x]=new ImageIcon(isimler[0]);

				}
				if (i == 0 && (x == 1 || x == 6)) {
					kare[i][x].setIcon(siyah_at1.getImageIcon());

				}
				if (i == 0 && (x == 2 || x == 5)) {
					kare[i][x].setIcon(siyah_filo1.getImageIcon());

				}
				if (i == 0 && (x == 4)) {
					kare[i][x].setIcon(siyah_sah.getImageIcon());
				}
				if (i == 0 && (x == 3)) {
					kare[i][x].setIcon(siyah_vezir.getImageIcon());
				}

				if (i == 1) {
					kare[i][x].setIcon(siyah_piyon.getImageIcon());
					// kare_al[i][x]=new ImageIcon(isimler[8]);
				}

				if (i == 6) {
					kare[i][x].setIcon(kahve_piyon.getImageIcon());
					// kare_al[i][x]=new ImageIcon(isimler[9]);
				}

				if (i == 7 && (x == 0 || x == 7)) {
					kare[i][x].setIcon(kahve_kale1.getImageIcon());
					// kare_al[i][x]=new ImageIcon(isimler[10]);
				}

				if (i == 7 && (x == 1 || x == 6)) {
					kare[i][x].setIcon(kahve_at1.getImageIcon());
					// kare_al[i][x]=new ImageIcon(isimler[11]);

				}
				if (i == 7 && (x == 2 || x == 5)) {
					kare[i][x].setIcon(kahve_filo1.getImageIcon());

				}
				if (i == 7 && (x == 4)) {
					kare[i][x].setIcon(kahve_sah.getImageIcon());
				}
				if (i == 7 && (x == 3)) {
					kare[i][x].setIcon(kahve_vezir.getImageIcon());
				}

				int a = i;
				int b = x;

				kare[a][b].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						if (k.karsi == true) {
							if (kare_al[a][b] == siyah_piyon.getImageIcon() || kare_al[a][b] == siyah_at1.getImageIcon()
									|| kare_al[a][b] == siyah_at2.getImageIcon()
									|| kare_al[a][b] == siyah_filo1.getImageIcon()
									|| kare_al[a][b] == siyah_filo2.getImageIcon()
									|| kare_al[a][b] == siyah_kale2.getImageIcon()
									|| kare_al[a][b] == siyah_kale1.getImageIcon()
									|| kare_al[a][b] == siyah_vezir.getImageIcon()
									|| kare_al[a][b] == siyah_sah.getImageIcon()) {
								
								if (kare_al[k.sira1][k.sira2] == kahve_piyon.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										if (k.sira2 == b - 1 && k.sira1 == a + 1
												|| k.sira2 == b + 1 && k.sira1 == a + 1) {
											if(kare_al[a][b]==siyah_sah.getImageIcon()){
												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
												JOptionPane.showMessageDialog(null,"KAHVERENGÝ OYUNCU KAZANDÝÝ");
												
											}
											else
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											
											k.karsi = false;
											System.out.println(k.karsi);
										}

									}

								}
								if (kare_al[k.sira1][k.sira2] == kahve_at1.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == kahve_at2.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										if ((k.sira1 == a + 2 && k.sira2 == b + 1)
												|| (k.sira1 == a + 2 && k.sira2 == b - 1)
												|| (k.sira1 == a + 1 && k.sira2 == b - 2)
												|| (k.sira1 == a + 1 && k.sira2 == b + 2)
												|| (k.sira1 == a - 2 && k.sira2 == b - 1)
												|| (k.sira1 == a - 2 && k.sira2 == b + 1)
												|| (k.sira1 == a - 1 && k.sira2 == b + 2)

												|| (k.sira1 == a - 1 && k.sira2 == b - 2)) {
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											
											k.karsi = false;
											System.out.println(k.karsi);
										}
									}

								}
								if (kare_al[k.sira1][k.sira2] == kahve_kale1.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == kahve_kale2.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == kahve_vezir.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										if (k.sira1 == a) {
											if(kare_al[a][b]==siyah_sah.getImageIcon()){
												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
												JOptionPane.showMessageDialog(null,"KAHVERENGÝ OYUNCU KAZANDÝÝ");
												
											}else
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = false;
											System.out.println(k.karsi);
										}
										if (k.sira2 == b) {
											if(kare_al[a][b]==siyah_sah.getImageIcon()){
												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
												JOptionPane.showMessageDialog(null,"KAHVERENGÝ OYUNCU KAZANDÝÝ");
												
											}else
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = false;
											System.out.println(k.karsi);
										}
									}
								}
								if (kare_al[k.sira1][k.sira2] == kahve_filo1.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == kahve_filo2.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == kahve_vezir.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										for (int j = 1; b >= k.sira2 + j || b <= k.sira2 - j; j++) {
											if ((k.sira1 == a + j && k.sira2 == b - j)
													|| (k.sira1 == a - j && k.sira2 == b - j)
													|| (k.sira1 == a + j && k.sira2 == b + j)
													|| (k.sira1 == a - j && k.sira2 == b + j)) {
												if(kare_al[a][b]==siyah_sah.getImageIcon()){
													kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
													kare_al[a][b] = kare_al[k.sira1][k.sira2];
													kare_al[k.sira1][k.sira2] = null;
													kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
													JOptionPane.showMessageDialog(null,"KAHVERENGÝ OYUNCU KAZANDÝÝ");
													
												}else
												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
												k.karsi = false;
												System.out.println(k.karsi);
											}
										}

									}
								}

								if (kare_al[k.sira1][k.sira2] == kahve_sah.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {

										if ((k.sira1 == a + 1 && k.sira2 == b - 1)
												|| (k.sira1 == a - 1 && k.sira2 == b - 1)
												|| (k.sira1 == a + 1 && k.sira2 == b + 1)
												|| (k.sira1 == a - 1 && k.sira2 == b + 1) || (k.sira1 == a + 1)
												|| (k.sira1 == a - 1) || (k.sira2 == b + 1) || (k.sira2 == b - 1)) {
											if(kare_al[a][b]==siyah_sah.getImageIcon()){
												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
												JOptionPane.showMessageDialog(null,"KAHVERENGÝ OYUNCU KAZANDÝÝ");
												
											}else
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = false;
											System.out.println(k.karsi);

										}

									}
								}

							}

							if (kare_al[a][b] == null) {
								if (kare_al[k.sira1][k.sira2] == kahve_piyon.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										if (k.sira1 == 6 && k.sira1 == a + 2) {
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);

											k.karsi = false;
											System.out.println(k.karsi);
										} else if (k.sira2 == b && (k.sira1 == a + 1)) {

											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = false;
											System.out.println(k.karsi);
										}

									}

								}
								if (kare_al[k.sira1][k.sira2] == kahve_kale1.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == kahve_kale2.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == kahve_vezir.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										if (k.sira1 == a) {
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = false;
											System.out.println(k.karsi);
										}
										if (k.sira2 == b) {
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = false;
											System.out.println(k.karsi);
										}
									}
								}

								if (kare_al[k.sira1][k.sira2] == kahve_at1.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == kahve_at2.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										if ((k.sira1 == a + 2 && k.sira2 == b + 1)
												|| (k.sira1 == a + 2 && k.sira2 == b - 1)
												|| (k.sira1 == a + 1 && k.sira2 == b - 2)
												|| (k.sira1 == a + 1 && k.sira2 == b + 2)
												|| (k.sira1 == a - 2 && k.sira2 == b - 1)
												|| (k.sira1 == a - 2 && k.sira2 == b + 1)
												|| (k.sira1 == a - 1 && k.sira2 == b + 2)
												|| (k.sira1 == a - 1 && k.sira2 == b - 2)) {
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = false;
											System.out.println(k.karsi);
										}
									}
								}

								if (kare_al[k.sira1][k.sira2] == kahve_filo1.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == kahve_filo2.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == kahve_vezir.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										for (int j = 1; b >= k.sira2 + j || b <= k.sira2 - j; j++) {
											if ((k.sira1 == a + j && k.sira2 == b - j)
													|| (k.sira1 == a - j && k.sira2 == b - j)
													|| (k.sira1 == a + j && k.sira2 == b + j)
													|| (k.sira1 == a - j && k.sira2 == b + j)) {
												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
												k.karsi = false;
												System.out.println(k.karsi);
											}
										}

									}
								}

								if (kare_al[k.sira1][k.sira2] == kahve_sah.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {

										if ((k.sira1 == a + 1 && k.sira2 == b - 1)
												|| (k.sira1 == a - 1 && k.sira2 == b - 1)
												|| (k.sira1 == a + 1 && k.sira2 == b + 1)
												|| (k.sira1 == a - 1 && k.sira2 == b + 1) || (k.sira1 == a + 1)
												|| (k.sira1 == a - 1) || (k.sira2 == b + 1) || (k.sira2 == b - 1)) {
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = false;
											System.out.println(k.karsi);

										}

									}
								}

							}

							if (kare_al[a][b] == kahve_piyon.getImageIcon()
									|| kare_al[a][b] == kahve_kale1.getImageIcon()
									|| kare_al[a][b] == kahve_kale2.getImageIcon()
									|| kare_al[a][b] == kahve_at1.getImageIcon()
									|| kare_al[a][b] == kahve_at2.getImageIcon()
									|| kare_al[a][b] == kahve_filo1.getImageIcon()
									|| kare_al[a][b] == kahve_filo2.getImageIcon()
									|| kare_al[a][b] == kahve_vezir.getImageIcon()
									|| kare_al[a][b] == kahve_sah.getImageIcon()) {

								k.sira1 = a;
								k.sira2 = b;

							}

						} else if (k.karsi == false) {
							if (kare_al[a][b] == kahve_piyon.getImageIcon() || kare_al[a][b] == siyah_at1.getImageIcon()
									|| kare_al[a][b] == kahve_at2.getImageIcon()
									|| kare_al[a][b] == kahve_filo1.getImageIcon()
									|| kare_al[a][b] == kahve_filo2.getImageIcon()
									|| kare_al[a][b] == kahve_kale2.getImageIcon()
									|| kare_al[a][b] == kahve_kale1.getImageIcon()
									|| kare_al[a][b] == kahve_vezir.getImageIcon()
									|| kare_al[a][b] == kahve_sah.getImageIcon()) {
								if (kare_al[k.sira1][k.sira2] == siyah_piyon.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										if (k.sira2 == b - 1 && k.sira1 == a - 1
												|| k.sira2 == b + 1 && k.sira1 == a - 1) {
											if(kare_al[a][b]==kahve_sah.getImageIcon()){
												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
												JOptionPane.showMessageDialog(null,"siyah OYUNCU KAZANDÝÝ");
												
											}else

											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = true;
											System.out.println(k.karsi);
										}

									}

								}
								if (kare_al[k.sira1][k.sira2] == siyah_at1.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == siyah_at2.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										if ((k.sira1 == a + 2 && k.sira2 == b + 1)
												|| (k.sira1 == a + 2 && k.sira2 == b - 1)
												|| (k.sira1 == a + 1 && k.sira2 == b - 2)
												|| (k.sira1 == a + 1 && k.sira2 == b + 2)
												|| (k.sira1 == a - 2 && k.sira2 == b - 1)
												|| (k.sira1 == a - 2 && k.sira2 == b + 1)
												|| (k.sira1 == a - 1 && k.sira2 == b + 2)

												|| (k.sira1 == a - 1 && k.sira2 == b - 2)) {
											if(kare_al[a][b]==kahve_sah.getImageIcon()){
												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
												JOptionPane.showMessageDialog(null,"siyah OYUNCU KAZANDÝÝ");
												
											}else
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = true;
											System.out.println(k.karsi);
										}
									}

								}
								if (kare_al[k.sira1][k.sira2] == siyah_kale1.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == siyah_kale2.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == siyah_vezir.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										if (k.sira1 == a) {
											if(kare_al[a][b]==kahve_sah.getImageIcon()){
												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
												JOptionPane.showMessageDialog(null,"siyah OYUNCU KAZANDÝÝ");
												
											}else
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = true;
											System.out.println(k.karsi);
										}
										if (k.sira2 == b) {
											if(kare_al[a][b]==kahve_sah.getImageIcon()){
												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
												JOptionPane.showMessageDialog(null,"siyah OYUNCU KAZANDÝÝ");
												
											}else
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = true;
											System.out.println(k.karsi);
										}
									}
								}
								if (kare_al[k.sira1][k.sira2] == siyah_filo1.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == siyah_filo2.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == siyah_vezir.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										for (int j = 1; b >= k.sira2 + j || b <= k.sira2 - j; j++) {
											if ((k.sira1 == a + j && k.sira2 == b - j)
													|| (k.sira1 == a - j && k.sira2 == b - j)
													|| (k.sira1 == a + j && k.sira2 == b + j)
													|| (k.sira1 == a - j && k.sira2 == b + j)) {
												if(kare_al[a][b]==kahve_sah.getImageIcon()){
													kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
													kare_al[a][b] = kare_al[k.sira1][k.sira2];
													kare_al[k.sira1][k.sira2] = null;
													kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
													JOptionPane.showMessageDialog(null,"siyah OYUNCU KAZANDÝÝ");
													
												}else
												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
												k.karsi = true;
												System.out.println(k.karsi);
											}
										}

									}
								}

								if (kare_al[k.sira1][k.sira2] == siyah_sah.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {

										if ((k.sira1 == a + 1 && k.sira2 == b - 1)
												|| (k.sira1 == a - 1 && k.sira2 == b - 1)
												|| (k.sira1 == a + 1 && k.sira2 == b + 1)
												|| (k.sira1 == a - 1 && k.sira2 == b + 1) || (k.sira1 == a + 1)
												|| (k.sira1 == a - 1) || (k.sira2 == b + 1) || (k.sira2 == b - 1)) {
											if(kare_al[a][b]==kahve_sah.getImageIcon()){
												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
												JOptionPane.showMessageDialog(null,"siyah OYUNCU KAZANDÝÝ");
												
											}else
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = true;
											System.out.println(k.karsi);

										}

									}
								}

							}
							if (kare_al[a][b] == null) {
								if (kare_al[k.sira1][k.sira2] == siyah_piyon.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										if (k.sira1 != -1 && k.sira2 != -1) {
											if (k.sira1 == 1 && k.sira1 == a - 2) {
												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);

												k.karsi = true;
												System.out.println(k.karsi);
											} else if (k.sira2 == b && (k.sira1 == a - 1)) {

												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
												k.karsi = true;
												System.out.println(k.karsi);
											}

										}
									}
								}
								if (kare_al[k.sira1][k.sira2] == siyah_kale1.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == siyah_kale2.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == siyah_vezir.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										if (k.sira1 == a) {
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = true;
											System.out.println(k.karsi);
										}
										if (k.sira2 == b) {
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = true;
											System.out.println(k.karsi);
										}
									}
								}

								if (kare_al[k.sira1][k.sira2] == siyah_at1.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == siyah_at2.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										if ((k.sira1 == a + 2 && k.sira2 == b + 1)
												|| (k.sira1 == a + 2 && k.sira2 == b - 1)
												|| (k.sira1 == a + 1 && k.sira2 == b - 2)
												|| (k.sira1 == a + 1 && k.sira2 == b + 2)
												|| (k.sira1 == a - 2 && k.sira2 == b - 1)
												|| (k.sira1 == a - 2 && k.sira2 == b + 1)
												|| (k.sira1 == a - 1 && k.sira2 == b + 2)
												|| (k.sira1 == a - 1 && k.sira2 == b - 2)) {
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = true;
											System.out.println(k.karsi);
										}
									}
								}

								if (kare_al[k.sira1][k.sira2] == siyah_filo1.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == siyah_filo2.getImageIcon()
										|| kare_al[k.sira1][k.sira2] == siyah_vezir.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {
										for (int j = 1; b >= k.sira2 + j || b <= k.sira2 - j; j++) {
											if ((k.sira1 == a + j && k.sira2 == b - j)
													|| (k.sira1 == a - j && k.sira2 == b - j)
													|| (k.sira1 == a + j && k.sira2 == b + j)
													|| (k.sira1 == a - j && k.sira2 == b + j)) {
												kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
												kare_al[a][b] = kare_al[k.sira1][k.sira2];
												kare_al[k.sira1][k.sira2] = null;
												kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
												k.karsi = true;
												System.out.println(k.karsi);
											}
										}

									}
								}

								if (kare_al[k.sira1][k.sira2] == siyah_sah.getImageIcon()) {
									if (k.sira1 != -1 && k.sira2 != -1) {

										if ((k.sira1 == a + 1 && k.sira2 == b - 1)
												|| (k.sira1 == a - 1 && k.sira2 == b - 1)
												|| (k.sira1 == a + 1 && k.sira2 == b + 1)
												|| (k.sira1 == a - 1 && k.sira2 == b + 1) || (k.sira1 == a + 1)
												|| (k.sira1 == a - 1) || (k.sira2 == b + 1) || (k.sira2 == b - 1)) {
											kare[a][b].setIcon(kare_al[k.sira1][k.sira2]);
											kare_al[a][b] = kare_al[k.sira1][k.sira2];
											kare_al[k.sira1][k.sira2] = null;
											kare[k.sira1][k.sira2].setIcon(kare_al[k.sira1][k.sira2]);
											k.karsi = true;
											System.out.println(k.karsi);

										}

									}
								}
							}
							if (kare_al[a][b] == siyah_piyon.getImageIcon()
									|| kare_al[a][b] == siyah_kale1.getImageIcon()
									|| kare_al[a][b] == siyah_kale2.getImageIcon()
									|| kare_al[a][b] == siyah_at1.getImageIcon()
									|| kare_al[a][b] == siyah_at2.getImageIcon()
									|| kare_al[a][b] == siyah_filo1.getImageIcon()
									|| kare_al[a][b] == siyah_filo2.getImageIcon()
									|| kare_al[a][b] == siyah_vezir.getImageIcon()
									|| kare_al[a][b] == siyah_sah.getImageIcon()) {

								k.sira1 = a;
								k.sira2 = b;

							}
						}

					}

					private void print(String string) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						System.out.printf("%d,%d\t", getX(a), getY(b));

					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

				});

			} // içteki for sonu

		} // Dýþtaki for sonu

	}

	private Object getY(int b) {
		// TODO Auto-generated method stub
		return b;
	}

	private Object getX(int c) {
		// TODO Auto-generated method stub
		return c;
	}

}

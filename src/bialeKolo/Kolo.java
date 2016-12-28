package bialeKolo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

public class Kolo {
	private int x;
	private int y;
	private int x2;
	private int y2;
	private int r;
	private Color kolor = Color.white;
	private Random rnd;
	Integer licznik;
	
	public Kolo(Dimension d){
		rnd = new Random();
		r = 20 + rnd.nextInt(30);
		x = rnd.nextInt(d.width - 2*r);
		y = rnd.nextInt(d.height - 2*r);
		licznik = 0;
		x2 = (int)(x+0.4*r); //x + 12;
		y2 = (int)(y + 0.66*r);//y + 20;
	}
	
	public void rysuj(Graphics g){
		g.setColor(kolor);
		g.drawOval(x, y, r, r);
		g.drawString(Integer.toString(licznik), x2, y2);
	}	
	
	public void zwieksz(){
		licznik = licznik + 1;
	}

	public boolean zawiera(int x3, int y3) {
		double dist = (x3-x)*(x3-x)+(y3-y)*(y3-y);
		return dist <= r*r ;
	}

	public void zeruj() {
		licznik = 0;
	}
}

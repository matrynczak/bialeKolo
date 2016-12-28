package bialeKolo;

import java.applet.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Aplecik extends Applet {
//	Kolo kolko;
	private final int N = 4;
	private ArrayList<Kolo> kolko = new ArrayList();
	Random rnd = new Random();

	@Override
	public void init() {
		Dimension d = getSize();
		setSize(500,500);
		setBackground(Color.black);
		for (int i=0; i<N;i++){
			kolko.add(new Kolo(d));
		}
		
		addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1){
					for(Kolo k : kolko)
						if(k.zawiera(e.getX(), e.getY()))
							k.zwieksz();
					repaint();
				}
				if(e.getButton() == MouseEvent.BUTTON3){
					for(Kolo k : kolko)
						if(k.zawiera(e.getX(), e.getY()))
							k.zeruj();
					repaint();
				}
			}
			
		});
	}

	@Override
	public void paint(Graphics g) {
		for (Kolo k : kolko)
			k.rysuj(g);
	}
}

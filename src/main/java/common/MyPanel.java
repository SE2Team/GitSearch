package common;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel{

//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		g.setColor(Color.white);
//		g.fillRect(0, 0, this.getWidth(), this.getHeight());
//	}
	
	public MyPanel(int x,int y, int w,int h) {
		this();
		this.setBounds(x, y, w, h);
	}

	public MyPanel() {

	}
}

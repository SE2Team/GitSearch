package presentation.searchui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import presentation.common.MyColor;
import presentation.common.MyPanel;
import presentation.common.MyRecButton;

public class UserSortPanel extends MyPanel{

	private MyRecButton general,followers,numOfRep;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.gray);
		g.drawLine(0, 0, this.getWidth(), 0);
		g.drawLine(0, general.getHeight(), this.getWidth(), general.getHeight());
		g.drawLine(0, 0, 0, this.getHeight());
		g.drawLine(this.getWidth()-1, 0, this.getWidth()-1, this.getHeight());
		g.drawLine(0, this.getHeight()-1, this.getWidth()-1, this.getHeight()-1);
	}
	public UserSortPanel(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.setLayout(new FlowLayout(FlowLayout.LEFT,0,0 ));
		general = new MyRecButton("General",Color.WHITE);
		followers = new MyRecButton("Followers",MyColor.BUTTON_gray);
		numOfRep = new MyRecButton("NumOfRelatedRep",Color.WHITE);
		this.add(general);
		this.add(followers);
		this.add(numOfRep);
	}

}

package presentation.searchui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import presentation.common.MyColor;
import presentation.common.MyPanel;
import presentation.common.MyRecButton;

/***
 * 项目排序面板
 * @author Administrator
 *
 */

public class RepSortPanel extends MyPanel{
	
	private MyRecButton general,star,fork,contributor;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.gray);
		g.drawLine(0, 0, this.getWidth(), 0);
		g.drawLine(0, general.getHeight(), this.getWidth(), general.getHeight());
		g.drawLine(0, 0, 0, this.getHeight());
		g.drawLine(this.getWidth()-1, 0, this.getWidth()-1, this.getHeight());
		g.drawLine(0, this.getHeight()-1, this.getWidth()-1, this.getHeight()-1);
	}
	
	public RepSortPanel(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.setLayout(new FlowLayout(FlowLayout.LEFT,0,0 ));
		general = new MyRecButton("General",Color.WHITE);
		
		star = new MyRecButton("Star",MyColor.BUTTON_gray);
		fork = new MyRecButton("Fork",Color.WHITE);
		contributor = new MyRecButton("Contributor",MyColor.BUTTON_gray);
		this.add(general);
		this.add(star);
		this.add(fork);
		this.add(contributor);
	}

}

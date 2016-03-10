package presentation.searchui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JTable;

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
	private JTable sortTable;
	int L_x=0,L_y=0,width=150,height=30;
	int table_h=this.getHeight()-height-1,row_h=40;
	int row_num = table_h/row_h;
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.gray);
//		g.drawLine(0, 0, this.getWidth(), 0);
//		g.drawLine(0, general.getHeight(), this.getWidth(), general.getHeight());
		g.drawLine(0, 0, 0, this.getHeight()-1);
		g.drawLine(this.getWidth()-1, 0, this.getWidth()-1, this.getHeight()-1);
		g.drawLine(0, this.getHeight()-1, this.getWidth()-1, this.getHeight()-1);
	}
	
	public RepSortPanel(int x, int y, int w, int h) {
		super(x, y, w, h);
	//	this.setLayout(new FlowLayout(FlowLayout.LEFT,0,0 ));
		this.setLayout(null);
		general = new MyRecButton("General",Color.WHITE);
		general.setBounds(L_x,L_y,width,height);
		star = new MyRecButton("Star",MyColor.BUTTON_gray);
		star.setBounds(L_x+width,L_y,width,height);
		fork = new MyRecButton("Fork",Color.WHITE);
		fork.setBounds(L_x+2*width,L_y,width,height);
		contributor = new MyRecButton("Contributor",MyColor.BUTTON_gray);
		contributor.setBounds(L_x+3*width,L_y,width,height);
		
		sortTable = new JTable(row_num, 1);
		sortTable.setShowHorizontalLines(false);
		sortTable.setShowGrid(true);
		sortTable.setShowVerticalLines(false);
		sortTable.setBounds(L_x+1, L_y+height, this.getWidth()-2, table_h);
		sortTable.setRowHeight(row_h);
		this.add(general);
		this.add(star);
		this.add(fork);
		this.add(contributor);
		this.add(sortTable);
	}
	
	public JTable getTable(){
		return sortTable;
	}

}

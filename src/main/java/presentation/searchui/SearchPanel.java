package presentation.searchui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import common.MyButton;
import common.MyJTextField;
import common.MyLabel;
import common.MyPanel;

public class SearchPanel extends JPanel{

	private MyJTextField jtf_search;
	private MyButton userSearch,repSearch;
	private MyPanel jp_filtrate,jp_sort;
	private MyLabel jl_filtrate,jl_userSort,jl_repSort;
	
	int x=150,y=15,jtf_w=300,jb_w=100,h=35,jpFil_h=100,jpSort_h=300;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public SearchPanel() {
		
		this.setLayout(null);
		
		jtf_search = new MyJTextField(x, y, jtf_w, h);
		userSearch = new MyButton("搜索用户", x+jtf_w, y, jb_w, h);
		repSearch = new MyButton("搜索项目", x+jtf_w+jb_w, y, jb_w, h);

		jl_filtrate = new MyLabel("筛选条件", x-50, y+h+10, jb_w, h);
		jp_filtrate = new MyPanel(x,2*y+2*h,jtf_w+2*jb_w,jpFil_h);
		
		jl_userSort = new MyLabel("用户排序", x-50, 3*y+2*h+jpFil_h, jb_w, h);
		jl_repSort = new MyLabel("项目排序", x-50, 3*y+2*h+jpFil_h, jb_w, h);
		jp_sort = new MyPanel(x, 4*y+3*h+jpFil_h, jtf_w+2*jb_w,jpSort_h);
		
		this.add(jtf_search);
		this.add(userSearch);
		this.add(repSearch);
		this.add(jl_filtrate);
		this.add(jp_filtrate);
		this.add(jl_userSort);
		this.add(jp_sort);
	}

}

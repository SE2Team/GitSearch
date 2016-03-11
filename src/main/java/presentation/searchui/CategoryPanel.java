package presentation.searchui;

import java.awt.Color;
import java.awt.FlowLayout;

import presentation.common.MyButton;
import presentation.common.MyFont;
import presentation.common.MyLabel;
import presentation.common.MyPanel;

/***
 * 项目筛选面板上的category面板
 * @author Administrator
 *
 */
public class CategoryPanel extends MyPanel{

	private MyLabel jl_category;
	private MyButton jb1,jb2,jb3,jb4,jb5,jb6,jb7;
	
	public CategoryPanel(int x, int y, int w, int h) {
		super(x, y, w, h);
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT,15,5);
		this.setLayout(flow);
		this.setBackground(Color.WHITE);
		
		jl_category = new MyLabel("Categoty");
		jl_category.setFont(MyFont.Calibri2);
		jb1 = new MyButton("ActiveRecord");
		jb2 = new MyButton("App");
		jb3 = new MyButton("CMS");
		jb4 = new MyButton("JSON");
		jb5 = new MyButton("Mac");
		jb6 = new MyButton("Linux");
		jb7 = new MyButton("API");
		this.add(jl_category);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		this.add(jb7);
	}

}

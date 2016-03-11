package presentation.searchui;

import java.awt.Color;
import java.awt.FlowLayout;

import presentation.common.MyButton;
import presentation.common.MyFont;
import presentation.common.MyLabel;
import presentation.common.MyPanel;


public class CreateTimePanel extends MyPanel{

	private MyLabel jl_createTime;
	private MyButton jb1,jb2,jb3,jb4,jb5,jb6;
	
	public CreateTimePanel(int x, int y, int w, int h) {
		
		super(x, y, w, h);
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT,15,5);
		this.setLayout(flow);
		this.setBackground(Color.WHITE);

		jl_createTime = new MyLabel("Creat Time ");
		jl_createTime.setFont(MyFont.Calibri2);
		jb1 = new MyButton("all");
		jb2 = new MyButton("2007");
		jb3 = new MyButton("2008");
		jb4 = new MyButton("2009");
		jb5 = new MyButton("2010");
		jb6 = new MyButton("2011");
		
		this.add(jl_createTime);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
	}

}

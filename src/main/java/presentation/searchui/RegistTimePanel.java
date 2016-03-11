package presentation.searchui;

import java.awt.FlowLayout;

import presentation.common.MyButton;
import presentation.common.MyLabel;
import presentation.common.MyPanel;

public class RegistTimePanel extends MyPanel{

	private MyLabel jl_registTime;
	private MyButton jb1,jb2,jb3,jb4,jb5,jb6;
	
	public RegistTimePanel(int x, int y, int w, int h) {
		super(x, y, w, h);
		init();
	}
	
	public void init(){
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT,15,5);
		this.setLayout(flow);
		
		jl_registTime = new MyLabel("注册时间");
		jb1 = new MyButton("all");
		jb2 = new MyButton("2007");
		jb3 = new MyButton("2008");
		jb4 = new MyButton("2009");
		jb5 = new MyButton("2010");
		jb6 = new MyButton("2011");
		
		this.add(jl_registTime);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		this.repaint();
//		System.out.println("run");
	}
}

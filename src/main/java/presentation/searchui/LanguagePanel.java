package presentation.searchui;

import java.awt.Color;
import java.awt.FlowLayout;

import presentation.common.MyButton;
import presentation.common.MyFont;
import presentation.common.MyLabel;
import presentation.common.MyPanel;

/***
 * 项目筛选面板上的language面板
 * @author Administrator
 *
 */
public class LanguagePanel extends MyPanel{

	private MyLabel jl_language;
	private MyButton jb1,jb2,jb3,jb4,jb5,jb6;
	
	public LanguagePanel(int x, int y, int w, int h) {
		super(x, y, w, h);
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT,15,5);
		this.setLayout(flow);
		jl_language = new MyLabel("Language ");
		jl_language.setFont(MyFont.Calibri2);
		jb1 = new MyButton("all");
		jb2 = new MyButton("Java");
		jb3 = new MyButton("C++");
		jb4 = new MyButton("C");
		jb5 = new MyButton("Python");
		jb6 = new MyButton("Ruby");
		
		this.setBackground(Color.WHITE);

		this.add(jl_language);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
	}

}

package presentation.searchui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Util.SearchType;

public class SearchFrame extends JFrame{
	static JFrame j;
	static SearchPanel s_panel;
	
	public SearchFrame(SearchType type) {
		j=this;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置默认关闭属性
		this.setSize(800, 640);// 设置窗体大小
		this.setResizable(false);// 不允许用户改变窗体大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width - this.getWidth()) / 2;
		int y = (screen.height - this.getHeight()) / 2;
		this.setLocation(x, y - 20);	
		
		s_panel = new SearchPanel(type);
		this.add(s_panel);
		this.setVisible(true);
	}
	
	public static SearchPanel getPanel(){
		return s_panel;
	}
	public static JFrame getSearch(){
		return j;
	}

}

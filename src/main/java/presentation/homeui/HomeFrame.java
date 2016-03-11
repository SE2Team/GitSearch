package presentation.homeui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Util.SearchType;
import presentation.searchui.SearchFrame;
import presentation.searchui.SearchPanel;

public class HomeFrame extends JFrame {
	private HomePanel homePanel;
	public HomeFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置默认关闭属性
		this.setSize(680, 460);// 设置窗体大小
		this.setResizable(false);// 不允许用户改变窗体大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width - this.getWidth()) / 2;
		int y = (screen.height - this.getHeight()) / 2;
		this.setLocation(x, y - 20);
		
		homePanel = new HomePanel();
		
		//两个搜索按钮的监听
		homePanel.getSearchRep().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				SearchFrame sf = new SearchFrame(SearchType.SearchRep);
				sf.getPanel().performRepSearch();
			}
		});
		homePanel.getSearchUser().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				SearchFrame sf = new SearchFrame(SearchType.SearchUser);
				sf.getPanel().performUserSearch();
//				new SearchFrame(SearchType.SearchUser);
			}
		});
		this.add(homePanel);
		
		this.setVisible(true);
	}
	
}

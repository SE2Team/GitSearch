package presentation.userCheckui;

import javax.swing.JPanel;

import common.MyPanel;

public class userCheckPanel extends JPanel{

	private MyPanel jp_basicInfo;
	
	int x=20,y=20,basic_w=250,basic_h=350;
	public userCheckPanel() {
		
		this.setLayout(null);
		
		jp_basicInfo = new MyPanel(x, y, basic_w, basic_h);
		
		this.add(jp_basicInfo);
	}

}

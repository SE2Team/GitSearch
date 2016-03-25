package presentation.common;

import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel{

	public MyLabel(String text){
		this.setFont(MyFont.songti16);
		this.setText(text);
	}
	
	public MyLabel(String text,int x,int y, int w,int h) {
		this.setFont(MyFont.kaiti20);
		this.setText(text);
		this.setBounds(x, y, w, h);
	}

}

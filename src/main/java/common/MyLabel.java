package common;

import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel{

	public MyLabel(String text,int x,int y, int w,int h) {
		this.setFont(new Font("楷体",Font.PLAIN, 20));
		this.setText(text);
		this.setBounds(x, y, w, h);
	}

}

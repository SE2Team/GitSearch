package common;

import java.awt.Font;

import javax.swing.JButton;

public class MyButton extends JButton{

	public MyButton(String text, int x,int y, int w,int h) {
		this.setFont(new Font("宋体",Font.PLAIN, 16));
		this.setText(text);
		this.setBounds(x, y, w, h);
		this.setFocusPainted(false);
	}

}

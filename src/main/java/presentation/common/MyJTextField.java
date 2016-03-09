package presentation.common;

import java.awt.Font;

import javax.swing.JTextField;

public class MyJTextField extends JTextField{

	public MyJTextField(int x,int y,int w,int h) {
		this.setFont(new Font("宋体",Font.PLAIN, 16));
		this.setBounds(x, y, w, h);
	}

}

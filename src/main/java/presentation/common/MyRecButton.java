package presentation.common;

import java.awt.Color;

import javax.swing.JButton;

public class MyRecButton extends JButton{

	public MyRecButton(String text,Color color) {
		this.setFont(MyFont.songti16);
		this.setText(text);
		
		this.setBackground(color);
	//	this.setBorderPainted(false);
	//	this.setContentAreaFilled(false);
		this.setFocusPainted(false);
	}

}

package presentation.repoCheckui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class repCheckFrame extends JFrame{

	public repCheckFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置默认关闭属性
		this.setSize(450, 650);// 设置窗体大小
		this.setResizable(false);// 不允许用户改变窗体大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width - this.getWidth()) / 2;
		int y = (screen.height - this.getHeight()) / 2;
		this.setLocation(x, y - 20);	
		
		this.add(new repCheckPanel());
		this.setVisible(true);
	}

}

package presentation.homeui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.common.MyButton;
import presentation.common.MyJTextField;

public class HomePanel extends JPanel{

	private MyButton searchUser,searchRep;
	private MyJTextField jtf_search;
	
	int x=85,y=200,jb_w = 100,h=35,jtf_w=300;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Image logo = new ImageIcon("Images/Logo.jpg").getImage();
		g.drawImage(logo, 250, 120, 200,50,this);
	}
	
	public HomePanel() {
		this.setLayout(null);
		jtf_search = new MyJTextField(x, y, jtf_w, h);

		searchRep = new MyButton("搜索项目");
		searchRep.setBounds(x+jtf_w+jb_w, y, jb_w, h);
		searchRep.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				performRep();
			}
		});
		searchUser = new MyButton("搜索用户");
		searchUser.setBounds(x+jtf_w,y,jb_w,h);
		repaint();
		this.add(jtf_search);
		this.add(searchUser);
		this.add(searchRep);
		this.setBackground(Color.WHITE);
	}

//	public MyButton getSearchRep(){
//		
//	}
	/**
	 * 搜索项目按钮的监听实现
	 */
	public void performRep(){
		
	}
}

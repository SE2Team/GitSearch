package presentation.homeui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.common.MyButton;
import presentation.common.MyFont;
import presentation.common.MyJTextField;
import presentation.common.MyLabel;

public class HomePanel extends JPanel{

	private MyButton searchUser,searchRep;
	private MyJTextField jtf_search;
	private JLabel tip,tip1;
	
	int x=85,y=200,jb_w = 100,h=35,jtf_w=300;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Image logo = new ImageIcon("Images/Logo.jpg").getImage();
		g.drawImage(logo, 250, 120, 200,50,this);
	}
	
	public HomePanel() {
		this.setLayout(null);
		tip = new JLabel("Tip:",JLabel.CENTER);
		tip.setFont(MyFont.Comic);
		tip.setBounds(160,320,50,40);
		
		tip1 = new JLabel("直接点击按钮进入详情界面~",JLabel.CENTER);
		tip1.setFont(MyFont.kaiti20);
		tip1.setBounds(0,320,680,40);
		jtf_search = new MyJTextField(x, y, jtf_w, h);

		searchRep = new MyButton("搜索项目");
		searchRep.setBounds(x+jtf_w+jb_w, y, jb_w, h);
		
		searchUser = new MyButton("搜索用户");
		searchUser.setBounds(x+jtf_w,y,jb_w,h);
		repaint();
		this.add(jtf_search);
		this.add(searchUser);
		this.add(searchRep);
		this.add(tip);
		this.add(tip1);
		this.setBackground(Color.WHITE);
	}

	/***
	 * 获取搜索项目按钮
	 * @return
	 */
	public MyButton getSearchRep(){
		return searchRep;
	}
	
	/***
	 * 获取搜索用户按钮
	 * @return
	 */
	public MyButton getSearchUser(){
		return searchUser;
	}
	
}

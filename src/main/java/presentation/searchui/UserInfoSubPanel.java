package presentation.searchui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.MyFont;
import presentation.repoCheckui.RepCheckFrame;
import presentation.userCheckui.UserCheckFrame;
import vo.UserVO;

public class UserInfoSubPanel extends JPanel{
	
	private JLabel jl_UserName;
	public UserInfoSubPanel(final UserVO uvo,int w,int h) {
		this.setLayout(null);
		this.setSize(w,h);
		int x=105,y=h/3,jl_w=50,jl_h=30,addx=5,addy=20;
		
		jl_UserName = new JLabel(uvo.getName());
		jl_UserName.setFont(MyFont.Arial20);
		jl_UserName.setBounds(x, y, w, jl_h);
		jl_UserName.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				new UserCheckFrame(uvo);
			}
		});
		
		this.add(jl_UserName);
	}

}

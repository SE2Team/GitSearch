package presentation.searchui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.MyFont;
import vo.UserVO;

public class UserInfoSubPanel extends JPanel{
	
	private JLabel jl_UserName;
	public UserInfoSubPanel(UserVO uvo,int w,int h) {
		this.setLayout(null);
		this.setSize(w,h);
		int x=105,y=h/3,jl_w=50,jl_h=30,addx=5,addy=20;
		
		jl_UserName = new JLabel(uvo.getName());
		jl_UserName.setFont(MyFont.Arial20);
		jl_UserName.setBounds(x, y, w, jl_h);
		
		this.add(jl_UserName);
	}

}

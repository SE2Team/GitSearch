package presentation.searchui;

import presentation.common.MyColor;
import presentation.common.MyFont;
import presentation.userCheckui.UserCheckFrame;
import vo.UserVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserInfoSubPanel extends JPanel{
	
	private JLabel jl_UserName;
	public UserInfoSubPanel(final UserVO uvo,int w,int h) {
		this.setLayout(null);
		this.setBackground(Color.WHITE);;
		this.setSize(w,h);
		int x=105,y=h/8,jl_w=50,jl_h=30,addx=5,addy=20;
		
		String name;
		if(uvo.getLogin().equals(""))
			name = "Unknown";
		else
			name = uvo.getLogin();
		
		jl_UserName = new JLabel(name);
		jl_UserName.setFont(MyFont.Comic2);
		jl_UserName.setForeground(MyColor.Info_COLOR);
		jl_UserName.setBounds(5, y, w, jl_h);
		jl_UserName.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				jl_UserName.setCursor(new Cursor(Cursor.HAND_CURSOR));
				jl_UserName.setForeground(MyColor.Info_COLOR2);
			}
			public void mouseExited(MouseEvent e){
				jl_UserName.setForeground(MyColor.Info_COLOR);
			}
			public void mousePressed(MouseEvent e){
				new UserCheckFrame(uvo);
			}
		});
        this.setBorder(BorderFactory.createEtchedBorder());

		this.add(jl_UserName);
	}

}

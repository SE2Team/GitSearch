package presentation.userCheckui;

import presentation.common.MyFont;
import presentation.common.MyPanel;
import vo.UserVO;

import javax.swing.*;
import java.awt.*;

/**
 * Created by moeyui on 2016/3/8 0008.
 */
public class BasicInfoPanel extends MyPanel {
	int bx=0,by=160,width=200,height=20,addy=25;
	JLabel basicInfoLabel;
	JLabel photoLabel;
    JLabel nameLabel;
    JLabel loginLabel;
//    JLabel desLabel;//description label
    JLabel regTimeLabel;//注册时间
    JLabel companyLabel;
    JLabel emailLabel;
    JLabel followers;
    JLabel following;
    UserVO vo;
    public BasicInfoPanel(int x, int y, int w, int h, UserVO vo) {
        super(x, y, w, h);
        this.vo=vo;
        init();
    }

    public BasicInfoPanel() {
    	super();
        init();
    }

    private void init(){
    	this.setLayout(null);
    	String name;
        String login;
		if(vo.getName().equals(""))
			name = "Unknown";
		else
			name = vo.getName();

        if(vo.getLogin().equals(""))
            login = "Unknown";
        else
            login = vo.getLogin();

    	basicInfoLabel = new JLabel("Basic Information",JLabel.CENTER);
    	basicInfoLabel.setFont(MyFont.Comic);
    	basicInfoLabel.setBounds(bx, 15, width, height);
    	photoLabel = new JLabel(new ImageIcon(this.getClass().getResource("/Images/头像.JPG")),JLabel.CENTER);
    	photoLabel.setBounds(50, 50, 100, 100);
        nameLabel=new JLabel(name,JLabel.CENTER);
        nameLabel.setFont(MyFont.Calibri2);
        nameLabel.setBounds(bx, by+5, width, height);
//        desLabel=new JLabel();

        loginLabel = new JLabel(login,JLabel.CENTER);
        loginLabel.setFont(MyFont.Calibri);
        loginLabel.setForeground(Color.gray);
        loginLabel.setBounds(bx, by+height, width, height);

        followers=new JLabel("Following "+vo.getFollowing(),JLabel.CENTER);
        followers.setFont(MyFont.Calibri);
        followers.setBounds(bx, by+height+addy-5, width, height);
        
        following=new JLabel("Followers "+vo.getFollowers(),JLabel.CENTER);
        following.setFont(MyFont.Calibri);
        following.setBounds(bx, by+2*height+18, width, height);
        
//        followers.setText();
//        following.setText();
        
//        regTimeLabel=new JLabel("Joined on "+vo.getCreated_at().substring(0, 10),JLabel.CENTER);
//        regTimeLabel.setFont(MyFont.Calibri);
//        regTimeLabel.setBounds(bx, by+3*height+addy, width, height);
       
        emailLabel=new JLabel(vo.getEmail(),JLabel.CENTER);
        emailLabel.setFont(MyFont.Calibri);
        emailLabel.setBounds(bx, by+4*height+addy+10, width, height);
        
        String compony;
        if(vo.getCompany().equals(" "))
        	compony="Unknown";
        else
        	compony = vo.getCompany();
        companyLabel=new JLabel("Company:"+compony,JLabel.CENTER);
        companyLabel.setFont(MyFont.Calibri);
        companyLabel.setBounds(bx, by+5*height+2*addy, width, height);
        

        this.add(basicInfoLabel);
        this.add(photoLabel);
        this.add(nameLabel);
        this.add(loginLabel);
        this.add(followers);
        this.add(following);
        this.add(companyLabel);
        this.add(regTimeLabel);
        this.add(emailLabel);

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createEtchedBorder());

    }

}

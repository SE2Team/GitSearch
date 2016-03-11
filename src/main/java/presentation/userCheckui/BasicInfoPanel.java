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
    	basicInfoLabel = new JLabel("Basic Infomation",JLabel.CENTER);
    	basicInfoLabel.setFont(MyFont.Comic);
    	basicInfoLabel.setBounds(bx, 15, width, height);
    	photoLabel = new JLabel(new ImageIcon("Images/头像.JPG"),JLabel.CENTER);
    	photoLabel.setBounds(50, 50, 100, 100);
//    	photoLabel = new JLabel("a");
        nameLabel=new JLabel("John",JLabel.CENTER);
        nameLabel.setFont(MyFont.Arial22);
        nameLabel.setBounds(bx, by+5, width, height);
//        desLabel=new JLabel(); 
        
        followers=new JLabel("Following "+vo.getFollowing(),JLabel.CENTER);
        followers.setFont(MyFont.Shruti18);
        followers.setBounds(bx, by+height+addy-5, width, height);
        
        following=new JLabel("Followers "+vo.getFollowers(),JLabel.CENTER);
        following.setFont(MyFont.Shruti18);
        following.setBounds(bx, by+2*height+15, width, height);
        
//        followers.setText();
//        following.setText();
        
        regTimeLabel=new JLabel("Joined on 2011/11/11"+vo.getCreated_at(),JLabel.CENTER);
        regTimeLabel.setFont(MyFont.Shruti18);
        regTimeLabel.setBounds(bx, by+3*height+addy, width, height);
       
        emailLabel=new JLabel("jakewharton@gmail.com"+vo.getEmail(),JLabel.CENTER);
        emailLabel.setFont(MyFont.Shruti18);
        emailLabel.setBounds(bx, by+4*height+addy+10, width, height);
        
        companyLabel=new JLabel("Company:"+vo.getCompany(),JLabel.CENTER);
        companyLabel.setFont(MyFont.Shruti20);
        companyLabel.setBounds(bx, by+5*height+2*addy, width, height);
        
        
//        regTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        nameLabel.setText();
//        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        desLabel.setText("user info here!");
//        desLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        companyLabel.setText(vo.getCompany());
//        companyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
//        emailLabel.setText();

//        regTimeLabel.setText("注册时间：2012-2-22");

        this.add(basicInfoLabel);
        this.add(photoLabel);
        this.add(nameLabel);
//        this.add(desLabel);
        this.add(followers);
        this.add(following);
        this.add(companyLabel);
        this.add(regTimeLabel);
        this.add(emailLabel);

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createEtchedBorder());

    }

}

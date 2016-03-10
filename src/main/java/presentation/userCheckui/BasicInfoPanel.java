package presentation.userCheckui;

import presentation.common.MyPanel;
import vo.UserVO;

import javax.swing.*;
import java.awt.*;

/**
 * Created by moeyui on 2016/3/8 0008.
 */
public class BasicInfoPanel extends MyPanel {
    JLabel nameLabel;
    JLabel desLabel;//description label
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
        nameLabel=new JLabel();
        desLabel=new JLabel();
        regTimeLabel=new JLabel();
        companyLabel=new JLabel();
        emailLabel=new JLabel();
        following=new JLabel();
        followers=new JLabel();
//        regTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setText(vo.getName());
//        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        desLabel.setText("user info here!");
//        desLabel.setHorizontalAlignment(SwingConstants.CENTER);
        companyLabel.setText(vo.getCompany());
//        companyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        followers.setText("Followers:"+vo.getFollowers());
        following.setText("Following:"+vo.getFollowing());
        emailLabel.setText("Email:"+vo.getEmail());

        regTimeLabel.setText("注册时间：2012-2-22");
        GridLayout layout=new GridLayout(8,1);
        this.setLayout(layout);

        this.add(nameLabel);
        this.add(desLabel);
        this.add(followers);
        this.add(following);
        this.add(companyLabel);
        this.add(regTimeLabel);
        this.add(emailLabel);


        this.setBorder(BorderFactory.createEtchedBorder());

    }

}

package presentation.repoCheckui;

import presentation.common.MyFont;
import presentation.common.MyPanel;
import vo.RepositoryVO;

import javax.swing.*;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/9 0009.
 */
public class RepoInfo extends MyPanel{

    RepositoryVO vo;
    JLabel title;
    JLabel stars;
    JLabel forks;
    JLabel subscribers;
    JLabel contributors;
    JLabel stars_num,forks_num,subscribers_num,contributors_num;
    ArrayList<JLabel> boardLabel1;
    ArrayList<JLabel> boardLabel2;

    int ax,ay;
    int WIDTH,HEIGHT;

    public RepoInfo(int x, int y, int w, int h,RepositoryVO vo) {
        super(x, y, w, h);
        WIDTH=w;
        HEIGHT=h;
        this.vo=vo;
        init();
    }

    void init(){

    	this.setBackground(Color.white);
        this.setLayout(null);

        title=new JLabel("Repository name here");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(MyFont.Arial22);
        title.setBounds(0,10,WIDTH,30);


//        title.setBounds(WIDTH/2-100,0,200,50);
        this.add(title);
        initBoard();

    }

    void initBoard(){
    	int bx=80,by=40,jl_w=45,jl_h=30,addx=3,addy=20;
        stars=new JLabel("stars",JLabel.CENTER);
        stars.setFont(MyFont.weiruan);
        stars.setBounds(bx,by,jl_w,jl_h);
        
        forks=new JLabel("forks",JLabel.CENTER);
        forks.setFont(MyFont.weiruan);
        forks.setBounds(bx+jl_w+addx,by,jl_w,jl_h);
        
        subscribers=new JLabel("subscribers",JLabel.CENTER);
        subscribers.setFont(MyFont.weiruan);
        subscribers.setBounds(bx+2*jl_w+2*addx,by,2*jl_w,jl_h);
        
        contributors=new JLabel("contributors",JLabel.CENTER);
        contributors.setFont(MyFont.weiruan);
        contributors.setBounds(bx+4*jl_w+3*addx,by,2*jl_w+15,jl_h);
        
       
        stars_num=new JLabel("0",JLabel.CENTER);
        stars_num.setFont(MyFont.weiruan);
        stars_num.setBounds(bx,by+addy,jl_w,jl_h);
        
        forks_num=new JLabel("0",JLabel.CENTER);
        forks_num.setFont(MyFont.weiruan);
        forks_num.setBounds(bx+jl_w+addx,by+addy,jl_w,jl_h);
        
        subscribers_num=new JLabel("0",JLabel.CENTER);
        subscribers_num.setFont(MyFont.weiruan);
        subscribers_num.setBounds(bx+2*jl_w+2*addx,by+addy,2*jl_w,jl_h);
        
        contributors_num=new JLabel("0",JLabel.CENTER);
        contributors_num.setFont(MyFont.weiruan);
        contributors_num.setBounds(bx+4*jl_w+3*addx,by+addy,2*jl_w+15,jl_h);
        
//        boardLabel2=new ArrayList<JLabel>();
//        boardLabel2.add(stars_num);
//        boardLabel2.add(forks_num);
//        boardLabel2.add(subscribers_num);
//        boardLabel2.add(contributors_num);
        
        this.add(stars);
        this.add(forks);
        this.add(subscribers);
        this.add(contributors);
        this.add(stars_num);
        this.add(forks_num);
        this.add(subscribers_num);
        this.add(contributors_num);
        this.setBorder(BorderFactory.createEtchedBorder());
    }
    

}

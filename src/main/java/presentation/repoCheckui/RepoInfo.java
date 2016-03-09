package presentation.repoCheckui;

import common.MyPanel;
import vo.RepositoryVO;

import javax.swing.*;
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


        this.setLayout(null);

        title=new JLabel("Repository name here");
        title.setHorizontalAlignment(SwingConstants.CENTER);



        title.setBounds(0,0,WIDTH,50);


//        title.setBounds(WIDTH/2-100,0,200,50);
        this.add(title);
        initBoard();

    }

    void initBoard(){
        stars=new JLabel("stars");
        forks=new JLabel("forks");
        subscribers=new JLabel("subscribers");
        contributors=new JLabel("contributors");
        boardLabel1=new ArrayList<JLabel>();
        boardLabel1.add(stars);
        boardLabel1.add(forks);
        boardLabel1.add(subscribers);
        boardLabel1.add(contributors);

        int bx=0;
        int by=50;
        for(int i=0;i<boardLabel1.size();i++){
            boardLabel1.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            boardLabel1.get(i).setBounds(i*WIDTH/4,by,WIDTH/4,50);
        }
        this.add(stars);
        this.add(forks);
        this.add(subscribers);
        this.add(contributors);

        stars_num=new JLabel("0");
        forks_num=new JLabel("0");
        subscribers_num=new JLabel("0");
        contributors_num=new JLabel("0");
        boardLabel2=new ArrayList<JLabel>();
        boardLabel2.add(stars_num);
        boardLabel2.add(forks_num);
        boardLabel2.add(subscribers_num);
        boardLabel2.add(contributors_num);

        for(int j=0;j<boardLabel2.size();j++){
            boardLabel2.get(j).setHorizontalAlignment(SwingConstants.CENTER);
            boardLabel2.get(j).setBounds(j*WIDTH/4,by+20,WIDTH/4,50);
            this.add(boardLabel2.get(j));
        }

    }
    class borad extends MyPanel{
        JLabel stars;
        public borad(int x, int y, int w, int h) {
            super(x, y, w, h);
        }

        public borad() {

        }
        void innerInit(){

        }
    }

}

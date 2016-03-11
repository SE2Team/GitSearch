package presentation.userCheckui;

import presentation.common.MyFont;
import presentation.common.MyPanel;
import vo.RepositoryVO;
import vo.UserVO;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/9 0009.
 */
public class UserRepo extends MyPanel{
    JLabel title;
    ArrayList<JLabel> repos;
    JLabel more;
    UserVO vo;

    public UserRepo(int x, int y, int w, int h, UserVO vo) {
        super(x, y, w, h);
        this.vo=vo;
        init();
    }

    public UserRepo() {
        init();
    }

    void init(){
        this.setLayout(new GridLayout(7,1));


        this.setAlignmentY(50);
        more=new JLabel("more...");
        title=new JLabel("Owning Repositoty");
        title.setFont(MyFont.Comic2);

        repos =new ArrayList<JLabel>();
        this.add(title);
        //

        //

        //根据vo的内容来决定显示多少个repo，最多显示5个
//<<<<<<< HEAD
//        for(RepositoryVO rvo:vo.getRepos()){
//            repos.add(new JLabel(rvo.getName()));
//            System.out.println(rvo.getName());
//            if (repos.size()>=5){
//                this.add(more);
//                break;
//            }
//        }
//=======
//        for(RepositoryVO rvo:vo.getRepos()){
//            repos.add(new JLabel(rvo.getName()));
//            System.out.println(rvo.getName());
//            if (repos.size()>=5){
//                this.add(more);
//                break;
//            }
//        }


        for(JLabel jLabel:repos){
            this.add(jLabel);
        }

        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createEtchedBorder());

    }

    public void setVo(UserVO vo) {
        this.vo = vo;
    }
}

package presentation.repoCheckui;

import presentation.common.MyPanel;
import vo.UserVO;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/9 0009.
 */
public class Contributors extends MyPanel{
    int WIDTH,HEIGHT;
    ArrayList<UserVO> vos;
    JLabel title,more;
    ArrayList<JLabel> jLabels=new ArrayList<JLabel>();
    int marX=10;
    public Contributors(int x, int y, int w, int h, ArrayList<UserVO> vos) {
        super(x, y, w, h);
        this.vos=vos;
        WIDTH=w;
        HEIGHT=h;
        init();
    }

    private void init() {
        this.setLayout(null);
        title=new JLabel("Contributors:");
        title.setBounds(marX,0,WIDTH,20);
        more=new JLabel("More...");
        more.setBounds(marX,5*20,WIDTH,20);
        int count=0;//不能显示超过5个
        for(UserVO vo:vos){
            jLabels.add(new JLabel(vo.getName()));
            if(jLabels.size()>=5){
                break;
            }
        }
        for(int i=0;i<jLabels.size();i++){
            jLabels.get(i).setBounds(marX,20*(i+1),WIDTH,20);
            this.add(jLabels.get(i));
            if(i>=5){
                this.add(more);
            }
        }
    }
}

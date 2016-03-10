package presentation.userCheckui;

import presentation.common.MyPanel;
import vo.RepositoryVO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/9 0009.
 */
public class ContributeRepo extends MyPanel{
    JLabel title;
    JLabel more;
    ArrayList<RepositoryVO> array=new ArrayList<RepositoryVO>();

    public ContributeRepo(int x, int y, int w, int h, ArrayList<RepositoryVO> array) {
        super(x, y, w, h);
        this.array=array;
        init();
    }

    public ContributeRepo() {
        super();
        init();
    }

    private void init(){
        title=new JLabel("Contribute Repository:");
        more=new JLabel("More...");
        this.setLayout(new GridLayout(7,1));

        this.add(title);

        int count=0;
        for(RepositoryVO vo:array){
            this.add(new JLabel(vo.getName()));
            count++;
            if(count>=5){
                this.add(more);
                break;
            }
        }


    }

}

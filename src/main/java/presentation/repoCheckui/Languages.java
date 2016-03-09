package presentation.repoCheckui;

import common.MyPanel;
import vo.RepositoryVO;

import javax.swing.*;
import java.awt.*;

/**
 * Created by moeyui on 2016/3/9 0009.
 */
public class Languages extends MyPanel{
    RepositoryVO vo;
    JLabel title,mainLang;
    int WIDTH,HEIGHT;
    int marX=10;

    public Languages(int x, int y, int w, int h, RepositoryVO vo) {
        super(x, y, w, h);
        WIDTH=w;
        HEIGHT=h;
        this.vo=vo;
        init();
    }

    private void init() {
//        this.setBackground(Color.cyan);
        this.setLayout(null);
        title=new JLabel("Language static");
        title.setBounds(marX,0,WIDTH,20);
        mainLang=new JLabel("Main Language:"+vo.getLanguage());
        mainLang.setBounds(marX,50,WIDTH,20);
        this.add(title);
        this.add(mainLang);
    }
}

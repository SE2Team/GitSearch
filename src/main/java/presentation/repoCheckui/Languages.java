package presentation.repoCheckui;

import presentation.common.MyFont;
import presentation.common.MyPanel;
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
        this.setBackground(Color.white);
        this.setLayout(null);
        title=new JLabel("Language static");
        title.setFont(MyFont.Comic2);
        title.setBounds(marX,5,WIDTH,30);
        
        mainLang=new JLabel("Main Language:"+vo.getLanguage());
        mainLang.setFont(MyFont.Calibri2);
        mainLang.setBounds(30,50,WIDTH,20);
        
        
        this.add(title);
        this.add(mainLang);
        this.setBorder(BorderFactory.createEtchedBorder());

    }
}

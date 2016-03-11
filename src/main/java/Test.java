import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import presentation.homeui.HomeFrame;
import presentation.repoCheckui.RepCheckFrame;
import presentation.searchui.RepInfoSubPanel;
import presentation.userCheckui.UserCheckFrame;

import javax.swing.*;

/**
 * Created by moeyui on 2016/3/1 0001.
 */

public class Test extends JFrame{
//	public Test(){
//		this.setSize(430, 100);
//		this.add(new RepInfoSubPanel(null, 400, 60));
//		this.setVisible(true);
//	}
    public static void main(String[] args) {
//    	new SearchFrame();
        new HomeFrame();

//        try {
//            UIManager.setLookAndFeel(new WindowsLookAndFeel());
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
//        new RepCheckFrame();
//        new Test();

        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
//        new RepCheckFrame();
    }
}

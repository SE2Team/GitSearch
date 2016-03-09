import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import presentation.repoCheckui.RepCheckFrame;
import presentation.userCheckui.UserCheckFrame;

import javax.swing.*;

/**
 * Created by moeyui on 2016/3/1 0001.
 */
public class Test {
    public static void main(String[] args) {
//    	new SearchFrame();
//        new HomeFrame();
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new UserCheckFrame();
    }
}

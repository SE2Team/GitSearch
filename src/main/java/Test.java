import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
import presentation.homeui.HomeFrame;
>>>>>>> e88f5669b851aaefa624d09113f26340c244a214
>>>>>>> dedf045e1437715347a0a50de993be571c0da982

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
<<<<<<< HEAD
//        new HomeFrame();
=======
<<<<<<< HEAD
//        new HomeFrame();
=======
        Test t=new Test();
//        System.out.println(t.getClass().getResource(""));
        new HomeFrame();
>>>>>>> e88f5669b851aaefa624d09113f26340c244a214

>>>>>>> dedf045e1437715347a0a50de993be571c0da982

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
//        System.out.println((int)19/8);
        System.out.println("i n".replaceAll(" ",""));
    }
}

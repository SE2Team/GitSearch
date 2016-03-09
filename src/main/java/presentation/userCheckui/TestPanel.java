package presentation.userCheckui;

import javax.swing.*;

/**
 * Created by moeyui on 2016/3/8 0008.
 */
public class TestPanel {
    public JPanel getPanel1() {
        return panel1;
    }

    private JPanel panel1;
    private JPanel icon;
    private JLabel info;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TestPanel");
        frame.setContentPane(new TestPanel().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public void setData(UserInfoPanel data) {
    }

    public void getData(UserInfoPanel data) {
    }

    public boolean isModified(UserInfoPanel data) {
        return false;
    }
}

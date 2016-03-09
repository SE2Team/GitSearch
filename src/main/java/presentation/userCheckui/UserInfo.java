package presentation.userCheckui;

import javax.swing.*;

/**
 * Created by moeyui on 2016/3/8 0008.
 */
public class UserInfo {
    private JPanel panel1;
    private JPanel left;
    private JPanel repository;
    private JPanel related;

    public UserInfo() {
        super();

        System.out.println("dfdfdf");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("UserInfo");
        frame.setContentPane(new UserInfo().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        left=new TestPanel().getPanel1();
    }

    public JPanel getPanel1() {
        return panel1;
    }
}

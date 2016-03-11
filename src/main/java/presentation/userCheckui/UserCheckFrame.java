package presentation.userCheckui;

import vo.RepositoryVO;
import vo.UserVO;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class UserCheckFrame extends JFrame{
	BasicInfoPanel basicInfoPanel;
	UserRepo userRepo;
    ContributeRepo crepo;
	int ax,ay,z,a;
	int width=600,height=400,h=370;
    UserVO vo;

	public UserCheckFrame(UserVO vo) {
        this.vo=vo;

		ax=0;
		ay=0;

//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置默认关闭属性
		this.setSize(width, height);// 设置窗体大小
		this.setResizable(false);// 不允许用户改变窗体大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width - this.getWidth()) / 2;
		int y = (screen.height - this.getHeight()) / 2;
		this.setLocation(x, y - 20);
        this.setTitle("GitSearch");
        this.setLayout(null);
//        FlowLayout layout=new FlowLayout();
		basicInfoPanel=new BasicInfoPanel(ax,ay,width/3,400,vo);
		userRepo=new UserRepo(width/3,ay,width-width/3,h/2,vo);
//TODO        crepo=new ContributeRepo(width/3,h/2,width-width/3,h/2,vo.get);

		this.add(basicInfoPanel);
		this.add(userRepo);
        this.add(crepo);

//        JPanel j1=new JPanel();
//        JPanel j2=new JPanel();
//        JPanel j3=new JPanel();
//        j1.setBackground(Color.blue);
//        j2.setBackground(Color.cyan);
//        j3.setBackground(Color.gray);


//
//        this.add(j1);
//        this.add(j2);
//        this.add(j3);

		this.setVisible(true);
	}

//    private UserVO test_getUser(){
//        ArrayList<RepositoryVO> arrayList=new ArrayList<RepositoryVO>();
//        arrayList.add(new RepositoryVO("repo1","test","",new ArrayList<UserVO>(),
//                new ArrayList<UserVO>(),new ArrayList<RepositoryVO>()));
//
//        arrayList.add(new RepositoryVO("repo2","test2","",new ArrayList<UserVO>(),
//                new ArrayList<UserVO>(),new ArrayList<RepositoryVO>()));
//        arrayList.add(new RepositoryVO("repo3","test3","",new ArrayList<UserVO>(),
//                new ArrayList<UserVO>(),new ArrayList<RepositoryVO>()));
//        arrayList.add(new RepositoryVO("repo4","test4","",new ArrayList<UserVO>(),
//                new ArrayList<UserVO>(),new ArrayList<RepositoryVO>()));
//        ArrayList<RepositoryVO> arrayList2=new ArrayList<RepositoryVO>();
//        arrayList2.add(new RepositoryVO("crepo1","test","",new ArrayList<UserVO>(),
//                new ArrayList<UserVO>(),new ArrayList<RepositoryVO>()));
//
//        arrayList2.add(new RepositoryVO("crepo2","test","",new ArrayList<UserVO>(),
//                new ArrayList<UserVO>(),new ArrayList<RepositoryVO>()));
//        arrayList2.add(new RepositoryVO("crepo3","test","",new ArrayList<UserVO>(),
//                new ArrayList<UserVO>(),new ArrayList<RepositoryVO>()));
//        arrayList2.add(new RepositoryVO("crepo4","test","",new ArrayList<UserVO>(),
//                new ArrayList<UserVO>(),new ArrayList<RepositoryVO>()));
//        return new UserVO("meng yikun","2015-12-12",arrayList,arrayList);
//    }

}

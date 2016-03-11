package presentation.repoCheckui;

import vo.RepositoryVO;
import vo.UserVO;

import java.awt.*;
import java.util.ArrayList;


import javax.swing.*;

public class RepCheckFrame extends JFrame{


    RepoInfo repoInfo;
    Languages languages;
    Contributors contributors;
	static int WIDTH=450;
	static int HEIGHT=650;
    int ax,ay;
    RepositoryVO vo;
    JLabel title;

	public RepCheckFrame(RepositoryVO rvo) {
		this.vo =rvo;
//        vo = test_getRepo();
        ax = 0;
        ay = 0;
        this.setLayout(null);



//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置默认关闭属性
		this.setSize(WIDTH, HEIGHT);// 设置窗体大小
		this.setResizable(false);// 不允许用户改变窗体大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width - this.getWidth()) / 2;
		int y = (screen.height - this.getHeight()) / 2;
		this.setLocation(x, y - 20);
        this.setTitle("GitSearch");

        title=new JLabel("Meng");
        repoInfo=new RepoInfo(ax,ay,WIDTH,HEIGHT/3,vo);
        languages=new Languages(0,HEIGHT/3,WIDTH,HEIGHT/3,vo);
//        contributors=new Contributors(0,2*HEIGHT/3,WIDTH,HEIGHT/3,vo.getContributors());
        this.add(repoInfo);
        this.add(languages);
        this.add(contributors);


		this.setLocation(x, y - 20);	
		
		this.add(new RepCheckPanel());

		this.setVisible(true);
	}

//    RepositoryVO test_getRepo(){
//        ArrayList<UserVO> arrayList=new ArrayList<UserVO>();
//        arrayList.add(new UserVO("meng yikun","2015-12-12",new ArrayList<RepositoryVO>(),new ArrayList<RepositoryVO>()));
//        arrayList.add(new UserVO("jing xiaofeng","2015-12-12",new ArrayList<RepositoryVO>(),new ArrayList<RepositoryVO>()));
//        arrayList.add(new UserVO("chen huan","2015-12-12",new ArrayList<RepositoryVO>(),new ArrayList<RepositoryVO>()));
//        arrayList.add(new UserVO("wan xin","2015-12-12",new ArrayList<RepositoryVO>(),new ArrayList<RepositoryVO>()));
//        arrayList.add(new UserVO("prinz eagun","2015-12-12",new ArrayList<RepositoryVO>(),new ArrayList<RepositoryVO>()));
//
//        RepositoryVO repositoryVO=new RepositoryVO("testRepo","no description","java",arrayList
//        ,arrayList,new ArrayList<RepositoryVO>());
//        return repositoryVO;
//    }

}

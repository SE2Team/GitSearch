package presentation.homeui;

import Util.SearchType;
import businesslogic.RepositoryBL.RepositoryController;
import businesslogic.userBL.UserController;
import businesslogicService.RepositoryBLService;
import businesslogicService.UserBLService;
import presentation.searchui.RepSortPanel;
import presentation.searchui.SearchFrame;
import presentation.searchui.UserSortPanel;
import vo.RepositoryVO;
import vo.UserVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class HomeFrame extends JFrame {
	private HomePanel homePanel;
	ArrayList<UserVO> uvos;
	ArrayList<RepositoryVO> rvos;
	UserBLService userBL;
	RepositoryBLService repBL;
	
	public HomeFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置默认关闭属性
		this.setSize(680, 460);// 设置窗体大小
		this.setResizable(false);// 不允许用户改变窗体大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width - this.getWidth()) / 2;
		int y = (screen.height - this.getHeight()) / 2;
		this.setLocation(x, y - 20);
		
		homePanel = new HomePanel();
		
		//两个搜索按钮的监听
		homePanel.getSearchRep().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				String name = homePanel.getTextField().getText().trim();
				SearchFrame sf ;
				if(name.equals("")){
					sf = new SearchFrame(SearchType.SearchRep);
				}
				else{
					repBL = new RepositoryController();
					try {
						sf = new SearchFrame(SearchType.SearchRep);
						sf.getPanel().getJtf_search().setText(name);
						rvos = new ArrayList<RepositoryVO>();
						Iterator<RepositoryVO> itr = null;
						itr=repBL.Search(name);
						while(itr.hasNext()){
							rvos.add(itr.next());
						}
						RepSortPanel rpanel = sf.getPanel().getRepSortPanel();
						rpanel.performRepSearch(rvos);
						sf.getPanel().add(rpanel);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
//				sf.getPanel().performRepSearch();
			}
		});
		homePanel.getSearchUser().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
//				SearchFrame sf = new SearchFrame(SearchType.SearchUser);
//				sf.getPanel().performUserSearch();
				String name = homePanel.getTextField().getText().trim();
				SearchFrame sf ;
				if(name.equals("")){
					sf = new SearchFrame(SearchType.SearchUser);
				}
				else{
					userBL = new UserController();
					try {
						sf = new SearchFrame(SearchType.SearchUser);
						sf.getPanel().getJtf_search().setText(name);
						uvos = new ArrayList<UserVO>();
						Iterator<UserVO> itr = null;
						itr=userBL.search(name);
						while(itr.hasNext()){
							uvos.add(itr.next());
						}
						UserSortPanel upanel = sf.getPanel().getUserSortPanel();
						upanel.performUserSearch(uvos);
						sf.getPanel().add(upanel);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		this.add(homePanel);
		
		this.setVisible(true);
	}
	
}

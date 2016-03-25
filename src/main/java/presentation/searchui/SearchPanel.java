package presentation.searchui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogic.userBL.UserController;
import businesslogicService.RepositoryBLService;
import businesslogicService.UserBLService;
import Util.SearchType;
import presentation.common.MyButton;
import presentation.common.MyJTextField;
import presentation.common.MyLabel;
import presentation.common.MyPanel;
import presentation.repoCheckui.RepCheckFrame;
import presentation.userCheckui.UserCheckFrame;
import vo.RepositoryVO;
import vo.UserVO;

public class SearchPanel extends JPanel {
	
	public static JPanel j;

	// 搜索框及搜索按钮
	private MyJTextField jtf_search;
	private MyButton userSearch, repSearch;
	// 项目筛选面板、用户筛选面板、项目排序面板、用户排序面板
	private MyPanel jp_repFiltrate, jp_userFiltrate;
	private RepSortPanel jp_repSort;
	private UserSortPanel jp_userSort;
	// 筛选条件、用户排序、项目排序label
	private MyLabel jl_filtrate, jl_userSort, jl_repSort;

	private UserBLService userBL = new UserController();
	private RepositoryBLService repBL = new RepositoryController();
	ArrayList<UserVO> uvos;
	ArrayList<RepositoryVO> rvos;
	
	int x = 100, y = 15, j_x = 50, jtf_w = 400, jb_w = 100,
			jp_w = 800 - 2 * j_x, h = 35, jpRepFil_h = 130, jpUserFil_h = 40,
			jpUserSort_h = 400, jpRepSort_h = 300;

	public SearchPanel(SearchType type) {
		j=this;
		this.setLayout(null);

		// 搜索栏以及搜索按钮
		jtf_search = new MyJTextField(x, y, jtf_w, h);
		userSearch = new MyButton("搜索用户");
		userSearch.setBounds(x + jtf_w, y, jb_w, h);

		repSearch = new MyButton("搜索项目");
		repSearch.setBounds(x + jtf_w + jb_w, y, jb_w, h);

		// 筛选条件label
		jl_filtrate = new MyLabel("筛选条件", j_x, y + h + 10, jb_w, h);

		// 项目筛选面板

		initRepFilPanel();

		// 用户筛选面板

		initUserFilPanel();

		// 项目排序面板
		jl_repSort = new MyLabel("项目排序", j_x, 3 * y + 2 * h + jpRepFil_h, jb_w,
				h);
		jp_repSort = new RepSortPanel(j_x, 3 * y + 3 * h + jpRepFil_h, jp_w,
				jpRepSort_h);


		// 用户排序面板
		jl_userSort = new MyLabel("用户排序", j_x, 3 * y + 2 * h + jpUserFil_h,
				jb_w, h);
		jp_userSort = new UserSortPanel(j_x, 3 * y + 3 * h + jpUserFil_h, jp_w,
				jpUserSort_h);

		this.add(jtf_search);
		this.add(userSearch);
		this.add(repSearch);
		this.add(jl_filtrate);

		if (type == SearchType.SearchRep) {
			this.add(jp_repFiltrate);
			this.add(jl_repSort);
			this.add(jp_repSort);

		} else {
			this.add(jp_userFiltrate);
			this.add(jl_userSort);
			this.add(jp_userSort);
		}
		userSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				performUserSearch();
			}
		});
		repSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				performRepSearch();
			}
		});

		this.setBackground(Color.WHITE);
		SearchFrame.getSearch().setVisible(true);
	}

	/***
	 * 用户搜索按钮监听事件
	 */
	public void performUserSearch(){
		initUserFilPanel();
		SearchPanel.this.remove(jl_repSort);
		SearchPanel.this.remove(jp_repFiltrate);
		SearchPanel.this.remove(jp_repSort);
		SearchPanel.this.add(jp_userFiltrate);
		SearchPanel.this.add(jl_userSort);
		
		if(jtf_search.getText().trim().equals("")){
			SearchPanel.this.add(jp_userSort);
		}
		else{
			uvos = new ArrayList<UserVO>();
			Iterator<UserVO> itr = null;
			try {
				itr = userBL.search(jtf_search.getText().trim());
				while(itr.hasNext()){
					uvos.add(itr.next());
				}
				jp_userSort.performUserSearch(uvos);
				SearchPanel.this.add(jp_userSort);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		jp_userFiltrate.repaint();
		repaint();
		SearchFrame.getSearch().setVisible(true);
	}
	
	/***
	 * 项目搜索按钮监听事件
	 */
	public void performRepSearch(){
		initRepFilPanel();
		SearchPanel.this.remove(jl_userSort);
		SearchPanel.this.remove(jp_userFiltrate);
		SearchPanel.this.remove(jp_userSort);
		
		SearchPanel.this.add(jp_repFiltrate);
		SearchPanel.this.add(jl_repSort);
		
		if(jtf_search.getText().trim().equals("")){
			SearchPanel.this.add(jp_repSort);
		}
		else{
			rvos = new ArrayList<RepositoryVO>();
			Iterator<RepositoryVO> itr = null;
			try {
				itr = repBL.Search(jtf_search.getText().trim());
				while(itr.hasNext()){
					rvos.add(itr.next());
				}
				jp_repSort.performRepSearch(rvos);
				SearchPanel.this.add(jp_repSort);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		jp_userFiltrate.repaint();
		repaint();
		SearchFrame.getSearch().setVisible(true);
	}
	/***
	 * 初始化项目筛选面板
	 */
	public void initRepFilPanel() {
		jp_repFiltrate = new MyPanel(j_x, 2 * y + 2 * h, jp_w, jpRepFil_h);
		jp_repFiltrate.setLayout(null);
		jp_repFiltrate.setBackground(Color.white);
		jp_repFiltrate.setBorder(BorderFactory.createEtchedBorder());
		jp_repFiltrate.add(new CategoryPanel(1, 1, jp_w-3, h));
		jp_repFiltrate.add(new LanguagePanel(1, h + 5, jp_w-3, h));
		jp_repFiltrate.add(new CreateTimePanel(1, 2 * h + 10, jp_w-3, h));
		jp_repFiltrate.repaint();
	}

	/***
	 * 初始化用户筛选面板
	 */
	public void initUserFilPanel() {
		jp_userFiltrate = new MyPanel(j_x, 2 * y + 2 * h, jp_w, jpUserFil_h);
		jp_userFiltrate.setLayout(null);
		jp_userFiltrate.setBorder(BorderFactory.createEtchedBorder());
		jp_userFiltrate.setBackground(Color.white);
		RegistTimePanel r = new RegistTimePanel(1, 1, jp_w-3, h);

		jp_userFiltrate.add(r);
		jp_userFiltrate.repaint();
	}
	
	/***
	 * 获取项目排序的面板
	 * @return
	 */
	public RepSortPanel getRepSortPanel(){
		return jp_repSort;
	}
	/***
	 * 获取用户排序的面板
	 * @return
	 */
	public UserSortPanel getUserSortPanel(){
		return jp_userSort;
	}
}

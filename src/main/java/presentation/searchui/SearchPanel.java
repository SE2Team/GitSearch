package presentation.searchui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Util.SearchType;
import presentation.common.MyButton;
import presentation.common.MyJTextField;
import presentation.common.MyLabel;
import presentation.common.MyPanel;
import presentation.repoCheckui.RepCheckFrame;
import presentation.userCheckui.UserCheckFrame;


public class SearchPanel extends JPanel {

	// 搜索框及搜索按钮
	private MyJTextField jtf_search;
	private MyButton userSearch, repSearch;
	// 项目筛选面板、用户筛选面板、项目排序面板、用户排序面板
	private MyPanel jp_repFiltrate, jp_userFiltrate;
	private RepSortPanel jp_repSort;
	private UserSortPanel jp_userSort;
	// 筛选条件、用户排序、项目排序label
	private MyLabel jl_filtrate, jl_userSort, jl_repSort;

	int x = 150, y = 15, j_x = 100, jtf_w = 300, jb_w = 100, jp_w = jtf_w + 2
			* jb_w + 100, h = 35, jpRepFil_h = 130, jpUserFil_h = 40,
					jpUserSort_h = 400,
			jpRepSort_h = 300;

	public SearchPanel(SearchType type) {

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
		
//		jp_repSort.getTable().addMouseListener(new MouseAdapter() {
//			 public void mouseClicked(MouseEvent e){
//				 new RepCheckFrame();
//			 }
//		});

		
		// 用户排序面板
		jl_userSort = new MyLabel("用户排序", j_x, 3 * y + 2 * h + jpUserFil_h,
				jb_w, h);
		jp_userSort = new UserSortPanel(j_x, 3 * y + 3 * h + jpUserFil_h, jp_w,
				jpUserSort_h);
//		jp_userSort.getTable().addMouseListener(new MouseAdapter() {
//			 public void mouseClicked(MouseEvent e){
//				// new UserCheckFrame(jp_userSort.vo);
//			 }
//		});

		this.add(jtf_search);
		this.add(userSearch);
		this.add(repSearch);
		this.add(jl_filtrate);

		if(type==SearchType.SearchRep){
			this.add(jp_repFiltrate);
			this.add(jl_repSort);
			this.add(jp_repSort);
			
//			userSearch.addActionListener(new ActionListener() {
//				
//				public void actionPerformed(ActionEvent arg0) {
//					// TODO Auto-generated method stub
//					SearchPanel.this.remove(jl_repSort);
//					SearchPanel.this.remove(jp_repFiltrate);
//					SearchPanel.this.remove(jp_repSort);
//					SearchPanel.this.add(jp_userFiltrate);
//					SearchPanel.this.add(jl_userSort);
//					SearchPanel.this.add(jp_userSort);
////					jp_userSort.repaint();
//					SearchPanel.this.initUserFilPanel();
//					repaint();
//				}
//			});
		}
		else{
			this.add(jp_userFiltrate);
			this.add(jl_userSort);
			this.add(jp_userSort);
		}
		userSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				initUserFilPanel();
				SearchPanel.this.remove(jl_repSort);
				SearchPanel.this.remove(jp_repFiltrate);
				SearchPanel.this.remove(jp_repSort);
				SearchPanel.this.add(jp_userFiltrate);
				SearchPanel.this.add(jl_userSort);
				SearchPanel.this.add(jp_userSort);
				
				jp_userFiltrate.repaint();
				repaint();
			}
		});
		repSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SearchPanel.this.remove(jp_userFiltrate);
				SearchPanel.this.remove(jl_userSort);
				SearchPanel.this.remove(jp_userSort);
				SearchPanel.this.add(jp_repFiltrate);
				SearchPanel.this.add(jl_repSort);
				SearchPanel.this.add(jp_repSort);
				jp_userFiltrate.repaint();
				repaint();
			}
		});
		
		this.setBackground(Color.WHITE);
	}

	/***
	 * 初始化项目筛选面板
	 */
	public void initRepFilPanel() {
		jp_repFiltrate = new MyPanel(j_x, 2 * y + 2 * h, jp_w, jpRepFil_h);
		jp_repFiltrate.setLayout(null);
		jp_repFiltrate.add(new CategoryPanel(0, 0, jp_w, h));
		jp_repFiltrate.add(new LanguagePanel(0, h + 5, jp_w, h));
		jp_repFiltrate.add(new CreateTimePanel(0, 2 * h + 10, jp_w, h));
		jp_repFiltrate.repaint();
	}

	/***
	 * 初始化用户筛选面板
	 */
	public void initUserFilPanel() {		
		jp_userFiltrate = new MyPanel(j_x, 2 * y + 2 * h, jp_w, jpUserFil_h);
		jp_userFiltrate.setLayout(null);
		
		RegistTimePanel r=new RegistTimePanel(0, 0, jp_w, h);

		jp_userFiltrate.add(r);
		jp_userFiltrate.repaint();
	}

}

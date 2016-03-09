package presentation.searchui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.common.MyButton;
import presentation.common.MyJTextField;
import presentation.common.MyLabel;
import presentation.common.MyPanel;


public class SearchPanel extends JPanel {

	// 搜索框及搜索按钮
	private MyJTextField jtf_search;
	private MyButton userSearch, repSearch;
	// 项目筛选面板、用户筛选面板、项目排序面板、用户排序面板
	private MyPanel jp_repFiltrate, jp_userFiltrate, jp_repSort, jp_userSort;
	// 筛选条件、用户排序、项目排序label
	private MyLabel jl_filtrate, jl_userSort, jl_repSort;

	int x = 150, y = 15, j_x = 100, jtf_w = 300, jb_w = 100, jp_w = jtf_w + 2
			* jb_w + 100, h = 35, jpRepFil_h = 130, jpUserFil_h = 40,
					jpUserSort_h = 400,
			jpRepSort_h = 300;

	public SearchPanel() {

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
		jp_repFiltrate = new MyPanel(j_x, 2 * y + 2 * h, jp_w, jpRepFil_h);
		jp_repFiltrate.setLayout(null);
		initRepFilPanel();

		// 用户筛选面板
		jp_userFiltrate = new MyPanel(j_x, 2 * y + 2 * h, jp_w, jpUserFil_h);
		jp_userFiltrate.setLayout(null);
		initUserFilPanel();

		// 项目排序面板
		jl_repSort = new MyLabel("项目排序", j_x, 3 * y + 2 * h + jpRepFil_h, jb_w,
				h);
		jp_repSort = new RepSortPanel(j_x, 4 * y + 3 * h + jpRepFil_h, jp_w,
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

		// this.add(jp_repFiltrate);
		this.add(jp_userFiltrate);

		// this.add(jl_repSort);
		this.add(jl_userSort);

		// this.add(jp_repSort);
		this.add(jp_userSort);

		this.setBackground(Color.WHITE);
	}

	/***
	 * 初始化项目筛选面板
	 */
	public void initRepFilPanel() {
		jp_repFiltrate.add(new CategoryPanel(0, 0, jp_w, h));
		jp_repFiltrate.add(new LanguagePanel(0, h + 5, jp_w, h));
		jp_repFiltrate.add(new CreateTimePanel(0, 2 * h + 10, jp_w, h));
	}

	/***
	 * 初始化用户筛选面板
	 */
	public void initUserFilPanel() {
		jp_userFiltrate.add(new RegistTimePanel(0, 0, jp_w, h));
	}

}

package presentation.searchui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.omg.Messaging.SyncScopeHelper;

import Util.Repository_Sort;
import businesslogic.RepositoryBL.RepositoryController;
import businesslogicService.RepositoryBLService;
import presentation.common.MyColor;
import presentation.common.MyLabel;
import presentation.common.MyPanel;
import presentation.common.MyRecButton;
import vo.RepositoryVO;

/***
 * 项目排序面板
 * 
 * @author Administrator
 *
 */

public class RepSortPanel extends MyPanel {

	private MyRecButton general, star, fork, contributor;
	private ArrayList<RepositoryVO> vos = new ArrayList<RepositoryVO>();

	private JLabel front, next, num, sum;
	private MyPanel sortPanel;
	int n = 1;// 记录当前页数
	private int page_num;

	int L_x = 0, L_y = 0, width = 150, height = 30;
	int sortPanel_h = this.getHeight() - height - 30, subPanel_h = 60;
	int subPanelNum = sortPanel_h / subPanel_h;


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.gray);
		g.drawLine(0, 0, this.getWidth(), 0);
		// g.drawLine(0, general.getHeight(), this.getWidth(),
		// general.getHeight());
		g.drawLine(0, 0, 0, this.getHeight() - 1);
		g.drawLine(this.getWidth() - 1, 0, this.getWidth() - 1,
				this.getHeight() - 1);
		g.drawLine(0, this.getHeight() - 1, this.getWidth() - 1,
				this.getHeight() - 1);
	}

	public RepSortPanel(int x, int y, int w, int h) {

		super(x, y, w, h);
		this.setLayout(null);
		sortPanel_h = subPanelNum * subPanel_h;

		general = new MyRecButton("General", Color.WHITE);
		general.setBounds(L_x, L_y, width, height);
		general.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				performGeneSort();
			}
		});

		star = new MyRecButton("Star", Color.WHITE);
		star.setBounds(L_x + width, L_y, width, height);
		star.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performStarSort();
			}
		});
		
		fork = new MyRecButton("Fork", Color.WHITE);
		fork.setBounds(L_x + 2 * width, L_y, width, height);
		fork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				performForkSort();
			}
		});
		
		contributor = new MyRecButton("Contributor", Color.WHITE);
		contributor.setBounds(L_x + 3 * width, L_y, width, height);
		contributor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				performContriSort();
			}
		});
		
		sortPanel = new MyPanel(L_x + 1, L_y + height, this.getWidth() - 2,
				sortPanel_h);
		sortPanel.setBorder(BorderFactory.createEtchedBorder());
		sortPanel.setLayout(new GridLayout(subPanelNum, 1));
		sortPanel.setBackground(Color.WHITE);


		int jl_h = 20;
		int addy = (this.getHeight() - sortPanel_h - height - jl_h) / 2;



		front = new JLabel("上一页");
		front.setBounds(230, L_y + height + sortPanel_h + addy, 50, jl_h);
		front.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (n > 1) {
					n--;
					num.setText(n + "");
					setSortPanel(n);
				}
			}

			public void mouseEntered(MouseEvent e) {
				front.setCursor(new Cursor(Cursor.HAND_CURSOR));
				if (n > 1) {
					performMouseEnter(front);
				}
			}

			public void mouseExited(MouseEvent e) {
				if (n != 1)
					performMouseExit(front);
			}
		});
		// if(n==1)
		// front.setForeground(Color.gray);
		// else
		// front.setForeground(Color.black);
		num = new JLabel(n + "", JLabel.LEFT);
		num.setBounds(293, L_y + height + sortPanel_h + addy, 25, jl_h);

		next = new JLabel("下一页", JLabel.CENTER);
		next.setBounds(320, L_y + height + sortPanel_h + addy, 50, jl_h);
		// if(n==vos.size()/subPanelNum+1){
		// next.setForeground(Color.gray);
		// }
		next.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(vos.size() % subPanelNum==0)
					page_num = vos.size() / subPanelNum;
				else
					page_num = vos.size() / subPanelNum+1;
				if (n < page_num) {
					n++;
					num.setText(n + "");
					setSortPanel(n);
				}
			}

			public void mouseEntered(MouseEvent e) {
				next.setCursor(new Cursor(Cursor.HAND_CURSOR));
				if(vos.size() % subPanelNum==0)
					page_num = vos.size() / subPanelNum;
				else
					page_num = vos.size() / subPanelNum+1;
				if (n < page_num) {
					performMouseEnter(next);
				}
			}

			public void mouseExited(MouseEvent e) {
				if(vos.size() % subPanelNum==0)
					page_num = vos.size() / subPanelNum;
				else
					page_num = vos.size() / subPanelNum+1;
				if (n != page_num)
					performMouseExit(next);
			}
		});

		sum = new MyLabel("共" + vos.size() + "项");
		sum.setBounds(400, L_y + height + sortPanel_h + addy, 100, jl_h);

		performGeneSort();

		this.add(general);
		this.add(star);
		this.add(fork);
		this.add(contributor);
		this.add(sortPanel);
		this.add(front);
		this.add(num);
		this.add(next);
		this.add(sum);
		this.setBackground(Color.white);
	}

	/***
	 * 按general排序
	 */
	public void performGeneSort() {
		RepositoryBLService bl;
		bl = new RepositoryController();
		Iterator<RepositoryVO> ite = null;
		try {
			ite = bl.getRepositories();
			vos.clear();
			while (ite.hasNext()) {
				RepositoryVO vo = ite.next();
				vos.add(vo);
			}
			sum.setText("共" + vos.size() + "项");
			System.out.println(vos.size());
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}

		n = 1;
		setSortPanel(n);// 初始化列表
	}

	/***
	 * 按star排序
	 */
	public void performStarSort() {
		RepositoryBLService bl;
		bl = new RepositoryController();
		Iterator<RepositoryVO> ite = null;
		try {
			ite = bl.sort(Repository_Sort.star);
			vos.clear();
			while (ite.hasNext()) {
				RepositoryVO vo = ite.next();
				vos.add(vo);
			}
			sum.setText("共"+vos.size()+"项");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		n = 1;
		setSortPanel(n);
	}

	/***
	 * 按fork排序
	 */
	public void performForkSort() {
		RepositoryBLService bl;
		bl = new RepositoryController();
		Iterator<RepositoryVO> ite = null;
		try {
			ite = bl.sort(Repository_Sort.fork);
			vos.clear();
			while (ite.hasNext()) {
				RepositoryVO vo = ite.next();
				vos.add(vo);
			}
			sum.setText("共"+vos.size()+"项");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		n = 1;
		setSortPanel(n);
	}

	/***
	 * 按contributors排序
	 */
	public void performContriSort() {
		RepositoryBLService bl;
		bl = new RepositoryController();
		Iterator<RepositoryVO> ite = null;
		try {
			ite = bl.sort(Repository_Sort.contributor);
			vos.clear();
			while (ite.hasNext()) {
				RepositoryVO vo = ite.next();
				vos.add(vo);
			}
		sum.setText("共"+vos.size()+"项");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		n = 1;
		setSortPanel(n);
	}

	/***
	 * 鼠标移至label上时的动作
	 * 
	 * @param label
	 */
	public void performMouseEnter(JLabel label) {
		label.setForeground(MyColor.Info_COLOR2);
	}

	/***
	 * 鼠标离开label上时的动作
	 * 
	 * @param label
	 */
	public void performMouseExit(JLabel label) {
		label.setForeground(Color.black);
	}

	private void setSortPanel(ArrayList<RepositoryVO> vos,int i) {
		if(vos.size() % subPanelNum==0)
			page_num = vos.size() / subPanelNum;
		else
			page_num = vos.size() / subPanelNum+1;

		sortPanel.removeAll();
		sortPanel.repaint();

		if (i > 0 && i < page_num + 1) {

			for(int j = 0; j < subPanelNum
					&& (subPanelNum * (i - 1) + j) < vos.size(); j++) {
				sortPanel.add(new RepInfoSubPanel(vos.get(subPanelNum * (i - 1)
						+ j), sortPanel.getWidth(), subPanel_h));
			}
		}
		SearchFrame.getSearch().setVisible(true);
	}
	
	/***
	 * 设置每一页的项目信息
	 * 
	 * @param i
	 */
	private void setSortPanel(int i) {
		if(vos.size() % subPanelNum==0)
			page_num = vos.size() / subPanelNum;
		else
			page_num = vos.size() / subPanelNum+1;
//		System.out.println(page_num);

		sortPanel.removeAll();
		sortPanel.repaint();

		if (i > 0 && i < page_num+1) {
			for(int j = 0; j < subPanelNum
					&& (subPanelNum * (i - 1) + j) < vos.size(); j++) {
				sortPanel.add(new RepInfoSubPanel(vos.get(subPanelNum * (i - 1)
						+ j), sortPanel.getWidth(), subPanel_h));
//				System.out.println(j);
			}
		}
		SearchFrame.getSearch().setVisible(true);
	}
	
	public void performRepSearch(ArrayList<RepositoryVO> rvos){
		this.vos = rvos;
		n=1;
		sum.setText("共"+vos.size()+"项");
		this.setSortPanel(vos, n);	
	}
}

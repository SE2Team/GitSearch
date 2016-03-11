package presentation.searchui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogicService.RepositoryBLService;
import presentation.common.MyColor;
import presentation.common.MyLabel;
import presentation.common.MyPanel;
import presentation.common.MyRecButton;
import vo.RepositoryVO;

/***
 * 项目排序面板
 * @author Administrator
 *
 */

public class RepSortPanel extends MyPanel{
	
	private MyRecButton general,star,fork,contributor;
//	private JTable sortTable;
	private MyLabel front,next,num;
	private MyPanel sortPanel;
	int n=1;
	int L_x=0,L_y=0,width=150,height=30;
	int sortPanel_h=this.getHeight()-height-30,subPabel_h=40;
	int subPanelNum = sortPanel_h/subPabel_h;
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.gray);
//		g.drawLine(0, 0, this.getWidth(), 0);
//		g.drawLine(0, general.getHeight(), this.getWidth(), general.getHeight());
		g.drawLine(0, 0, 0, this.getHeight()-1);
		g.drawLine(this.getWidth()-1, 0, this.getWidth()-1, this.getHeight()-1);
		g.drawLine(0, this.getHeight()-1, this.getWidth()-1, this.getHeight()-1);
	}
	
	public RepSortPanel(int x, int y, int w, int h) {
		super(x, y, w, h);
	//	this.setLayout(new FlowLayout(FlowLayout.LEFT,0,0 ));
		this.setLayout(null);
		general = new MyRecButton("General",Color.WHITE);
		general.setBounds(L_x,L_y,width,height);
		star = new MyRecButton("Star",MyColor.BUTTON_gray);
		star.setBounds(L_x+width,L_y,width,height);
		fork = new MyRecButton("Fork",Color.WHITE);
		fork.setBounds(L_x+2*width,L_y,width,height);
		contributor = new MyRecButton("Contributor",MyColor.BUTTON_gray);
		contributor.setBounds(L_x+3*width,L_y,width,height);
		
//		sortTable = new JTable(subPanelNum, 1);
//		sortTable.setShowHorizontalLines(false);
//		sortTable.setShowGrid(true);
//		sortTable.setShowVerticalLines(false);
//		sortTable.setBounds(L_x+1, L_y+height, this.getWidth()-2, sortPanel_h);
//		sortTable.setRowHeight(row_h);
		
		sortPanel = new MyPanel(L_x+1, L_y+height, this.getWidth()-2, sortPanel_h);
		sortPanel.setBorder(BorderFactory.createEtchedBorder());
		sortPanel.setLayout(new GridLayout(subPanelNum,1));
		sortPanel.setBackground(Color.WHITE);

        RepositoryBLService bl;
        bl = new RepositoryController();
        Iterator<RepositoryVO> ite = null;
        int i = 0;
        try {
            ite = bl.getRepositories();
//			if(ite!=null){
//				while(ite.hasNext()){
//					RepositoryVO repoVO = ite.next();
//					sortTable.setValueAt("a", 0, 0);
//					i++;
//				}
//			}
            while (ite.hasNext() && i < 6) {
                this.add(new RepInfoSubPanel(ite.next(), width, subPabel_h));
                i++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int jl_h=20;
		int addy=(this.getHeight()-sortPanel_h-height-jl_h)/2;
		
		front = new MyLabel("上一页");
		front.setBounds(230,L_y+height+sortPanel_h+addy,50,jl_h);
		num = new MyLabel(n+"");
		num.setBounds(295, L_y+height+sortPanel_h+addy, 25, jl_h);
		next = new MyLabel("下一页");
		next.setBounds(320,L_y+height+sortPanel_h+addy,50,jl_h);
		
		this.add(general);
		this.add(star);
		this.add(fork);
		this.add(contributor);
		this.add(sortPanel);
//		this.add(sortTable);
		this.add(front);
		this.add(num);
		this.add(next);
		
		this.setBackground(Color.white);
	}
	
//	/***
//	 * 获取表格
//	 * @return
//	 */
//	public JTable getTable(){
//		return sortTable;
//	}

}

package presentation.searchui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;

import businesslogic.RepositoryBL.Repository;
import businesslogic.RepositoryBL.RepositoryController;
import businesslogic.userBL.UserController;
import businesslogicService.RepositoryBLService;
import businesslogicService.UserBLService;
import presentation.common.MyColor;
import presentation.common.MyLabel;
import presentation.common.MyPanel;
import presentation.common.MyRecButton;
import presentation.repoCheckui.Contributors;
import presentation.userCheckui.UserCheckFrame;
import vo.RepositoryVO;
import vo.UserVO;

public class UserSortPanel extends MyPanel{
	
	private MyRecButton general,followers,numOfRep;
	private ArrayList<UserVO> vos = new ArrayList<UserVO>();
	private JLabel front,next,num,sum;
	private MyPanel sortPanel;
	int n=1;//记录当前页数
	
	int L_x=0,L_y=0,width=160,height=30;
	int sortPanel_h=this.getHeight()-height-30,subPanel_h=40;
	int subPanelNum = sortPanel_h/subPanel_h;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.gray);
		g.drawLine(0, 1, this.getWidth(), 1);
//		g.drawLine(0, general.getHeight()-1, this.getWidth(), general.getHeight()-1);
		g.drawLine(0, 0, 0, this.getHeight());
		g.drawLine(this.getWidth()-1, 0, this.getWidth()-1, this.getHeight());
		g.drawLine(0, this.getHeight()-1, this.getWidth()-1, this.getHeight()-1);
	}
	public UserSortPanel(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.setLayout(null);
		sortPanel_h = subPanelNum*subPanel_h;
		general = new MyRecButton("General",Color.WHITE);
		general.setBounds(L_x,L_y,width,height);
		followers = new MyRecButton("Followers",MyColor.BUTTON_gray);
		followers.setBounds(L_x+width,L_y,width,height);
		numOfRep = new MyRecButton("NumOfRelatedRep",Color.WHITE);
		numOfRep.setBounds(L_x+2*width,L_y,width,height);
		
		sortPanel = new MyPanel(L_x+1, L_y+height, this.getWidth()-2, sortPanel_h);
		sortPanel.setBorder(BorderFactory.createEtchedBorder());
		sortPanel.setLayout(new GridLayout(subPanelNum,1));
		sortPanel.setBackground(Color.WHITE);
		
		UserBLService bl;
        bl = new UserController();
        Iterator<UserVO> ite = null;
        try {
            ite = bl.getUser();
			while (ite.hasNext()) {
				UserVO vo = ite.next();
				vos.add(vo);
			}

        } catch (IOException e) {
            e.printStackTrace();
        }

        setSortPanel(n);//初始化列表

		int jl_h=20;
		int addy=(this.getHeight()-sortPanel_h-height-jl_h)/2;
		front = new JLabel("上一页",JLabel.CENTER);
		front.setBounds(230,L_y+height+sortPanel_h+addy,50,jl_h);
		front.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if(n>1){
					n--;
					num.setText(n+"");
					setSortPanel(n);
				}
			}
			public void mouseEntered(MouseEvent e){
				front.setCursor(new Cursor(Cursor.HAND_CURSOR));
				if(n>1){
					performMouseEnter(front);
				}
			}
			public void mouseExited(MouseEvent e){
				if(n!=1)
					performMouseExit(front);
			}
		});
		
		num = new JLabel(n+"",JLabel.LEFT);
		num.setBounds(293, L_y+height+sortPanel_h+addy, 25, jl_h);
		
		next = new JLabel("下一页",JLabel.CENTER);
		next.setBounds(320,L_y+height+sortPanel_h+addy,50,jl_h);
		next.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if(n<vos.size()/subPanelNum+1){
					n++;
					num.setText(n+"");
					setSortPanel(n);
				}				
			}
			public void mouseEntered(MouseEvent e){
				next.setCursor(new Cursor(Cursor.HAND_CURSOR));
				if(n<vos.size()/subPanelNum+1){
					performMouseEnter(next);
				}
			}
			public void mouseExited(MouseEvent e){
				if(n!=vos.size()/subPanelNum+1)
					performMouseExit(next);
			}
		});
		
		sum = new MyLabel("共"+vos.size()+"项");
		sum.setBounds(400,L_y+height+sortPanel_h+addy,100,jl_h);
		this.add(general);
		this.add(followers);
		this.add(numOfRep);
		this.add(sortPanel);
		this.add(front);
		this.add(num);
		this.add(next);
		this.add(sum);
		this.setBackground(Color.white);
	}

	/***
	 * 鼠标移至label上时的动作
	 * @param label
	 */
	public void performMouseEnter(JLabel label){
		label.setForeground(MyColor.Info_COLOR2);
	}
	
	/***
	 * 鼠标离开label上时的动作
	 * @param label
	 */
	public void performMouseExit(JLabel label){
		label.setForeground(Color.black);
	}
	
	/***
	 * 设置每一页的项目信息
	 * @param i
	 */
	private void setSortPanel(int i) {
		
		if(i>0&&i<vos.size()/subPanelNum+2){
			sortPanel.removeAll();
			for(int j=0;j<subPanelNum&&(subPanelNum*(i-1)+j)<vos.size();j++){
				sortPanel.add(new UserInfoSubPanel(vos.get(subPanelNum*(i-1)+j), sortPanel.getWidth(),subPanel_h));
			}
		}
		SearchFrame.getSearch().setVisible(true);
	}
}

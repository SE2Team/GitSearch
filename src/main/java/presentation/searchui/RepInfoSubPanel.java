package presentation.searchui;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.MyFont;
import vo.RepositoryVO;

public class RepInfoSubPanel extends JPanel{

	private JLabel jl_repName,jl_star,jl_fork,jl_contributors,star_num,fork_num,contri_num;
	public RepInfoSubPanel(RepositoryVO rvo,int w,int h) {
		this.setLayout(null);
		this.setSize(w,h);
		int x = 105, y = h / 6, jl_w = 50, jl_h = 30, addx = 5, addy = 20;

		jl_repName = new JLabel(rvo.getName());
		jl_repName.setFont(MyFont.Arial20);
		jl_repName.setBounds(x, y, w, jl_h);
		
		jl_contributors = new JLabel("contributors",JLabel.CENTER);
		jl_contributors.setFont(MyFont.Shruti18);
		jl_contributors.setBounds(w-x, y, 2*jl_w, jl_h);
		
		jl_fork = new JLabel("forks",JLabel.CENTER);
		jl_fork.setFont(MyFont.Shruti18);
		jl_fork.setBounds(w-x-jl_w-addx, y, jl_w, jl_h);
		
		jl_star = new JLabel("stars",JLabel.CENTER);
		jl_star.setFont(MyFont.Shruti18);
		jl_star.setBounds(w-x-2*jl_w-2*addx, y, jl_w, jl_h);
		
		contri_num = new JLabel(rvo.getContributor()+"",JLabel.CENTER);
		contri_num.setFont(MyFont.weiruan);
		contri_num.setBounds(w-x, y+addy, 2*jl_w, jl_h);
		
		fork_num = new JLabel(rvo.getForks()+"",JLabel.CENTER);
		fork_num.setFont(MyFont.weiruan);
		fork_num.setBounds(w-x-jl_w-addx, y+addy, jl_w, jl_h);
		
		star_num = new JLabel(rvo.getStargazers_count()+"",JLabel.CENTER);
		star_num.setFont(MyFont.weiruan);
		star_num.setBounds(w-x-2*jl_w-2*addx, y+addy, jl_w, jl_h);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.add(jl_repName);
        this.add(jl_star);
        this.add(jl_fork);
        this.add(jl_contributors);
        this.add(contri_num);
        this.add(fork_num);
        this.add(star_num);
	}

}

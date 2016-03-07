package presentation.searchui;

import javax.swing.JButton;
import javax.swing.JPanel;

import common.MyButton;
import common.MyJTextField;

public class SearchUserPanel extends JPanel{

	private MyJTextField jtf_search;
	private MyButton jb;
	
	public SearchUserPanel() {
		this.setLayout(null);
		jb = new MyButton("j",100, 100, 100, 30);
	//	jb.setBounds();
		repaint();
		this.add(jb);
	}

}

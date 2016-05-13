package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

import com.sun.org.apache.regexp.internal.recompile;

import po.RepositoryPO;
import po.UserPO;

public class JDBCHelper {
	public static final String url = "jdbc:mysql://127.0.0.1:3306/sys?characterEncoding=UTF-8";  
	public static final String driver = "com.mysql.jdbc.gitsearch";  
	public static final String user = "root";  
	public static final String password = "15120341049ASD";  
	public static final String characterEncoding = "utf-8";
	
	private Connection conn = null;  
	private PreparedStatement pStatement = null;

	public JDBCHelper() {  
		try {  
			Class.forName(driver);

			conn = DriverManager.getConnection(url, user, password);

			System.out.println("数据库连接成功！！！");

		} catch (Exception e) {  
			e.printStackTrace();  
		}  
	}  

	
	public ArrayList<RepositoryPO> getRepositories(){
		ArrayList<RepositoryPO> list=new ArrayList<>();
		String sql = "select * from repositories ";
		ResultSet rs = null;
		try {

			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while(rs.next()){
			list.add(new RepositoryPO(rs.getString("name"), rs.getInt("Id"), rs.getString("owner_type"), rs.getString("html_url"),
					rs.getString("description"), rs.getBoolean("fork"), rs.getString("created"), rs.getString("updated"), rs.getString("pushed"),
					rs.getInt("size"), 0, rs.getString("language"), rs.getInt("forks"), rs.getInt("open_issues"), 
					rs.getInt("subscribers_count"), 0, 0, null,null));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<UserPO> getUsers(){
		ArrayList<UserPO> list=new ArrayList<>();
		String sql = "select * from user ";
		ResultSet rs = null;
		try {

			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while(rs.next()){
			list.add(new UserPO(rs.getInt("id"), rs.getString("login"), rs.getString("type"),
					rs.getString("name"), rs.getString("company"), rs.getString("email"), rs.getString("public_repos"), 
					rs.getInt("public_gists"), rs.getInt("followers"),rs.getInt(" following"), 
					rs.getString("created_at"), rs.getString("updated_at"), null, null));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<String> getContributor(int rid){
		ArrayList<String> list=new ArrayList<>();
		String sql = "select * from contribution where rid=?";
		ResultSet rs = null;
		try {

			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, rid);
			rs = pStatement.executeQuery();
			while(rs.next()){
			list.add(rs.getString("contributor"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		}
}

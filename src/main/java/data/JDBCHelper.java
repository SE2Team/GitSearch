package data;

import po.RepositoryPO;
import po.StaStrPO;
import po.UserPO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCHelper {
	public static final String url = "jdbc:mysql://localhost/gitsearch?useUnicode=true&characterEncoding=UTF-8"
			+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "";

	private Connection conn = null;
	private PreparedStatement pStatement = null;
	boolean isConnection=false;
	
	public JDBCHelper() {
		if(isConnection==false){
		isConnection=true;
		try {
			Class.forName(driver);

			conn = DriverManager.getConnection(url, user, password);

			System.out.println("数据库连接成功！！！");

		} catch (Exception e) {
			
			}
		}
	}

	public ArrayList<RepositoryPO> getRepositories() {
		ArrayList<RepositoryPO> list = new ArrayList<>();
		String sql = "select * from repo ";
		ResultSet rs = null;
		try {

			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				list.add(new RepositoryPO(rs.getString("fullname"), rs.getInt("Id"), null, rs.getString("html_url"),
						rs.getString("description"), rs.getBoolean("fork"), rs.getDate("created"),
						rs.getDate("updated"), rs.getDate("pushed"), rs.getInt("size"), 0, rs.getString("language"),
						rs.getInt("forks"), rs.getInt("open_issues"), rs.getInt("subscribers_count"), 0, 0, null,
						null));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<UserPO> getUsers() {
		ArrayList<UserPO> list = new ArrayList<>();
		String sql = "select * from user ";
		ResultSet rs = null;
		try {

			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				javafx.scene.image.Image userImage = new javafx.scene.image.Image(rs.getString("avatar_url"));
				list.add(new UserPO(rs.getInt("id"), rs.getString("login"), rs.getString("type"), rs.getString("name"),
						rs.getString("company"), rs.getString("email"), rs.getString("public_repos"),
						rs.getInt("public_gists"), rs.getInt("followers"), rs.getInt("following"),
						rs.getDate("created_at"), rs.getDate("updated_at"), null, null, userImage));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<String> getContributor(int rid) {
		ArrayList<String> list = new ArrayList<>();
		String sql = "select * from contribution where rid=?";
		ResultSet rs = null;
		try {

			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, rid);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("contributor"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public UserPO checkUser(String name) {
		return null;
	}
	
	public RepositoryPO checkRepo(String userName, String reponame){
		return null;
	}
	
	public StaStrPO getCompany() {
		ArrayList<String> listStr=new ArrayList<>();
		ArrayList<Integer> listInt=new ArrayList<>();
		String sql = "select * from companystatistics order by num Desc";
		ResultSet rs = null;
		try {

			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				listInt.add(rs.getInt("num"));
				listStr.add(rs.getString("company"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new StaStrPO(listStr, listInt);
	}

	public StaStrPO getLanguage(){
		ArrayList<String> listStr=new ArrayList<>();
		ArrayList<Integer> listInt=new ArrayList<>();
		String sql = "select * from languagestatistics order by num Desc";
		ResultSet rs = null;
		try {

			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				listInt.add(rs.getInt("num"));
				listStr.add(rs.getString("language"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new StaStrPO(listStr, listInt);
	}
	
	public StaStrPO getStar(){
		ArrayList<String> listStr=new ArrayList<>();
		ArrayList<Integer> listInt=new ArrayList<>();
		String sql = "select * from starstatistic";
		ResultSet rs = null;
		try {

			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				listInt.add(rs.getInt("num"));
				listStr.add(rs.getString("xs"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new StaStrPO(listStr, listInt);
	}
}

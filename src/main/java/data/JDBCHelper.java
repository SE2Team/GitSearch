package data;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.PagedSearchIterable;
import po.RepositoryPO;
import po.StaStrPO;
import po.UserPO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

public class JDBCHelper {
	public static final String url = "jdbc:mysql://localhost/gitsearch?useUnicode=true&characterEncoding=UTF-8"
			+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "";

	private Connection conn = null;
	private PreparedStatement pStatement = null;
	public static boolean isConnection=false;
	
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
				//javafx.scene.image.Image userImage = new javafx.scene.image.Image(rs.getString("avatar_url"));
				list.add(new UserPO(rs.getInt("id"), rs.getString("login"), rs.getString("type"), rs.getString("name"),
						rs.getString("company"), rs.getString("email"), rs.getString("public_repos"),
						rs.getInt("public_gists"), rs.getInt("followers"), rs.getInt("following"),
						rs.getDate("created_at"), rs.getDate("updated_at"), null, null, null));
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

	public UserPO checkUser(String login) {
        PagedSearchIterable<GHUser> re=InitConnection.getG().searchUsers().q(login).in("login").list();
        if (re.getTotalCount()>1){
            Iterator<GHUser> itr=re.iterator();
            while (itr.hasNext()){
                GHUser user=itr.next();
                if (user.getLogin().equalsIgnoreCase(login)){
                    return user;
                }
                /**
                 * 找不到对应的po
                 */
                return null;
            }
        }else if(re.getTotalCount()==1){
            return re.iterator().next();
        }else {
            return null;
        }
        return null;
	}
	
	public RepositoryPO checkRepo(String userName, String reponame){
        PagedSearchIterable<GHRepository> re=InitConnection.getG().searchRepositories().q(reponame).in("name").list();
        if (re.getTotalCount()>1){
            Iterator<GHRepository> itr=re.iterator();
            while (itr.hasNext()){
                GHRepository repo=itr.next();
                if (repo.getName().equalsIgnoreCase(reponame)||repo.getOwnerName().equalsIgnoreCase(userName)){
                    return repo;
                }
                /**
                 * 找不到对应的po
                 */
                return null;
            }
        }else if(re.getTotalCount()==1){
            return re.iterator().next();
        }else {
            return null;
        }
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
	
	public StaStrPO getFork(){
		ArrayList<String> listStr=new ArrayList<>();
		ArrayList<Integer> listInt=new ArrayList<>();
		String sql = "select * from forkstatistics";
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
	
	public StaStrPO getFollowers(){
		ArrayList<String> listStr=new ArrayList<>();
		ArrayList<Integer> listInt=new ArrayList<>();
		String sql = "select * from userflosta";
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
	
	public StaStrPO getUserCreated(){
		return null;
	}
	
	public  StaStrPO getRepoCreated(){
		return null;
	}
}

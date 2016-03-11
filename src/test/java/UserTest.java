
import java.io.IOException;
import java.util.ArrayList;

import Util.UserInfo;
import data.UserData;
import junit.framework.TestCase;
import po.UserPO;

public class UserTest extends TestCase{
	private UserData user;
	ArrayList<UserPO> userPO;
	private UserPO po1,po2,po3;
	String s1,s2,s3;
	ArrayList<UserPO> search;
	
	protected void  setUp() throws IOException {
			user=new UserData();
			userPO=user.getUser();
			po1=userPO.get(0);
			po2=userPO.get(1);
			po3=userPO.get(2);
			s1=new UserData().UserInfo("mojombo", UserInfo.login);
			s2=new UserData().UserInfo("technoweenie", UserInfo.email);
			s3=new UserData().UserInfo("macournoyer", UserInfo.name);
			search=new UserData().search("mbo");
			
		}
	
	protected void  tearDown() {
		
	}
	
	public void testCheckUser(){
		assertTrue(po1.getLogin().equals("mojombo"));
		assertTrue(po2.getLogin().equals("technoweenie"));
		assertTrue(po3.getLogin().equals("macournoyer"));
	}
	
	
	
	public void testUserInfo(){
//		assertTrue(s1.equals("mojombo"));
//		assertTrue(s2.equals("technoweenie@gmail.com"));
//		assertTrue(s3.equals("Marc-André Cournoyer"));
	}
	
	public void testSearch(){
		assertTrue(search.get(0).getEmail().equals("tom@mojombo.com"));
		assertTrue(search.get(1).getEmail().equals("contractfrombelow@gmail.com"));
	}
	
}

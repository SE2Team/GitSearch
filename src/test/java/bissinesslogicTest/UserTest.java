package bissinesslogicTest;

import Util.UserInfo;
import Util.User_Sort;
import businesslogic.userBL.User;
import junit.framework.TestCase;
import vo.UserVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class UserTest extends TestCase{
	private static User testUser=new User();
	protected void setUp(){
		/*初始化*/
	}
	protected void tearDwon(){
		
	}
	
	/*测试checkUser方法*/
	public void testcheckUser() throws IOException{
		assertTrue(testUser.checkUser("mojombo").getName().equals("Tom Preston-Werner"));
	}
	
	/*测试UserInfo方法*/
	public void testUserInfo() throws IOException{
		assertTrue(testUser.UserInfo("mojombo", UserInfo.id).equals("1"));
	}
	
//	/*测试getStargazers方法*/
//	public void testgetStargazers() throws IOException{
//		Iterator<String> itr=testUser.getStargazers("mojombo","grit");
//		ArrayList<String> str=new ArrayList<String>();
//		while(itr.hasNext()){
//			String s=itr.next();
//			str.add(s);
//		}
//		assertTrue(str.get(0).equals(""));
//	}
	
//	/*测试getStargazerNames方法*/
//	public void testgetStargazerNames() throws IOException{
//		Iterator<String> itr=testUser.getStargazerNames("mojombo","grit");
//		ArrayList<String> str=new ArrayList<String>();
//		while(itr.hasNext()){
//			String s=itr.next();
//			str.add(s);
//		}
//		assertTrue(str.get(0).equals(""));
//	}
//	
//	/*测试getSubscribers方法*/
//	public void testgetSubscribers(){
//		Iterator<UserVO> test=testUser.getSubscribers("mojombo","grit");
//		ArrayList<UserVO> vos=new ArrayList<UserVO>();
//		while(test.hasNext()){
//			UserVO s=test.next();
//			vos.add(s);
//		}
//		assertTrue(vos.get(0).getName().equals(""));
//	}
//	
//	/*测试NamesOfSubscriber方法*/
//	public void testNamesOfSubscriber(){
//		
//	}
	
	/*测试sortUser方法*/
	public void testsortUser() throws IOException{
		Iterator<UserVO> test=testUser.sortUser(User_Sort.Followers);
		ArrayList<UserVO> vos=new ArrayList<UserVO>();
		while(test.hasNext()){
			UserVO s=test.next();
			vos.add(s);
		}
		assertTrue(vos.get(0).getName().equals("Tom Preston-Werner"));
	}
	
	/*测试screenTime方法*/
	public void testscreenTime() throws IOException{
		Iterator<UserVO> test=testUser.screenTime("2010");
		ArrayList<UserVO> vos=new ArrayList<UserVO>();
		while(test.hasNext()){
			UserVO s=test.next();
			vos.add(s);
		}
		assertTrue(vos.get(0).getName().equals("Tekkub's WoW addons"));
	}
}

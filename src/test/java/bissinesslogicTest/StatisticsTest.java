package bissinesslogicTest;

import businesslogic.RepositoryBL.Statistics;
import junit.framework.TestCase;

import java.io.IOException;

public class StatisticsTest extends TestCase{
	private static Statistics testsStatistics=new Statistics();
	protected void setUp(){
		/*初始化*/
	}
	protected void tearDwon(){
		
	}
	
	/*测试getStar方法*/
	public void testgetStar() throws IOException{
		assertTrue(testsStatistics.getStar().getX().get(0)!=null);
	}
	
	/*测试getForks方法*/
	public void testgetForks() throws IOException{
		assertTrue(testsStatistics.getForks().getX().get(0)!=null);
	}
	
	/*测试getRepoCreated方法*/
	public void testgetRepoCreated() throws IOException{
		assertTrue(testsStatistics.getRepoCreated().getX().get(0)!=null);
	}
	
	/*测试getLanguage方法*/
	public void testgetLanguage() throws IOException{
		assertTrue(testsStatistics.getLanguage().getX().get(0)!=null);
	}
	
	/*测试getUserCreated方法*/
	public void testgetUserCreated() throws IOException{
		assertTrue(testsStatistics.getUserCreated().getX().get(0)!=null);
	}
	
	/*测试getUserType方法*/
	public void testgetUserType() throws IOException{
		assertTrue(testsStatistics.getUserType().getX().get(0)!=null);
	}
	
	/*测试getUserHas方法*/
	public void testgetUserHas(){
		assertTrue(testsStatistics.getUserHas().getInt().get(0)!=null);
	}
	
	/*测试getUserRelated方法*/
	public void testgetUserRelated(){
		assertTrue(testsStatistics.getUserRelated().getInt().get(0)!=null);
	}
	
	/*测试getCompany方法*/
	public void testgetCompany() throws IOException{
		assertTrue(testsStatistics.getCompany().getX().get(0)!=null);
	}
	
	/*测试getCollaborator方法*/
	public void testgetCollaborator() throws IOException{
		assertTrue(testsStatistics.getCollaborator().getX().get(0)!=null);
	}
	
	/*测试getContributor方法*/
	public void testgetContributor() throws IOException{
		assertTrue(testsStatistics.getContributor().getX().get(0)!=null);
	}
}

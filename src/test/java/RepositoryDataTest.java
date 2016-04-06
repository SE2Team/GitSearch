import data.RepositoryData;
import junit.framework.TestCase;
import po.RepositoryPO;

import java.io.IOException;
import java.util.ArrayList;

import Util.RepositoryInfo;

public class RepositoryDataTest extends TestCase {
	
	private static RepositoryData testRepository=new RepositoryData();
	ArrayList<RepositoryPO> repositoryPO;
	RepositoryPO po1,po2,po3;
	String s1,s2,s3;
	
	protected void setUp() throws IOException {
		/*初始化*/
		repositoryPO=testRepository.getRepositories();
		po1=repositoryPO.get(0);
		po2=repositoryPO.get(1);
		po3=repositoryPO.get(4);
	}
	protected void  tearDown() {
		
	}
	
	/*测试CheckRepository方法*/
	public void testCheckRepository() throws IOException{
		assertTrue(po1.getName().equals(testRepository.checkRepository("mojombo","grit").getName()));
		assertTrue(po2.getName().equals(testRepository.checkRepository("mojombo", "god").getName()));
		assertTrue(po3.getName().equals(testRepository.checkRepository("macournoyer", "thin").getName()));
	}
	
	/*测试getRepositoriesNames方法*/
	public void testgetRepositoriesNames() throws IOException{
		ArrayList<String> a=testRepository.getRepositoriesNames();
		assertEquals(po1.getName(), a.get(0));
		assertEquals(po2.getName(), a.get(1));
		assertEquals(po3.getName(), a.get(4));
	}

	/*测试languagesOfRepository方法*/
	public void testlanguagesOfRepository() throws IOException{
		assertTrue(po1.getLanguage().equals(testRepository.checkRepository("mojombo","grit").getLanguage()));
		assertTrue(po2.getLanguage().equals(testRepository.checkRepository("mojombo", "god").getLanguage()));
		assertTrue(po3.getLanguage().equals(testRepository.checkRepository("macournoyer", "thin").getLanguage()));
	}

	/*测试RepositoryInfo方法*/
	
}

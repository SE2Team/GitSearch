package bissinesslogicTest;

import businesslogic.RepositoryBL.Repository;
import junit.framework.TestCase;
import vo.RepositoryVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class RepositoryTest extends TestCase{
	
	private static Repository testRepository=new Repository();
	ArrayList<RepositoryVO> repositoryVOs=new ArrayList<RepositoryVO>();
	
	protected void setUp() throws IOException {
		/*初始化*/
		Iterator<RepositoryVO> itr=testRepository.getRepositories();
		while(itr.hasNext()){
			RepositoryVO vo=itr.next();
			repositoryVOs.add(vo);
		}
	}
	protected void tearDwon() {
		
	}
	
	/*测试getRepositoriesNames方法*/
	public void testgetRepositoriesNames() {
		Iterator<String> itr=testRepository.getRepositoriesNames();
		ArrayList<String> str=new ArrayList<String>();
		while(itr.hasNext()){
			String s=itr.next();
			str.add(s);
		}
		assertEquals(repositoryVOs.get(0).getName(), str.get(0));
		assertEquals(repositoryVOs.get(1).getName(), str.get(1));
		assertEquals(repositoryVOs.get(2).getName(), str.get(2));
	}
	
	/*测试checkRepository方法*/
	public void testcheckRepository() throws IOException{
		RepositoryVO vo=testRepository.checkRepository("mojombo","grit");
		assertEquals(repositoryVOs.get(0).getName(), vo.getName());
	}
	
	/*测试languagesOfRepository方法*/
	public void testlanguagesOfRepository() throws IOException{
		assertEquals("Ruby", testRepository.languagesOfRepository("mojombo","grit").getStr().get(0));
	}
	
	/*测试Search方法*/
	public void testSearch() throws IOException{
		Iterator<RepositoryVO> testSearch=testRepository.Search("grit");
		ArrayList<RepositoryVO> vos=new ArrayList<RepositoryVO>();
		while(testSearch.hasNext()){
			RepositoryVO vo=testSearch.next();
			vos.add(vo);
		}
		assertTrue(vos.get(0).getName().equals(repositoryVOs.get(0).getName()));
	}
	
//	/*测试sort方法*/
//	public void testsort() throws IOException{
//		Iterator<RepositoryVO> testSearch=testRepository.sort(Repository_Sort.star);
//		ArrayList<RepositoryVO> vos=new ArrayList<RepositoryVO>();
//		while(testSearch.hasNext()){
//			RepositoryVO vo=testSearch.next();
//			vos.add(vo);
//		}
//		assertTrue(vos.size()==0);
//	}
	
}

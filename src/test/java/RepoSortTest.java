import data.RepositoryData;
import junit.framework.TestCase;
import po.RepositoryPO;

import java.io.IOException;
import java.util.ArrayList;

public class RepoSortTest extends TestCase{
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
	
	/*测试sort方法*/
	public void testSort() throws IOException{
//		System.out.println(po1.getCreated());
//		assertEquals(po1.getCreated(), testRepository.sort(Repository_Sort.fork).get(0).getCreated());
	}

}

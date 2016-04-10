package businesslogic;

import java.io.IOException;

import businesslogic.RepositoryBL.Repository;

/** 
 * @author 
 * @date 
2016年4月10日 
下午8:25:35 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 *@throws 异常类及抛出条件
 */
public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Repository repository=new Repository();
		System.out.println(repository.languagesOfRepository("mojombo","grit").getStr().get(0));
	}

}

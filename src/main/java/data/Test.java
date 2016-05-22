package data;

import java.io.IOException;

import po.RepositoryPO;



public class Test {
	public static void main(String[] args) throws IOException{
		JDBCHelper helper=GetJDBC.getJDBCHelper();
		RepositoryPO po=helper.checkRepo("rails", "rails");

	}
}
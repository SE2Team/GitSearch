package data;


import po.RepositoryPO;

import java.io.IOException;
import java.util.ArrayList;


public class Test {
	public static void main(String[] args) throws IOException{
		System.out.println("ccccccccc");
		RepositoryData data=new RepositoryData();
		ArrayList<RepositoryPO> list=data.getRepositories();
		System.out.println("ccccccccc");
		System.out.println(list.get(0).getLanguage());
		

	}
}
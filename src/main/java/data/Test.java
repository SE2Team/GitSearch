package data;

import java.io.IOException;
import java.util.ArrayList;

import Util.Repository_Sort;
import Util.UserInfo;
import po.RepositoryPO;
import po.UserPO;


public class Test {
	public static void main(String[] args) throws IOException{
		RepositoryData testRepository=new RepositoryData();
		ArrayList<String> a=testRepository.getRepositoriesNames();
		for(int i=0;i<a.size();i++){
			System.out.println(a.get(i));
		}
		
				}
}

package data;

import java.io.IOException;
import java.util.ArrayList;

import po.RepositoryPO;
import po.UserPO;


public class Test {
	public static void main(String[] args) throws IOException{
	ArrayList<RepositoryPO> list=new ArrayList<RepositoryPO>();
	list=new RepositoryData().getRepositories();
	for(int j=0;j<list.size();j++){
		System.out.println(list.get(j).getName());
	}
	}
}

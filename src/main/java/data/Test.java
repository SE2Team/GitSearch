package data;

import java.io.IOException;
import java.util.ArrayList;


public class Test {
	public static void main(String[] args) throws IOException{
		RepositoryData data=new RepositoryData();
		ArrayList<String> list=data.getRepositoriesNames();
		for(int j=0;j<list.size();j++){
			System.out.println(list.get(j));
		}
	}
}

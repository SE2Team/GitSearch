package data;

import java.io.IOException;
import java.util.ArrayList;

import Util.Repository_Sort;
import Util.UserInfo;
import po.RepositoryPO;
import po.UserPO;


public class Test {
	public static void main(String[] args) throws IOException{
//		RepositoryData testRepository=new RepositoryData();
//		ArrayList<String> a=testRepository.getRepositoriesNames();
//		for(int i=0;i<a.size();i++){
//			System.out.println(a.get(i));
//		}
		GetData data=new GetData();
		String list=data.getString1("https://api.github.com/repos/mojombo/god/collaborators{/collaborator}");
		System.out.println(list);
//		ArrayList<String> list=new ContributorsData().getContributors("https://api.github.com/repos/mojombo/grit/contributors");
//		ArrayList<String> list=new CollaboratorsData().getCollaborators("https://api.github.com/repos/mojombo/god/collaborators{/collaborator}");
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i));
//		}
//		System.out.println(list.size());
	}
}

package data;

import java.io.IOException;
import java.util.ArrayList;

import Util.Repository_Sort;
import Util.UserInfo;
import po.RepositoryPO;
import po.StatisticsPO;
import po.UserPO;


public class Test {
	public static void main(String[] args) throws IOException{
//		RepositoryData testRepository=new RepositoryData();
//		ArrayList<String> a=testRepository.getRepositoriesNames();
//		for(int i=0;i<a.size();i++){
//			System.out.println(a.get(i));
//		}
		//GetData data=new GetData();
	//	String list=data.getString1("https://api.github.com/repos/mojombo/god/collaborators{/collaborator}");
	//	System.out.println(list);
	//	ArrayList<String> list=new ContributorsData().getContributors("https://api.github.com/repos/mojombo/grit/contributors");
	//	ArrayList<String> list=new CollaboratorsData().getCollaborators("https://api.github.com/repos/mojombo/god/collaborators{/collaborator}");
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i));
//		}
//		System.out.println(list.size());
		
//		RepositoryData data=new RepositoryData();
//		ArrayList<RepositoryPO> list=data.getRepositories();
//		StatisticsPO po=new StatisticsData().getScores(list.get(100));
//		System.out.println(po.getCollaborators_num());
//		System.out.println(po.getForks_num());
//		System.out.println(po.getContributors_num());
//		System.out.println(po.getIssues_num());
//		System.out.println(po.getStars_num());
		
		ArrayList<UserPO> list=new UserData().search("mojombo");
//		ArrayList<UserPO> list=new UserData().getUser();
		
		for(int i=0;i<list.size();i++){
		System.out.println(list.get(i).getLogin());
		}
  	}
}

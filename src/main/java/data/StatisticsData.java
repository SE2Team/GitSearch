package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import dataService.StatisticsDataService;
import po.RepositoryPO;
import po.StatisticsPO;

public class StatisticsData implements StatisticsDataService{
	/**
	 * 
	 * 返回的PO数据里如数值为0，则返回NaN
	 * 
	 */
	public StatisticsPO getScores(RepositoryPO po) throws IOException {
		// TODO Auto-generated method stub
		double issues_num;
		double stars_num;
		double forks_num;
		double contributors_num;
		double  collaborators_num;
		ArrayList<String> score = null;
		RepositoryData data=new RepositoryData();
		ArrayList<RepositoryPO> list=data.getRepositories();
		issues_num=list.get(0).getOpen_issues();
		stars_num=list.get(0).getStargazers();
		forks_num=list.get(0).getForks();
		contributors_num=list.get(0).getContributor();
		collaborators_num=list.get(0).getCollaborators_count();
		 for(int j=1;j<list.size()-1;j++){
			 if(issues_num<list.get(j).getOpen_issues()){
				 issues_num=list.get(j).getOpen_issues();
				 }
			 
			 if(stars_num<list.get(j).getStargazers()){
				 stars_num=list.get(j).getStargazers();
			 }
			 
			 if(forks_num<list.get(j).getForks()){
				 forks_num=list.get(j).getForks();
			 }
			 
			 if(contributors_num<list.get(j).getContributor()){
				 contributors_num=list.get(j).getContributor();
			 }
			
			 if(collaborators_num<list.get(j).getCollaborators_count()){
				 collaborators_num=list.get(j).getCollaborators_count();
			 }
			 
		 }
//			 score.add(issues_num+"");
//			 score.add(stars_num+"");
//			 score.add(forks_num+"");
//			 score.add(contributors_num+"");
//			 score.add(collaborators_num+"");
//			 new GetData("score").writeData(score);
		
		 System.out.println(collaborators_num);
		return new StatisticsPO(po.getOpen_issues()/issues_num, po.getStargazers()/stars_num, po.getForks()/forks_num,
				po.getContributor()/contributors_num,po.getCollaborators_count()/collaborators_num);
	}

	public ArrayList<Integer> getStar() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Integer> star=new ArrayList<Integer>();
		int thousand=0;
		int twoThousand=0;
		int over=0;
		ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
		for(int i=0;i<list.size();i++){
			int n=list.get(i).getStargazers();
			if(n<=1000){
				thousand++;
			}else if(n<=2000){
				twoThousand++;
			}else if(n>2000){
				over++;
			}
		}
		star.add(thousand);
		star.add(twoThousand);
		star.add(over);
		return star;
	}

	public ArrayList<Integer> getForks() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Integer> fork=new ArrayList<Integer>();
		int thousand=0;
		int twoThousand=0;
		int over=0;
		ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
		for(int i=0;i<list.size();i++){
			int n=list.get(i).getForks();
			if(n<=100){
				thousand++;
			}else if(n<=1000){
				twoThousand++;
			}else if(n>1000){
				over++;
			}
		}
		fork.add(thousand);
		fork.add(twoThousand);
		fork.add(over);
		return fork;
	}

}

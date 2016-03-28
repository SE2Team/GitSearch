package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListResourceBundle;
import java.util.Map;
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

	
	public ArrayList<Integer> getCreated() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
		int sevenYear=0;
		int eightYear=0;
		int nineYear=0;
		int tenYear=0;
		ArrayList<Integer> list2=new ArrayList<Integer>();
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).getCreated().length()>2){
			String[] str=list.get(i).getCreated().substring(0, 10).split("-");
			String str1=str[0]+str[1]+str[2];
			int year=Integer.parseInt(str1);
		
			if(year<=20080000){
				sevenYear++;
				}
			else if(year>=20080000&&year<=20090000){
					eightYear++;
					
				}
			else if(year<=20100000&&year>=20090000){
				nineYear++;
				}
			else if(year>20100000){
				tenYear++;
				}
			}
		}
		list2.add(sevenYear);
		list2.add(eightYear);
		list2.add(nineYear);
		list2.add(tenYear);
		return list2;
	}

	
	public Map<String, Integer> getLanguage() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Integer> listInt = new ArrayList<Integer>();
		ArrayList<String> listString = new GetData("languages").readData();
		ArrayList<RepositoryPO> list = new RepositoryData().getRepositories();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int j = 0; j < listString.size(); j++) {
			listInt.add(0);
		}

		for (int i = 0; i < list.size(); i++) {
			String language = list.get(i).getLanguage();
			if (language.equals("")) {

			} else {
				int n = listInt.get(listString.indexOf(language)) + 1;
				listInt.set(listString.indexOf(language), n);
			}
		}

		for (int j = 0; j < listString.size(); j++) {
			map.put(listString.get(j), listInt.get(j));
		}

		return map;
	}

}

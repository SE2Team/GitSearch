package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListResourceBundle;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import dataService.StatisticsDataService;
import po.RepositoryPO;
import po.StatisticsPO;
import po.UserPO;

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

	public Map<String, Integer> getStar() throws IOException {
		// TODO Auto-generated method stub
		Map<String, Integer> map=new HashMap<String, Integer>();
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
		map.put("0-1000", thousand);
		map.put("1001-2000", twoThousand);
		map.put("over2000", over);
		return map;
	}

	public Map<String, Integer> getForks() throws IOException {
		// TODO Auto-generated method stub
		Map<String, Integer> map=new HashMap<String, Integer>();
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
		map.put("0-1000", thousand);
		map.put("1001-2000", twoThousand);
		map.put("over2000", over);
		return map;
	}

	
	public Map<String, Integer> getRepoCreated() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
		Map<String, Integer> map=new HashMap<String, Integer>();
		int sevenYear=0;
		int eightYear=0;
		int nineYear=0;
		int tenYear=0;
		
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
		map.put("2007", sevenYear);
		map.put("2008", eightYear);
		map.put("2009", nineYear);
		map.put("2010", tenYear);
		return map;
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
		
		int tempInt = 0;
		String tempString = "";
		for (int i = 0; i < listInt.size(); i++) {
			for (int p = i; p < listInt.size() - 1; p++) {
				if (listInt.get(i) >= listInt.get(p+1)) {
					tempInt = listInt.get(p+1);
					listInt.set(p+1, listInt.get(i));
					listInt.set(i, tempInt);
			
					tempString = listString.get(p+1);
					listString.set(p+1, listString.get(i));
					listString.set(i, tempString);

				}
			}
		}

		for (int j = 0; j < listString.size(); j++) {
			map.put(listString.get(j), listInt.get(j));
		}

		return map;
	}

	public Map<String, Integer> getUserCreated() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<UserPO> list=new UserData().getUser();
		ArrayList<Integer> list2=new ArrayList<Integer>();
		ArrayList<String> list3=new ArrayList<String>();
		for(int i=0;i<9;i++){
			list2.add(0);
			list3.add((2007+i)+"");
			
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getCreated().length()>2){
			String[] str=list.get(i).getCreated().substring(0, 10).split("-");
			String str1=str[0]+str[1]+str[2];
			
			int year=Integer.parseInt(str1);
			if(year<=20080000){
				list2.set(0, list2.get(0)+1);
				
			}
			else if(20080000<year&&year<=20090000){
				list2.set(1, list2.get(1)+1);
				
			}
			else if(20090000<year&&year<=20100000){
				list2.set(2, list2.get(2)+1);
			}
			else if(20100000<year&&year<=20110000){
				list2.set(3, list2.get(3)+1);
			}
			else if(20110000<year&&year<=20120000){
				list2.set(4, list2.get(4)+1);
			}
			else if(20120000<year&&year<=20130000){
				list2.set(5, list2.get(5)+1);
			}
			else if(20130000<year&&year<=20140000){
				list2.set(6, list2.get(6)+1);
			}
			else if(20140000<year&&year<=20150000){
				list2.set(7, list2.get(7)+1);
			}
			else if(20150000<year){
				list2.set(8, list2.get(8)+1);
			}
			
			
				}
			}
		
		for(int p=0;p<9;p++){
			map.put(list3.get(p), list2.get(p));
			
		}
		return map;
	}

	public Map<String, Integer> getUserType() throws IOException {
		// TODO Auto-generated method stub
		int organization=0;
		int user=0;
		ArrayList<UserPO> list=new UserData().getUser();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getType().equals("User")){
				user++;
			}else if(list.get(i).getType().equals("Organization")){
				organization++;
			}else {
				System.out.println("error");
			}
		}
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("User", user);
		map.put("Organization", organization);
//		Map<String, Integer> map=new StatisticsData().getUserType();
//		Set<String> set=map.keySet();
//		Iterator<String> iterator=set.iterator();
//		while(iterator.hasNext()){
//			String key=iterator.next();
//			Integer j=map.get(key);
//			System.out.println(key+":"+j);
//		}
		return map;
	}

	public Map<Integer, Integer> getUserHas() {
		// TODO Auto-generated method stub
//		UserData userData=new UserData();
//		UserPO po=null;
//		ArrayList<UserPO> list=new UserData().getUser();
//		System.out.println("Success");
//		for(int i=0;i<list.size();i++){
//			po=userData.CheckUser(list.get(i).getLogin());
//			new GetData("related").writeDataAdd(list.get(i).getLogin()+";"+po.getRelated().size());
//			
//		}
//		System.out.println("Success");
//上面为统计用户拥有项目数的代码	
		
		ArrayList<String> list = new GetData("has").readData();
		ArrayList<Integer> list2 = new ArrayList<Integer>();//拥有项目数
		ArrayList<Integer> list3=new ArrayList<Integer>();//用户数
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		
		String[] str = new String[2];
		int temp = 0;
		for (int i = 0; i < list.size(); i++) {
			str = list.get(i).split(";");
			temp = Integer.parseInt(str[1]);
			if (list2.contains(temp)) {

			} else {
				list2.add(temp);
			}
		}
		
		//对list2进行从大到小排序
		for (int i = 0; i < list2.size(); i++) {
			list3.add(0);
			for (int p = i; p < list2.size() - 1; p++) {
				if (list2.get(i) > list2.get(p+1)) {
					temp = list2.get(p+1);
					list2.set(p+1, list2.get(i));
					list2.set(i, temp);

				}
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			str = list.get(i).split(";");
			temp = Integer.parseInt(str[1]);
			list3.set(list2.indexOf(temp), list3.get(list2.indexOf(temp))+1);
		}
	
		for(int i=0;i<list2.size();i++){
			map.put(list2.get(i),list3.get(i));	
		}
		
		return map;
	}

	public Map<Integer, Integer> getUserRelated() {
		// TODO Auto-generated method stub
		ArrayList<String> list = new GetData("related").readData();
		ArrayList<Integer> list2 = new ArrayList<Integer>();//拥有项目数
		ArrayList<Integer> list3=new ArrayList<Integer>();//用户数
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		
		String[] str = new String[2];
		int temp = 0;
		for (int i = 0; i < list.size(); i++) {
			str = list.get(i).split(";");
			temp = Integer.parseInt(str[1]);
			if (list2.contains(temp)) {

			} else {
				list2.add(temp);
			}
		}
		
		//对list2进行从大到小排序
		for (int i = 0; i < list2.size(); i++) {
			list3.add(0);
			for (int p = i; p < list2.size() - 1; p++) {
				if (list2.get(i) > list2.get(p+1)) {
					temp = list2.get(p+1);
					list2.set(p+1, list2.get(i));
					list2.set(i, temp);

				}
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			str = list.get(i).split(";");
			temp = Integer.parseInt(str[1]);
			list3.set(list2.indexOf(temp), list3.get(list2.indexOf(temp))+1);
		}
	
		for(int i=0;i<list2.size();i++){
			map.put(list2.get(i),list3.get(i));	
		}
		
		return map;
	}

}

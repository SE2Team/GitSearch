package data;

import dataService.StatisticsDataService;
import po.RepositoryPO;
import po.StaIntPO;
import po.StaStrPO;
import po.UserPO;

import java.io.IOException;
import java.util.ArrayList;

public class StatisticsData implements StatisticsDataService{
	/**
	 * 
	 * 返回的PO数据里如数值为0，则返回NaN
	 * 雷达图
	 * 
	 */
	
	JDBCHelper helper = GetJDBC.getJDBCHelper();
	public StaStrPO getScores(RepositoryPO po) throws IOException {
//		// TODO Auto-generated method stub
//		ArrayList<String> listStr=new ArrayList<>();
//		ArrayList<Integer> listInt=new ArrayList<>();
//		int issues_num=1168;
//		int stars_num=36996;
//		int forks_num=9609;
//		int contributors_num=437;
//		int  collaborators_num=677;
//		
//		if(po.getOpen_issues()>=1000){
//			issues_num=10;
//		}else {
//			issues_num=po.getOpen_issues()/100+1;
//		}
//		
//		if(po.getStargazers()>=30000){
//			stars_num=10;
//		}else{
//			stars_num=po.getStargazers()/3000+1;
//		}
//		
//		if(po.getForks()>=9000){
//			forks_num=10;
//		}else{
//			forks_num=po.getForks()/900+1;
//		}
//		
//		if(po.getContributor()>=400){
//			contributors_num=10;
//		}else{
//			contributors_num=po.getContributor()/40+1;
//		}
//		
//		if(po.getCollaborators_count()>=600){
//			collaborators_num=10;
//		}else{
//			collaborators_num=po.getCollaborators_count()/60+1;
//		}
//		RepositoryData data=new RepositoryData();
//		ArrayList<RepositoryPO> list=data.getRepositories();
//		issues_num=list.get(0).getOpen_issues();
//		stars_num=list.get(0).getStargazers();
//		forks_num=list.get(0).getForks();
//		contributors_num=list.get(0).getContributor();
//		collaborators_num=list.get(0).getCollaborators_count();
//		 for(int j=1;j<list.size()-1;j++){
//			 if(issues_num<list.get(j).getOpen_issues()){
//				 issues_num=list.get(j).getOpen_issues();
//				 }
//			 
//			 if(stars_num<list.get(j).getStargazers()){
//				 stars_num=list.get(j).getStargazers();
//			 }
//			 
//			 if(forks_num<list.get(j).getForks()){
//				 forks_num=list.get(j).getForks();
//			 }
//			 
//			 if(contributors_num<list.get(j).getContributor()){
//				 contributors_num=list.get(j).getContributor();
//			 }
//			
//			 if(collaborators_num<list.get(j).getCollaborators_count()){
//				 collaborators_num=list.get(j).getCollaborators_count();
//			 }
//			 
//		 }
//		 	listStr.add("issues");
//		 	listStr.add("stars");
//		 	listStr.add("forks");
//		 	listStr.add("contributors");
//		 	listStr.add("collaborators");
//		 	System.out.println(issues_num);
//		 	System.out.println(stars_num);
//		 	System.out.println(forks_num);
//		 	System.out.println(contributors_num);
//		 	System.out.println(collaborators_num);
		 	
		 	
		 	
//		 	listInt.add(issues_num);
//		 	listInt.add(stars_num);
//		 	listInt.add(forks_num);
//		 	listInt.add(contributors_num);
//		 	listInt.add(collaborators_num);
		 	return null;
		 
	}

	public StaStrPO getStar() throws IOException {

		
		return helper.getStar();
	}

	public StaStrPO getForks() throws IOException {

		return helper.getFork();
	}

	
	public  StaStrPO getRepoCreated() throws IOException {
		// TODO Auto-generated method stub
		return helper.getRepoCreated();

	}

	
	public StaStrPO getLanguage() throws IOException {
		// TODO Auto-generated method stub
		

		return helper.getLanguage();
	}

	public StaStrPO getUserCreated() throws IOException {
		// TODO Auto-generated method stub
		
		return helper.getUserCreated();

	}

	public StaStrPO getUserType() throws IOException {
		// TODO Auto-generated method stub
//		int organization=0;
//		int user=0;
//		ArrayList<UserPO> list=new UserData().getUser();
//		for(int i=0;i<list.size();i++){
//			if(list.get(i).getType().equals("User")){
//				user++;
//			}else if(list.get(i).getType().equals("Organization")){
//				organization++;
//			}else {
//				System.out.println("error");
//			}
//		}
//		ArrayList<String> listStr=new ArrayList<>();
//		ArrayList<Integer> listInt=new ArrayList<>();
//		listStr.add("User");
//		listStr.add("Organization");
//		listInt.add(user);
//		listInt.add(organization);
//		Map<String, Integer> map=new StatisticsData().getUserType();
//		Set<String> set=map.keySet();
//		Iterator<String> iterator=set.iterator();
//		while(iterator.hasNext()){
//			String key=iterator.next();
//			Integer j=map.get(key);
//			System.out.println(key+":"+j);
//		}
		
//		return new StaStrPO(listStr, listInt);
		return null;
	}

	public StaIntPO getUserHas() {
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
	
		return new StaIntPO(list2, list3);
	}

	public StaIntPO getUserRelated() {
		// TODO Auto-generated method stub
		
		ArrayList<String> list = new GetData("related").readData();
		ArrayList<Integer> list2 = new ArrayList<Integer>();//拥有项目数
		ArrayList<Integer> list3=new ArrayList<Integer>();//用户数
		
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
	
	
		
		return new StaIntPO(list2, list3);
	}

	public StaStrPO getCompany() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<UserPO> list=new UserData().getUser();

		return helper.getCompany();
	}
	
	public Integer getHasNum(String name){
		ArrayList<String> listHas = new GetData("has").readData();
		String[] str=new String[2];
		for(int i=0;i<listHas.size();i++){
			str=listHas.get(i).split(";");
			if(str[0].equals(name)){
				return Integer.parseInt(str[1]);
			}
		}
		return 0;
	}
	
	@SuppressWarnings("unused")
	private StaStrPO sort(ArrayList<Integer> listInt,ArrayList<String> listString){
		int tempInt = 0;
		String tempString = "";
		for (int i = 0; i < listString.size(); i++) {
			for (int p = i; p < listString.size() - 1; p++) {
				if (listInt.get(i) <= listInt.get(p+1)) {
					tempInt = listInt.get(p+1);
					listInt.set(p+1, listInt.get(i));
					listInt.set(i, tempInt);
			
					tempString = listString.get(p+1);
					listString.set(p+1, listString.get(i));
					listString.set(i, tempString);

				}
			}
		}

		
		return new StaStrPO(listString, listInt);
	}

	@Override
	public StaStrPO getCollaborator() {
		// TODO Auto-generated method stub
		ArrayList<String> list=new GetData("collaborator").readData();
		ArrayList<String> listStr = new ArrayList<String>();
		ArrayList<Integer> listInt=new ArrayList<Integer>();
		ArrayList<Integer> listInt1=new ArrayList<Integer>();
		ArrayList<String> listStr2 = new ArrayList<String>();
		ArrayList<Integer> listInt2=new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			String[] str=list.get(i).split(";");
			if(listInt.contains(str.length-1)){
				
			}else{
				listInt.add(str.length-1);
			}
		}
		for(int i=0;i<listInt.size();i++ ){
			listInt1.add(0);
		}
		for(int i=0;i<list.size();i++){
			String[] str=list.get(i).split(";");
			if(listInt.contains(str.length-1)){
				listInt1.set(listInt.indexOf(str.length-1),listInt1.get(listInt.indexOf(str.length-1))+1);
			}else{
				System.out.println("error");
			}
		}
		
		for(int i=0;i<listInt1.size();i++){
			listStr.add(listInt1.get(i)+"");
		}
		
	//	StaStrPO po= this.sort(listInt, listStr);
		listStr2.add("0-25");
		listStr2.add("25-50");
		listStr2.add("50-75");
		listStr2.add("75-100");
		listStr2.add("over100");
		for(int i=0;i<5;i++){
			listInt2.add(0);
		}
		
		
		
		for(int i=0;i<listInt.size();i++){
			if(listInt.get(i)<=25){
				listInt2.set(0, listInt2.get(0)+Integer.parseInt(listStr.get(i)));
			}
			if(listInt.get(i)<=50&&listInt.get(i)>25){
				listInt2.set(1, listInt2.get(1)+Integer.parseInt(listStr.get(i)));
			}
			if(listInt.get(i)<=75&&listInt.get(i)>50){
				listInt2.set(2, listInt2.get(2)+Integer.parseInt(listStr.get(i)));
			}
			if(listInt.get(i)<=100&&listInt.get(i)>75){
				listInt2.set(3, listInt2.get(3)+Integer.parseInt(listStr.get(i)));
			}
			if(listInt.get(i)>100){
				
				listInt2.set(4, listInt2.get(4)+Integer.parseInt(listStr.get(i)));
			}
			
		}
		
		return new StaStrPO(listStr2, listInt2);
	}

	@Override
	public StaStrPO getContributor() {
		// TODO Auto-generated method stub
		ArrayList<String> list=new GetData("contributor").readData();
		ArrayList<String> listStr = new ArrayList<String>();
		ArrayList<Integer> listInt=new ArrayList<Integer>();
		ArrayList<Integer> listInt1=new ArrayList<Integer>();
		ArrayList<String> listStr2 = new ArrayList<String>();
		ArrayList<Integer> listInt2=new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			String[] str=list.get(i).split(";");
			if(listInt.contains(str.length-1)){
				
			}else{
				listInt.add(str.length-1);
			}
		}
		for(int i=0;i<listInt.size();i++ ){
			listInt1.add(0);
		}
		for(int i=0;i<list.size();i++){
			String[] str=list.get(i).split(";");
			if(listInt.contains(str.length-1)){
				listInt1.set(listInt.indexOf(str.length-1),listInt1.get(listInt.indexOf(str.length-1))+1);
			}else{
				System.out.println("error");
			}
		}
		
		for(int i=0;i<listInt1.size();i++){
			listStr.add(listInt1.get(i)+"");
		}
		
	//	StaStrPO po= this.sort(listInt, listStr);
		listStr2.add("0-25");
		listStr2.add("25-50");
		listStr2.add("50-75");
		listStr2.add("75-100");
		listStr2.add("over100");
		for(int i=0;i<5;i++){
			listInt2.add(0);
		}
		
		
		
		for(int i=0;i<listInt.size();i++){
			if(listInt.get(i)<=25){
				listInt2.set(0, listInt2.get(0)+Integer.parseInt(listStr.get(i)));
			}
			if(listInt.get(i)<=50&&listInt.get(i)>25){
				listInt2.set(1, listInt2.get(1)+Integer.parseInt(listStr.get(i)));
			}
			if(listInt.get(i)<=75&&listInt.get(i)>50){
				listInt2.set(2, listInt2.get(2)+Integer.parseInt(listStr.get(i)));
			}
			if(listInt.get(i)<=100&&listInt.get(i)>75){
				listInt2.set(3, listInt2.get(3)+Integer.parseInt(listStr.get(i)));
			}
			if(listInt.get(i)>100){
				
				listInt2.set(4, listInt2.get(4)+Integer.parseInt(listStr.get(i)));
			}
			
		}
		return new StaStrPO(listStr2, listInt2);
	}

	@Override
	public String userTrending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String repoTrending() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public StaStrPO getFollowers(){
		return helper.getFollowers();
	}

	@Override
	public StaStrPO getAll_RepoCreated() {
		
		return helper.getAll_RepoCreated();
	}

	@Override
	public StaStrPO getAll_UserCreated() {
		// TODO Auto-generated method stub
		return helper.getAll_UserCreated();
	}

	@Override
	public StaStrPO getAll_Star() {
		// TODO Auto-generated method stub
		return helper.getAll_Star();
	}

	@Override
	public StaStrPO getAll_Fork() {
		// TODO Auto-generated method stub
		return helper.getAll_Fork();
	}
	
}

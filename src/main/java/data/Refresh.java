package data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

import po.RepositoryPO;
import po.UserPO;

public class Refresh {
	public void updateRepositor() throws IOException{
		GetData data=new GetData();
		String str="]";
	
		for(int i=1;i<65;i++){
			try {
				System.out.println("Success");
				String s1=data.getString1("http://www.gitmining.net/api/repository?page="+i+"");
				str=str.substring(0,str.length()-1)+","+s1.substring(1,s1.length());
			} catch (Exception e) {
				System.out.println("error");
				break;
			}
		}
		
		FileWriter fw = new FileWriter("src/main/java/txtData/repository.json", true);
		fw.write(str );
		fw.close();
		System.out.println("finish");
	}
	
	public void updateUser()throws IOException{
//		ArrayList<String> listColl=new GetData("collaborator").readData();
//		ArrayList<String> listCont=new GetData("contributor").readData();
//		ArrayList<String> list=new ArrayList<>();
//		GetData data=new GetData();
//		
//		for(int i=0;i<listColl.size();i++){
//			String[] strings=listColl.get(i).split(";");
//			for(int p=0;p<strings.length-1;p++){
//				if(strings[p].length()>2){
//				if(list.contains(strings[p].substring(1,strings[p].length()-1 ))){
//					
//				}else{
//					list.add(strings[p].substring(1,strings[p].length()-1 ));
//				}
//				}
//			}
//			
//		}
//		
//		for(int i=0;i<listCont.size();i++){
//			String[] strings1=listCont.get(i).split(";");
//			for(int p=0;p<strings1.length-1;p++){
//				if(strings1[p].length()>2){
//				if(list.contains(strings1[p].substring(1,strings1[p].length()-1 ))){
//					
//				}else{
//					list.add(strings1[p].substring(1,strings1[p].length()-1 ));
//				}
//				}
//			}
//		}
		ArrayList<String> list=new GetData("user_names").readData();
		GetData data=new GetData();
		String string="";
		for(int i=0;i<list.size();i++){
			try {
				string=string+","+data.getString1("http://www.gitmining.net/api/user/"+list.get(i));	
			} catch (Exception IOException) {
				// TODO: handle exception
				continue;
			}
			System.out.println("j");
		}
		string="["+string+"]";
		FileWriter fw = new FileWriter("src/main/java/txtData/user.json", true);
		fw.write(string );
		fw.close();
		System.out.println("finish");
		
	} 
	
	public void updateHas()throws IOException{
		UserData userData=new UserData();
		UserPO po=null;
		ArrayList<UserPO> list=new UserData().getUser();
		GetData data= new GetData("has");
		System.out.println("Success");
		for(int i=0;i<list.size();i++){
			po=userData.CheckUser(list.get(i).getLogin());
			data.writeDataAdd(list.get(i).getLogin()+";"+po.getHas().size());
			
		}
		System.out.println("Success");
	} 
	
	public void updateRelated()throws IOException{

		UserData userData=new UserData();
		UserPO po=null;
		ArrayList<UserPO> list=new UserData().getUser();
		GetData data= new GetData("related");
		System.out.println("Success");
		for(int i=0;i<list.size();i++){
			po=userData.CheckUser(list.get(i).getLogin());
			data.writeDataAdd(list.get(i).getLogin()+";"+po.getRelated().size());
			
		}
		System.out.println("Success");
	} 
	
	public void updatedC() throws IOException{
		RepositoryData data=new RepositoryData();
		GetData data2=new GetData("contributor");
	//	GetData data3=new GetData("collaborator");
		ArrayList<RepositoryPO> list=data.getRepositories();
	//	System.out.println(list.size());
		String str="";
		RepositoryPO po=null; 
		String[] split=new String[2];
		
		for(int i=0;i<list.size();i++){
			str="";
			split=list.get(i).getName().split("/");
			po=data.checkRepository(split[0], split[1]);
			for(int j=0;j<po.getContributors().size();j++){
				str=po.getContributors().get(j)+";"+str;
			}
			str=str+";"+list.get(i).getName();
			data2.writeDataAdd(str);
			System.out.println(i);
//			str="";
//			for(int j=0;j<po.getCollaborators().size();j++){
//				str=po.getCollaborators().get(j)+";"+str;
//			}
//			str=str+";"+list.get(i).getName();
//			data3.writeDataAdd(str);
		}
	} 
	
	public void updatedCompany() throws IOException{
		ArrayList<UserPO> list=new UserData().getUser();
		ArrayList<String> list2=new ArrayList<String>();
		
		for(int i=0;i<list.size();i++){
			if(list2.contains(list.get(i).getCompany())==false){
				list2.add(list.get(i).getCompany());
			}
		}//获取用户所属公司
		new GetData("company").writeData(list2);
		System.out.println("Success");
		
	}
	
	public void updatedRepo_names() throws IOException{
		ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
		ArrayList<String> list2=new ArrayList<String>();
		
		for(int i=0;i<list.size();i++){
			
				list2.add(list.get(i).getName());
			
		}
		new GetData("repo_names").writeData(list2);
		System.out.println("Success");
		
	}
	
	public void updatedLangeuage() throws IOException{
		ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
		ArrayList<String> list2=new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			if(list2.contains(list.get(i).getLanguage())){
				
			}else{
				list2.add(list.get(i).getLanguage());
			}
			
		
		}
		new GetData("languages").writeData(list2);
		System.out.println("Success");
	}
	
	public void updatesUser_names() throws IOException{
		ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
		ArrayList<String> list2=new ArrayList<String>();
		
		for(int i=0;i<list.size();i++){
			String[] str=list.get(i).getName().split("/");
			if(list2.contains(str[0])){
				
			}else{
				list2.add(str[0]);
			}
			
		}
		new GetData("user_names").writeData(list2);
		System.out.println("Success");
	}
}

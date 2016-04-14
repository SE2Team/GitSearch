package po;

import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
//id,login,type,name

//company,blog,location,email,bio

//public_repos,public_gists,followers,following

//created_at,updated_at
public class UserPO {
	int id=0;
	String login="";
	String type="";
	String name="";
	String company="";
	String email="";
	String public_repos="";
	int public_gists=0;
	int  followers=0;
	int following=0;
	String created_at="";
	String updated_at="";
	ArrayList<String> related;
	ArrayList<String> has;

	public UserPO(int id, String login, String type, String name, String company, String email,
			 String public_repos, int public_gists, int followers, int following, String created_at,
			String updated_at,ArrayList<String> related,ArrayList<String> has) {
			this.related=related;
			this.has=has;
			this.id=id;
			this.login=login;
			this.type=type;
			this.name=name;
			this.company=company;
			this.email=email;
			this.public_gists=public_gists;
			this.public_repos=public_repos;
			this.followers=followers;
			this.following=following;
			this.created_at=created_at;
			this.updated_at=updated_at;

	}
	
	public String getUpdated(){
		String s1="";
		char[] c=updated_at.toCharArray();
		String[] str=new String[c.length];
		for(int i=0;i<c.length;i++){
			str[i]=c[i]+"";
			if(str[i].equals("T")){
				str[i]="-";
			}else if(str[i].equals("Z")){
				str[i]="";
			}
			s1=s1+str[i];
		}
		return s1;
	}
	
	public String getCreated(){
		String s1="";
		char[] c=created_at.toCharArray();
		String[] str=new String[c.length];
		for(int i=0;i<c.length;i++){
			str[i]=c[i]+"";
			if(str[i].equals("T")){
				str[i]="-";
			}else if(str[i].equals("Z")){
				str[i]="";
			}
			s1=s1+str[i];
		}
		return s1;
	}
	
	public int getFollowing(){
		return this.following;
	}
	
	public int getFollowers(){
		return this.followers;
	}
	
	public String getRepos(){
		return this.public_repos;
	}
	
	public int getGists(){
		return this.public_gists;
	}
	

	
	public String getEmail(){
		return this.email;
	}
	
	
	public String getCompany(){
		return this.company;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	public int getId(){
		return this.id;
	}

	public ArrayList<String> getRelated(){
		return this.related;
	}
	public ArrayList<String> getHas(){
		return this.has;
	}
	
	public void setHas( ArrayList<String> has){
		this.has=has;
	}
	
	public void setRelated( ArrayList<String> related){
		this.related=related;
	}
}

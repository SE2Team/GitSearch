package po;

import java.sql.Date;
import java.util.ArrayList;

import com.sun.prism.Image;

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
	Date created_at;
	Date updated_at;
	ArrayList<String> related;
	ArrayList<String> has;
	javafx.scene.image.Image userImage;

	public UserPO(int id, String login, String type, String name, String company, String email,
			 String public_repos, int public_gists, int followers, int following, Date created_at,
			 Date updated_at,ArrayList<String> related,ArrayList<String> has,javafx.scene.image.Image userImage) {
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
			this.userImage=userImage;

	}
	
	
	public Date getUpdated(){
		 return this.updated_at;
	}
	
	public javafx.scene.image.Image getUserImage(){
		return this.userImage;
	}
	
	public Date getCreated(){
		return this.created_at;
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

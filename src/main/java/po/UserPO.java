package po;

import org.kohsuke.github.GHPersonSet;
import org.kohsuke.github.GHUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by moeyui on 2016/3/4 0004.
 */

public class UserPO extends GHUser {

    GHUser user;
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

    public UserPO(int id, String login, String type, String name, String company, String email,
			 String public_repos, int public_gists, int followers, int following, Date created_at,
			Date updated_at,ArrayList<String> related,ArrayList<String> has) {
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
	
    public Date getUpdated(){
		 return this.updated_at;
	}
	
	public Date getCreated(){
		return this.created_at;
	}
	
	public int getFollowing(){
		return this.following;
	}
	
	public int getFollower(){
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
	

	
	///////////////////////////////////


	public UserPO(GHUser parent) {
        user=parent;
	}



    public String getUserImage(){
        return getAvatarUrl();
    }

    public int getGists1(){
        return this.public_gists;
    }









}
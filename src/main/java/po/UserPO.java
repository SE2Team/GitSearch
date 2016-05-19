package po;

import org.kohsuke.github.GHUser;


import java.io.IOException;

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
	String public_repos;
	int public_gists=0;
	int  followers=0;
	int following=0;
	Date created_at;
	Date updated_at;
	;

    public UserPO(int id, String login, String type, String name, String company, String email,
			 String public_repos, int public_gists, int followers, int following, Date created_at,
			Date updated_at) {
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
	
    public Date getUpdated() throws IOException{
    	if(user==null){
    		return this.updated_at;
    	}
		 return user.getUpdatedAt();
	}
	
	public Date getCreated() throws IOException{
		if(user==null){
			return this.created_at;
    	}
		return user.getCreatedAt();
	}
	
	public int getFollowing() throws IOException{
	if(user==null)
		return this.following;
	else
		return user.getFollowingCount();
	}
	
	public int getFollower() throws IOException{
		if(user==null)
			return this.followers;
		else 
			return user.getFollowersCount();
	}
	
	public String getRepos() throws IOException {
		if(user==null)
			return this.public_repos;
		else
			return user.getPublicRepoCount()+"";
	}
	
	public int getGists1() throws IOException{
		if(user==null)
			return this.public_gists;
		else
			return user.getPublicGistCount();
	}
	

	
	public String getEmail() throws IOException{
		if(user==null)
			return this.email;
		else 
			return user.getEmail();
					
	}
	
	
	public String getCompany() throws IOException{
		if(user==null)
			return this.company;
		else
			return user.getCompany();
	}
	
	public String getName() throws IOException{
		if(user==null)
			return this.name;
		else 
			return user.getName();
	}
	
	public String getType(){
	
		return this.type;
	}
	
	public String getLogin(){
	if(user==null)
		return this.login;
	else
		return user.getLogin();
	}
	
	public int getId(){
		if(user==null)
			return this.id;
		else
			return user.getId();
	}

	

	
	///////////////////////////////////


	public UserPO(GHUser parent) {
        user=parent;
	}



    public String getUserImage(){
        return getAvatarUrl();
    }

    public int getGists(){
        return this.public_gists;
    }









}
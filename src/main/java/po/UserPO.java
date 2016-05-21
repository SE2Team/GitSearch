package po;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.PagedIterable;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

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
	int public_repos;
	int public_gists=0;
	int  followers=0;
	int following=0;
	Date created_at;
	Date updated_at;
	int followersDeviation;

    public UserPO(int id, String login, String type, String name, String company, String email,
			 int public_repos, int public_gists, int followers, int following, Date created_at,
			Date updated_at,int followersDeviation) {
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
			this.followersDeviation=followersDeviation;

	}
    
    public UserPO(GHUser parent) {
        user=parent;
	}
    
    public int getFollowersDeviation(){
    	return this.followersDeviation;
    }
	
    public Date getUpdatedAt() throws IOException{
    	if(user==null){
    		return this.updated_at;
    	}
		 return user.getUpdatedAt();
	}
	
	public Date getCreatedAt() throws IOException{
		if(user==null){
			return this.created_at;
    	}
		return user.getCreatedAt();
	}
	
	public int getFollowingCount() throws IOException{
	if(user==null)
		return this.following;
	else
		return user.getFollowingCount();
	}
	
	public int getFollowersCount() throws IOException{
		if(user==null)
			return this.followers;
		else 
			return user.getFollowersCount();
	}
	
	public int getPublicRepoCount() throws IOException {
		if(user==null)
			return this.public_repos;
		else
			return user.getPublicRepoCount();
	}
	
	public int getPublicGistCount() throws IOException{
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

	public Map<String, GHRepository> getRepositories() throws IOException{
		return user.getRepositories();
	}
	

	
	///////////////////////////////////


	


    public String getUserImage(){
    	if(user==null)
    		return null;
    	else
    		return user.getAvatarUrl();
    }

    public int getGists(){
        return this.public_gists;
    }

	public GHUser getDpo() {
		return user;
	}
	
}
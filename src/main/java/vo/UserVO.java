package vo;

import po.RepositoryPO;

import java.io.IOException;
import java.util.ArrayList;

import businesslogic.userBL.User;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class UserVO {
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
    int hasNum=0;

    public UserVO(int id, String login, String type, String name, String company, String email,
                  String public_repos, int public_gists, int followers, int following, String created_at,
                  String updated_at,ArrayList<String> related,ArrayList<String> has) {
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
        this.related=related;
        this.has=has;

    }

    public String getUpdated(){
        return this.updated_at;
    }

    public String getCreated(){
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

    public Integer getHasNum() throws IOException{
    	return new User().checkUser(name).getHas().size();
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

}

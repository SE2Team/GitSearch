package po;

import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class UserPO {
    String name;
    String regTime;
    int followers,following;
    String email;
    String company;
    ArrayList<RepositoryPO> contribute;
    ArrayList<RepositoryPO> repos;

    @Deprecated
    public UserPO() {
    }
    @Deprecated
    public UserPO(String name, String regTime, ArrayList<RepositoryPO> contribute, ArrayList<RepositoryPO> repos) {
        this.name = name;
        this.regTime = regTime;
        this.contribute = contribute;
        this.repos = repos;
    }

    public UserPO(String name, String regTime, int followers, int following, String email, String company,
                  ArrayList<RepositoryPO> contribute, ArrayList<RepositoryPO> repos) {
        this.name = name;
        this.regTime = regTime;
        this.followers = followers;
        this.following = following;
        this.email = email;
        this.company = company;
        this.contribute = contribute;
        this.repos = repos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public ArrayList<RepositoryPO> getContribute() {
        return contribute;
    }

    public void setContribute(ArrayList<RepositoryPO> contribute) {
        this.contribute = contribute;
    }

    public ArrayList<RepositoryPO> getRepos() {
        return repos;
    }


    public void setRepos(ArrayList<RepositoryPO> repos) {
        this.repos = repos;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}

package vo;

import po.RepositoryPO;

import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class UserVO {
    String name;
    String regTime;
    int followers,following;
    String email;
    String company;
    ArrayList<RepositoryVO> contribute;
    ArrayList<RepositoryVO> repos;

    @Deprecated
    public UserVO() {
    }
    @Deprecated
    public UserVO(String name, String regTime, ArrayList<RepositoryVO> contribute, ArrayList<RepositoryVO> repos) {
        this.name = name;
        this.regTime = regTime;
        this.contribute = contribute;
        this.repos = repos;
    }

    public UserVO(String name, String regTime, int followers, int following, String email, String company,
                  ArrayList<RepositoryVO> contribute, ArrayList<RepositoryVO> repos) {
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

    public ArrayList<RepositoryVO> getContribute() {
        return contribute;
    }

    public void setContribute(ArrayList<RepositoryVO> contribute) {
        this.contribute = contribute;
    }

    public ArrayList<RepositoryVO> getRepos() {
        return repos;
    }


    public void setRepos(ArrayList<RepositoryVO> repos) {
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

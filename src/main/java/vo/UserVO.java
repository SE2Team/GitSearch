package vo;

import po.RepositoryPO;

import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class UserVO {
    int id = 0;
    String login = "";
    String type = "";
    String name = "";
    String company = "";
    String email = "";
    String public_repos = "";
    int public_gists = 0;
    int followers = 0;
    int following = 0;
    String created_at = "";
    String updated_at = "";

    public UserVO(int id, String login, String type, String name, String company, String email,
                  String public_repos, int public_gists, int followers, int following, String created_at,
                  String updated_at) {
        this.id = id;
        this.login = login;
        this.type = type;
        this.name = name;
        this.company = company;
        this.email = email;
        this.public_gists = public_gists;
        this.public_repos = public_repos;
        this.followers = followers;
        this.following = following;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getPublic_repos() {
        return public_repos;
    }

    public int getPublic_gists() {
        return public_gists;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}

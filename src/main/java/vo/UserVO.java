package vo;

import javafx.scene.image.Image;
import po.UserPO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by moeyui on 2016/3/4 0004.
 */

public class UserVO  {
    int id=0;
    String login="";
    String type="";
    String name="";
    String company="";
    String email="";
    int public_repos=0;
    int public_gists=0;
    int  followers=0;
    int following=0;
    String created_at = "";
    String  updated_at = "";
    javafx.scene.image.Image userImage;
    @Deprecated
    public UserVO(int id, String login, String type, String name, String company, String email,
                  String public_repos, int public_gists, int followers, int following, Date created_at,
                  Date updated_at, ArrayList<String> related, ArrayList<String> has) {


    }

    public UserVO(UserPO po) throws IOException {
        id=po.getId();
        login=po.getLogin();
        type="user";
        name=po.getName();
        company=po.getCompany();
        email=po.getEmail();
        public_gists=po.getGists();
        public_repos=po.getPublicRepoCount();
        followers=po.getFollowersCount();
        following=po.getFollowingCount();
        created_at= String.valueOf(po.getCreatedAt());
        updated_at= String.valueOf(po.getUpdatedAt());

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

    public int getPublic_repos() {
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

    public Image getUserImage() {
        return userImage;
    }
}
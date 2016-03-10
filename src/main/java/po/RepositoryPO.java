package po;

import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class RepositoryPO {
    public RepositoryPO(String name, String description, String language, ArrayList<UserPO> contributors,
                        ArrayList<UserPO> collaborators, ArrayList<RepositoryPO> forks, int stars,
                        int followers, int subs) {
        this.name = name;
        this.description = description;
        this.language = language;
        this.contributors = contributors;
        this.collaborators = collaborators;
        this.forks = forks;
        this.stars = stars;
        this.followers = followers;
        this.subs = subs;
    }

    @Deprecated
    public RepositoryPO(String name, String description, String language, ArrayList<UserPO> contributors, ArrayList<UserPO>
            collaborators, ArrayList<RepositoryPO> forks) {
        this.description = description;
        this.language = language;
        this.contributors = contributors;
        this.collaborators = collaborators;
        this.forks = forks;
    }
    @Deprecated
    public RepositoryPO() {
    }
    String name;
    String description;
    String language;
    ArrayList<UserPO> contributors;
    ArrayList<UserPO> collaborators;
    ArrayList<RepositoryPO> forks;
    int stars;
    int followers;
    int subs;//关注人数


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<UserPO> getContributors() {
        return contributors;
    }

    public void setContributors(ArrayList<UserPO> contributors) {
        this.contributors = contributors;
    }

    public ArrayList<UserPO> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(ArrayList<UserPO> collaborators) {
        this.collaborators = collaborators;
    }

    public ArrayList<RepositoryPO> getForks() {
        return forks;
    }

    public void setForks(ArrayList<RepositoryPO> forks) {
        this.forks = forks;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getSubs() {
        return subs;
    }

    public void setSubs(int subs) {
        this.subs = subs;
    }
}

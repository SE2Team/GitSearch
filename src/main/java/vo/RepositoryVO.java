package vo;

import po.UserPO;

import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class RepositoryVO {
    public RepositoryVO(String description, String language, ArrayList<UserPO> contributors, ArrayList<UserPO>
            collaborators, ArrayList<RepositoryVO> forks) {
        this.description = description;
        this.language = language;
        this.contributors = contributors;
        this.collaborators = collaborators;
        this.forks = forks;
    }

    public RepositoryVO() {
    }

    String description;
    String language;
    ArrayList<UserPO> contributors;
    ArrayList<UserPO> collaborators;
    ArrayList<RepositoryVO> forks;

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

    public ArrayList<RepositoryVO> getForks() {
        return forks;
    }

    public void setForks(ArrayList<RepositoryVO> forks) {
        this.forks = forks;
    }
}

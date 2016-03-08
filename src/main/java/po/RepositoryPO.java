package po;

import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class RepositoryPO {
    public RepositoryPO(String description, String language, ArrayList<UserVO> contributors, ArrayList<UserVO>
            collaborators, ArrayList<RepositoryPO> forks) {
        this.description = description;
        this.language = language;
        this.contributors = contributors;
        this.collaborators = collaborators;
        this.forks = forks;
    }

    public RepositoryPO() {
    }

    String description;
    String language;
    ArrayList<UserVO> contributors;
    ArrayList<UserVO> collaborators;
    ArrayList<RepositoryPO> forks;

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

    public ArrayList<UserVO> getContributors() {
        return contributors;
    }

    public void setContributors(ArrayList<UserVO> contributors) {
        this.contributors = contributors;
    }

    public ArrayList<UserVO> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(ArrayList<UserVO> collaborators) {
        this.collaborators = collaborators;
    }

    public ArrayList<RepositoryPO> getForks() {
        return forks;
    }

    public void setForks(ArrayList<RepositoryPO> forks) {
        this.forks = forks;
    }
}

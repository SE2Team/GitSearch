package vo;

import java.util.ArrayList;

import po.UserPO;

import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class RepositoryVO {
    String name;
    int id;
    String owner_type;
    String html_url;
    String description;
    boolean fork;
    String created;
    String updated;
    String pushed;
    int size = 0;
    int stargazers_count = 0;
    String language;
    int forks;
    int contributor = 0;
    int open_issues = 0;
    int subscribers_count = 0;
    int collaborators_count = 0;// 合作者
    ArrayList<String> collaborators;
    ArrayList<String> contributors;


    public RepositoryVO(String name, int id, String owner_type, String html_url, String description, Boolean fork,
                        String created, String updated, String pushed, int size, int stargazers_count, String language, int forks,
                        int open_issues, int subscribers_count, int contributor, int collaborators_count,
                        ArrayList<String> collaborators, ArrayList<String> contributors) {

        this.name = name;
        this.subscribers_count = subscribers_count;// 订阅者
        this.open_issues = open_issues;
        this.forks = forks;
        this.language = language;
        this.stargazers_count = stargazers_count;// 点赞者
        this.size = size;
        this.pushed = pushed;
        this.updated = updated;
        this.created = created;
        this.fork = fork;
        this.id = id;
        this.owner_type = owner_type;
        this.html_url = html_url;
        this.description = description;
        this.contributor = contributor;
        this.collaborators_count = collaborators_count;
        this.collaborators = collaborators;
        this.contributors = contributors;


    }


    public ArrayList<String> getContributors() {
        return this.contributors;
    }

    public ArrayList<String> getCollaborators() {
        return this.collaborators;
    }

    public int getContributor() {
        return this.contributor;
    }

    public int getSubscribers_count() {
        return this.subscribers_count;
    }

    public int getOpen_issues() {
        return this.open_issues;
    }

    public int getForks() {
        return this.forks;
    }

    public String getLanguage() {
        return this.language;
    }

    public int getStargazers() {
        return this.stargazers_count;
    }

    public int getSize() {
        return this.size;
    }

    public String getPushed() {
        return this.pushed;
    }

    public String getUpdated() {
    	return this.updated.split("T")[0];
    }

    public String getCreated() {
    	return this.created.split("T")[0];
    }

    public boolean getFork() {
        return this.fork;
    }

    public int getId() {
        return this.id;
    }

    public String getOwner_type() {
        return this.owner_type;
    }

    public String getHtml_url() {
        return this.html_url;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public int getCollaborators_count() {
        return this.collaborators_count;
    }

    public String getOwnerName(){
    	if(this.name.indexOf("/")!=-1){
    		return this.name.split("/")[0];
    	}else{
    		return null;
    	}
    }
    
    public String getRepoName(){
    	if(this.name.indexOf("/")!=-1){
    		return this.name.split("/")[1];
    	}else{
    		return null;
    	}
    }

}

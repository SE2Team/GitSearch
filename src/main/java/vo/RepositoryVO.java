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

    public RepositoryVO(String name, int id, String owner_type, String html_url, String description, boolean fork,
                        String created, String updated, String pushed, int size, int stargazers_count,
                        String language, int forks, int contributor, int open_issues, int subscribers_count) {
        this.name = name;
        this.id = id;
        this.owner_type = owner_type;
        this.html_url = html_url;
        this.description = description;
        this.fork = fork;
        this.created = created;
        this.updated = updated;
        this.pushed = pushed;
        this.size = size;
        this.stargazers_count = stargazers_count;
        this.language = language;
        this.forks = forks;
        this.contributor = contributor;
        this.open_issues = open_issues;
        this.subscribers_count = subscribers_count;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getOwner_type() {
        return owner_type;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getDescription() {
        return description;
    }

    public boolean getFork() {
        return fork;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    public String getPushed() {
        return pushed;
    }

    public int getSize() {
        return size;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public String getLanguage() {
        return language;
    }

    public int getForks() {
        return forks;
    }

    public int getContributor() {
        return contributor;
    }

    public int getOpen_issues() {
        return open_issues;
    }

    public int getSubscribers_count() {
        return subscribers_count;
    }
}

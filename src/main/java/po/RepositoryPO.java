package po;

import org.kohsuke.github.GHRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by moeyui on 2016/3/4 0004.
 */

public class RepositoryPO  extends GHRepository{

    GHRepository repository;

    public RepositoryPO(GHRepository repository) {
        this.repository = repository;
    }
    String name;
    int id;
	String owner_type;
	String html_url;
	String description;
	boolean fork;
	Date created;
	Date updated;
	Date pushed;
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
	

	public RepositoryPO(String name, int id, String owner_type, String html_url, String description, Boolean fork,
			Date created, Date  updated, Date  pushed, int size, int stargazers_count, String language, int forks,
			int open_issues, int subscribers_count, int contributor, int collaborators_count,
			 ArrayList<String> contributors) {

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
		this.contributors = collaborators;
		

	}

	
	public ArrayList<String> getContributors() {
		return this.contributors;
	}

	
	public void setContributors(ArrayList<String> list) {
		this.contributors=list;
	}
	
	public void setCollaborators(ArrayList<String> list) {
		this.collaborators=list;
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

	public Date getPushed() {
		return this.pushed;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public Date getCreated() {
		return this.created;
	}
	public void setContributor(int contributor){
		this.contributor=contributor;
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


///////////////////////////////////////////////////
		public int getOpen_issues1() {
	        return repository.getOpenIssueCount();
	    }

	    public int getStargazers1() {
	        return repository.getWatchers();
	    }



	    public Date getPushed1() {
	        return repository.getPushedAt();
	    }

	    public Date getUpdated1() throws IOException {
	        return repository.getUpdatedAt();
	    }

	    public Date getCreated1() throws IOException {
	        return repository.getCreatedAt();
	    }



	    public boolean getFork1() {
	        return repository.isFork();
	    }


	    public String getOwner_type1() {
	        return "user";
	    }

	    public String getHtml_url1() {
	        return repository.getHtmlUrl().toString();
	    }

 
}

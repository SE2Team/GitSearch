package po;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.PagedIterable;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import businesslogic.userBL.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by moeyui on 2016/3/4 0004.
 */

public class RepositoryPO {

    GHRepository repository;

    public RepositoryPO(GHRepository repository) {
        this.repository = repository;
    }
    String name;
    int id;
	String owner_type;
	URL html_url;
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
	ArrayList<String> contributors;
	int starDeviation;
	int forkDeviation;
	
	

	public RepositoryPO(String name, int id, String owner_type, URL html_url, String description, Boolean fork,
			Date created, Date  updated, Date  pushed, int size, int stargazers_count, String language, int forks,
			int open_issues, int subscribers_count, int contributor,
			 ArrayList<String> contributors,int starDeviation,
	int forkDeviation) {

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
		this.contributors = contributors;
		this.starDeviation=starDeviation;
		this.forkDeviation=forkDeviation;
		

	}
	
	public int getStarDevation(){
		return this.starDeviation;
	}
	
	public int getForkDevation(){
		return this.forkDeviation;
	}
	
	public ArrayList<String> getContributors() {
		return this.contributors;
	}

	
	public void setContributors(ArrayList<String> list) {
		this.contributors=list;
	}


	public int getSubscribersCount() {
		if(repository==null)
			return this.subscribers_count;
		else
			return repository.getSubscribersCount();
	}

	public int getOpenIssueCount() {
		if(repository==null)
			return this.open_issues;
		else 
			return repository.getOpenIssueCount();
	}

	public int getForks() {
		if(repository==null)
			return this.forks;
		else
			return repository.getForks();
	}

	public String getLanguage() {
		if(repository==null)
			return this.language;
		else
			return repository.getLanguage();
	}

	public int getWatchers() {
		if(repository==null)
			return this.stargazers_count;
		else
			 return repository.getWatchers();
	}

	public int getSize() {
		if(repository==null)
			return this.size;
		else
			return repository.getSize();
	}

	public Date getPushedAt(){
		if(repository==null)
			return this.pushed;
		else
			return repository.getPushedAt();
	}

	public Date getUpdatedAt()throws IOException {
		if(repository==null)
			return this.updated;
		else
			return repository.getUpdatedAt();
	}

	public Date getCreatedAt() throws IOException {
		if(repository==null)
			return this.created;
		else
			return repository.getCreatedAt();
	}
	public void setContributor(int contributor){
		this.contributor=contributor;
	}

	
	public boolean isFork() {
	if(repository==null)	
		return this.fork;
	else
		return repository.isFork();
	}

	public int getId() {
		if(repository==null)
			return this.id;
		else
			return repository.getId();
	}

	public String getOwner_type() {
		return this.owner_type;
	}

	public URL getHtmlUrl() {
		if(repository==null)
			return this.html_url;
		else
			return repository.getHtmlUrl();
	}

	public String getDescription() {
		if(repository==null)
			return this.description;
		else
			return repository.getDescription();
	}

	public String getFullName(){
		if(repository==null)
			return this.name;
		else
			return repository.getFullName();
	}

	public PagedIterable<GHRepository.Contributor> listContributors() throws IOException{
		if(repository==null){
			return null;
		}
		return repository.listContributors();
	}
	
	public GHRepository getRepository() {
		return repository;
	}
 
}

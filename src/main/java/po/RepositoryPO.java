package po;


/**
 * Created by moeyui on 2016/3/4 0004.
 */

/**owner_name:项目所有者登录名 owner_id:所有者的id owner_type:所有者的用户类型（分为User和Organization）

html_url:项目主页url description:项目描述 fork:是否是fork了他人项目所产生的项目

created_at:创建时间 updated_at:更新时间 pushed_at:最后一次push的时间

size:项目大小 stargazers_count:点赞人数 language:项目主语言 forks:被fork的次数 
open_issues:open的issue数 subscribers_count:关注者数量

**/
public class RepositoryPO {
   String name;
   int id;
   String owner_type;
   String html_url;
   String description;
   String fork;
   String created;
   String updated;
   String pushed;
   int size=0;
   int  stargazers_count=0;
   String language;
   int forks;
   int contributor=0;
   int  open_issues=0;
   int subscribers_count=0;
   
   
   
	public RepositoryPO(String name, int id, String owner_type, String html_url, String description, String fork,
			String created, String updated, String pushed, int size, int stargazers_count, String language,
			int forks, int open_issues, int subscribers_count,   int contributor)

	{
		this.subscribers_count = subscribers_count;//订阅者
		this.open_issues = open_issues;
		this.forks = forks;
		this.language = language;
		this.stargazers_count = stargazers_count;//点赞者
		this.size = size;
		this.pushed = pushed;
		this.updated = updated;
		this.created = created;
		this.fork = fork;
		this.id = id;
		this.owner_type = owner_type;
		this.html_url = html_url;
		this.description = description;
		this.contributor=contributor;

	}
	
	public int getContributor(){
		return this.contributor;
	}
	
	public int getSubscribers_count(){
		return this.subscribers_count;
	}
	
	public int getOpen_issues(){
		return this.open_issues;
	} 
	
	public int getForks(){
		return this.forks;
	}
	
	public String getLanguage(){
		return this.language;
	}
	
	public int getStargazers(){
		return this.stargazers_count;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public String getPushed(){
		return this.pushed;
	}
	
	public String getUpdated(){
		return this.updated;
	}
	
	public String getCreated(){
		return this.created;
	}
	
	public String getFork(){
		return this.fork;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getOwner_type(){
		return this.owner_type;
	}
	
	public String getHtml_url(){
		return this.html_url;
	}
	
	public  String getDescription(){
		return this.description;
	}
	
   
}

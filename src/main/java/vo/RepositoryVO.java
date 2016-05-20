package vo;

import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.PagedIterable;
import po.RepositoryPO;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Map;

/**
 * Created by moeyui on 2016/3/4 0004.
 */

/**
 * owner_name:项目所有者登录名/项目名 owner_id:所有者的id owner_type:所有者的用户类型（分为User和Organization）
 * <p>
 * html_url:项目主页url description:项目描述 fork:是否是fork了他人项目所产生的项目
 * <p>
 * created_at:创建时间 updated_at:更新时间 pushed_at:最后一次push的时间
 * <p>
 * size:项目大小 stargazers_count:点赞人数 language:项目主语言 forks:被fork的次数
 * open_issues:open的issue数 subscribers_count:关注者数量
 **/
public class RepositoryVO {
    String name;
    String fullName;
    int id;
    String owner_type;
    URL html_url;
    String description;
    boolean fork;
    String created="";
    String updated="";
    String pushed="";
    int size = 0;
    int stargazers_count = 0;
    String language;
    int forks;
    PagedIterable<GHRepository.Contributor> contributors;
    RepositoryPO dpo;

    int open_issues = 0;
    int subscribers_count = 0;

    @Deprecated
    public RepositoryVO(String name, int id, String owner_type, String html_url, String description, Boolean fork,
                        Date created, Date updated, Date pushed, int size, int stargazers_count, String language, int forks,
                        int open_issues, int subscribers_count, int contributor) {


    }

    public RepositoryVO(RepositoryPO po) throws IOException {
        dpo=po;
        name=po.getFullName();
        fullName=po.getFullName();
        id=po.getId();
        owner_type=po.getOwner_type();
        html_url=po.getHtmlUrl();
        description=po.getDescription();
        fork=po.isFork();
        created= String.valueOf(po.getCreatedAt());
        updated= String.valueOf(po.getUpdatedAt());
        pushed= String.valueOf(po.getPushedAt());
        size=po.getSize();
        stargazers_count=po.getWatchers();
        language=po.getLanguage();
        forks=po.getForks();
        open_issues=po.getOpenIssueCount();
        subscribers_count=po.getSubscribersCount();
        contributors = po.listContributors();
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    public String getOwner_type() {
        return owner_type;
    }

    public URL getHtml_url() {
        return html_url;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFork() {
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

    public int getOpen_issues() {
        return open_issues;
    }

    public int getSubscribers_count() {
        return subscribers_count;
    }

    public PagedIterable<GHRepository.Contributor> getContributors() {
        return contributors;
    }

    public Map<String , Long> listLanguage() throws IOException {
        return dpo.listLanguages();
    }

    public RepositoryPO getDpo() {
        return dpo;
    }

    public GHContent getReadMe() throws IOException {
        return dpo.getReadme();
    }
}

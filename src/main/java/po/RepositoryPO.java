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

    @Deprecated
    public RepositoryPO(String name, int id, String owner_type, String html_url, String description, Boolean fork,
                        Date created, Date updated, Date pushed, int size, int stargazers_count, String language, int forks,
                        int open_issues, int subscribers_count, int contributor, int collaborators_count,
                        ArrayList<String> collaborators, ArrayList<String> contributors) {

    }



    public int getOpen_issues() {
        return repository.getOpenIssueCount();
    }

    public int getStargazers() {
        return repository.getWatchers();
    }



    public Date getPushed() {
        return repository.getPushedAt();
    }

    public Date getUpdated() throws IOException {
        return repository.getUpdatedAt();
    }

    public Date getCreated() throws IOException {
        return repository.getCreatedAt();
    }



    public boolean getFork() {
        return repository.isFork();
    }


    public String getOwner_type() {
        return "user";
    }

    public String getHtml_url() {
        return repository.getHtmlUrl().toString();
    }





}

package po;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.PagedIterable;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/4 0004.
 */

public class UserPO extends GHUser {

	@Deprecated
	public UserPO(int id, String login, String type, String name, String company, String email,
				  String public_repos, int public_gists, int followers, int following, Date created_at,
				  Date updated_at, ArrayList<String> related, ArrayList<String> has) {


	}

	public UserPO(GHUser parent) {
	}



    public String getUserImage(){
        return getAvatarUrl();
    }

    public int getGists(){
        return this.public_gists;
    }









    @Deprecated
    public PagedIterable<GHRepository> getHas(){
        return listRepositories();
    }

}
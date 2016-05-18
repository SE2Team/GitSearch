package po;

import org.kohsuke.github.GHUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by moeyui on 2016/3/4 0004.
 */

public class UserPO extends GHUser {

    GHUser user;

	@Deprecated
	public UserPO(int id, String login, String type, String name, String company, String email,
				  String public_repos, int public_gists, int followers, int following, Date created_at,
				  Date updated_at, ArrayList<String> related, ArrayList<String> has) {


	}

	public UserPO(GHUser parent) {
        user=parent;
	}



    public String getUserImage(){
        return getAvatarUrl();
    }

    public int getGists(){
        return this.public_gists;
    }







    public Date getCreated() throws IOException{
    	return getCreatedAt();
    }


}
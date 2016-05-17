package vo;

import po.*;

import java.sql.Date;

/**
 * Created by moeyui on 2016/3/10 0010.
 */
public class PO2VO {
    public static RepositoryVO convert(RepositoryPO po){
    	if(po==null){
    		return null;
    	}else{
			Date update = po.getUpdated();
			Date create = po.getCreated();
			Date push = po.getPushed();
			String update_str = convert(update);
			String create_str = convert(create);
			String push_str = convert(push);
    		 return new RepositoryVO(po.getName(), po.getId(), po.getOwner_type(), po.getHtml_url(), po.getDescription(),
    	                po.getFork(),create_str, update_str, push_str, po.getSize(), po.getStargazers(),
    	                po.getLanguage(), po.getForks(), po.getOpen_issues(), po.getSubscribers_count(),po.getContributor(),
    	                po.getCollaborators_count(),
    	                po.getCollaborators(),po.getContributors());
    	}
       
    }

    public static  UserVO convert (UserPO po){
    	if(po==null){
    		return null;
    	}else{
			Date update = po.getUpdated();
			Date create = po.getCreated();
			String update_str = convert(update);
			String create_str = convert(create);

			return new UserVO(po.getId(), po.getLogin(), po.getType(), po.getName(), po.getCompany()
					, po.getEmail(), po.getRepos(), po.getGists(), po.getFollowers(), po.getFollowing(), create_str
					, update_str,po.getRelated(),po.getHas(),po.getUserImage());
		}

    }

    public static StatisticsVO convert(StatisticsPO po){
    	if(po==null){
    		return null;
    	}else
    	return new StatisticsVO(po.getIssues_num(),po.getStars_num(),po.getForks_num(),po.getContributors_num(),po.getCollaborators_num());
    }
    
    public static StaIntVO convert(StaIntPO po){
    	if(po==null){
    		return null;
    	}else
    	return new StaIntVO(po.getInt(), po.getInt2());
    }
    
    public static StaStrVO convert(StaStrPO po){
    	if(po==null){
    		return null;
    	}else
    	return new StaStrVO(po.getStr(),po.getInt());
    }
    
    public static ScreenVO convert(ScreenPO po){
    	if(po==null){
    		return null;
    	}else
    	return new ScreenVO(po.getTime(), po.getLanguage(), po.getCategory());
    }

	public static String convert(Date date){
		return date.getYear()+""+"-"+date.getMonth()+""+"-"+date.getDay()+"";
	}
}


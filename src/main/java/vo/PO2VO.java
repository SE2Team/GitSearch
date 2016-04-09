package vo;

import po.RepositoryPO;
import po.ScreenPO;
import po.StaIntPO;
import po.StaStrPO;
import po.StatisticsPO;
import po.UserPO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/10 0010.
 */
public class PO2VO {
    public static RepositoryVO convert(RepositoryPO po){
        return new RepositoryVO(po.getName(), po.getId(), po.getOwner_type(), po.getHtml_url(), po.getDescription(),
                po.getFork(), po.getCreated(), po.getUpdated(), po.getPushed(), po.getSize(), po.getStargazers(),
                po.getLanguage(), po.getForks(), po.getOpen_issues(), po.getSubscribers_count(),po.getContributor(),
                po.getCollaborators_count(),
                po.getCollaborators(),po.getContributors());
    }

    public static  UserVO convert (UserPO po){
        return new UserVO(po.getId(), po.getLogin(), po.getType(), po.getName(), po.getCompany()
                , po.getEmail(), po.getRepos(), po.getGists(), po.getFollowers(), po.getFollowing(), po.getCreated()
                , po.getUpdated(),po.getRelated(),po.getHas());
    }

    public static StatisticsVO convert(StatisticsPO po){
    	return new StatisticsVO(po.getIssues_num(),po.getStars_num(),po.getForks_num(),po.getContributors_num(),po.getCollaborators_num());
    }
    
    public static StaIntVO convert(StaIntPO po){
    	return new StaIntVO(po.getInt(), po.getInt2());
    }
    
    public static StaStrVO convert(StaStrPO po){
    	return new StaStrVO(po.getStr(),po.getInt());
    }
    
    public static ScreenVO convert(ScreenPO po){
    	return new ScreenVO(po.getTime(), po.getLanguage(), po.getCategory());
    }
}

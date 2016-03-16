package vo;

import po.RepositoryPO;
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
                po.getLanguage(), po.getForks(), po.getContributor(), po.getOpen_issues(), po.getSubscribers_count(),po.getCollaborators(),po.getContributors());
    }

    public static  UserVO convert (UserPO po){
        return new UserVO(po.getId(), po.getLogin(), po.getType(), po.getName(), po.getCompany()
                , po.getEmail(), po.getRepos(), po.getGists(), po.getFollowers(), po.getFollowing(), po.getCreated()
                , po.getUpdated());
    }

    public static StatisticsVO convert(StatisticsPO po){
    	return new StatisticsVO(po.getName(), po.getNumber());
    }
}

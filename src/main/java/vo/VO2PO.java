package vo;

import po.RepositoryPO;
import po.ScreenPO;
import po.StaIntPO;
import po.StaStrPO;
import po.StatisticsPO;
import po.UserPO;

/** 
 * @author 
 * @date 
2016年4月5日 
下午8:48:40 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 *@throws 异常类及抛出条件
 */
public class VO2PO {
    public static RepositoryPO convert(RepositoryVO vo){
        return new RepositoryPO(vo.getName(), vo.getId(), vo.getOwner_type(), vo.getHtml_url(), vo.getDescription(),
                vo.getFork(), vo.getCreated(), vo.getUpdated(), vo.getPushed(), vo.getSize(), vo.getStargazers(),
                vo.getLanguage(), vo.getForks(), vo.getOpen_issues(), vo.getSubscribers_count(),vo.getContributor(),
                vo.getCollaborators_count(),
                vo.getCollaborators(),vo.getContributors());
    }

    public static  UserPO convert (UserVO vo){
        return new UserPO(vo.getId(), vo.getLogin(), vo.getType(), vo.getName(), vo.getCompany()
                , vo.getEmail(), vo.getRepos(), vo.getGists(), vo.getFollowers(), vo.getFollowing(), vo.getCreated()
                , vo.getUpdated(),vo.getRelated(),vo.getHas());
    }

    public static StatisticsPO convert(StatisticsVO vo){
    	return new StatisticsPO(vo.getssues_num(),vo.getStars_num(),vo.getForks_num(),vo.getContributors_num(),vo.getCollaborators_num());
    }
    
    public static StaIntPO convert(StaIntVO vo){
    	return new StaIntPO(vo.getInt(), vo.getInt2());
    }
    
    public static StaStrPO convert(StaStrVO vo){
    	return new StaStrPO(vo.getStr(),vo.getInt());
    }
    
    public static ScreenPO convert(ScreenVO vo){
    	return new ScreenPO(vo.getTime(), vo.getLanguage(), vo.getCategory());
    }
}

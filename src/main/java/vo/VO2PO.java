package vo;

import po.*;

/** 
 * @author 
 * @date 
2016骞�4鏈�5鏃� 
涓嬪崍8:48:40 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 *@throws 寮傚父绫诲強鎶涘嚭鏉′欢
 */
public class VO2PO {
    public static RepositoryPO convert(RepositoryVO vo){
    	if(vo==null){
    		return null;
    	}else{
    		return new RepositoryPO(vo.getName(), vo.getId(), vo.getOwner_type(), vo.getHtml_url(), vo.getDescription(),
                    vo.getFork(), vo.getCreated(), vo.getUpdated(), vo.getPushed(), vo.getSize(), vo.getStargazers(),
                    vo.getLanguage(), vo.getForks(), vo.getOpen_issues(), vo.getSubscribers_count(),vo.getContributor(),
                    vo.getCollaborators_count(),
                    vo.getCollaborators(),vo.getContributors());
    	}
        
    }

    public static  UserPO convert (UserVO vo){
    	if(vo==null){
    		return null;
    	}else{
    		return new UserPO(vo.getId(), vo.getLogin(), vo.getType(), vo.getName(), vo.getCompany()
                    , vo.getEmail(), vo.getRepos(), vo.getGists(), vo.getFollowers(), vo.getFollowing(), vo.getCreated()
                    , vo.getUpdated(),vo.getRelated(),vo.getHas());
    	}
        
    }

    public static StatisticsPO convert(StatisticsVO vo){
    	if(vo==null){
    		return null;
    	}else{
    		return new StatisticsPO(vo.getssues_num(),vo.getStars_num(),vo.getForks_num(),vo.getContributors_num(),vo.getCollaborators_num());
    	}
    	
    }
    
    public static StaIntPO convert(StaIntVO vo){
    	if(vo==null){
    		return null;
    	}else{
    		return new StaIntPO(vo.getInt(), vo.getInt2());
    	}
    	
    }
    
    public static StaStrPO convert(StaStrVO vo){
    	if(vo==null){
    		return null;
    	}else{
    		return new StaStrPO(vo.getStr(),vo.getInt());
    	}
    	
    }
    
    public static ScreenPO convert(ScreenVO vo){
    	if(vo==null){
    		return null;
    	}else{
    		return new ScreenPO(vo.getTime(), vo.getLanguage(), vo.getCategory());
    	}
    	
    }
}

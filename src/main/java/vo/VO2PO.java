package vo;

import po.*;

import java.sql.Date;


public class VO2PO {
    public static RepositoryPO convert(RepositoryVO vo){
    	if(vo==null){
    		return null;
    	}else{
			String create_str = vo.getCreated();
			String update_str = vo.getUpdated();
			String push_str = vo.getPushed();
			Date create = convert(create_str);
			Date update = convert(update_str);
			Date push = convert(push_str);
    		return new RepositoryPO(vo.getName(), vo.getId(), vo.getOwner_type(), vo.getHtml_url(), vo.getDescription(),
                    vo.getFork(), create, update, push, vo.getSize(), vo.getStargazers(),
                    vo.getLanguage(), vo.getForks(), vo.getOpen_issues(), vo.getSubscribers_count(),vo.getContributor(),
                    vo.getCollaborators_count(),
                    vo.getCollaborators(),vo.getContributors());
    	}
        
    }

    public static  UserPO convert (UserVO vo){
    	if(vo==null){
    		return null;
    	}else{
			String create_str = vo.getCreated();
			String update_str = vo.getUpdated();
			Date create = convert(create_str);
			Date update = convert(update_str);
    		return new UserPO(vo.getId(), vo.getLogin(), vo.getType(), vo.getName(), vo.getCompany()
                    , vo.getEmail(), vo.getRepos(), vo.getGists(), vo.getFollowers(), vo.getFollowing(), create
                    , update,vo.getRelated(),vo.getHas(),vo.getUserImage());
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

	public static Date convert(String date_str){
		String[] split = date_str.split("-");
		Date date = new Date(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]));
		return date;
	}
}

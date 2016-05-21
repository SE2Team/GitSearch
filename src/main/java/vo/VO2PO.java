package vo;

import po.*;

import java.sql.Date;

import org.kohsuke.github.GHRepository;


public class VO2PO {
    public static GHRepository convert(RepositoryVO vo){
    	if(vo==null){
    		return null;
    	}else{

    		return  vo.getDpo();
    	}
        
    }

    public static  UserPO convert (UserVO vo){
    	if(vo==null){
    		return null;
    	}else{

    		return new UserPO(vo.getDpo());
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
    		return new StaStrPO(vo.getX(),vo.getInt());
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

package vo;

import po.*;

import java.io.IOException;
import java.util.Date;

/**
 * Created by moeyui on 2016/3/10 0010.
 */
public class PO2VO {
    public static RepositoryVO convert(RepositoryPO po) throws IOException {
    	if(po==null){
    		return null;
    	}else{
    		 return new RepositoryVO(po);
    	}
       
    }

    public static UserVO convert (UserPO po) throws IOException {
    	if(po==null){
    		return null;
    	}else{
			if(po.getDpo()!=null){
				return new UserVO(po.getDpo());

			}else {
				return new UserVO(po);
			}
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


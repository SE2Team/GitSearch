package po;

import vo.RepositoryVO;
import vo.UserVO;

import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/10 0010.
 */
public class VO2PO {
    public static RepositoryPO convert(RepositoryVO po){
        return new RepositoryPO(po.getName(),po.getDescription(),po.getLanguage(),convert_users(po.getContributors()),
                convert_users(po.getContributors()),
                convert_repos(po.getForks()),po.getStars(),po.getFollowers(),po.getSubs());
    }

    public static UserPO convert (UserVO po){
        return new UserPO(po.getName(),po.getRegTime(),po.getFollowers(),po.getFollowing(),po.getEmail(),po.getCompany()
                ,convert_repos(po.getContribute()),convert_repos(po.getContribute()));
    }
    public static ArrayList<RepositoryPO> convert_repos(ArrayList<RepositoryVO> vos){
        ArrayList<RepositoryPO> pos=new ArrayList<RepositoryPO>();

        //只转换字符串
        for(RepositoryVO vo:vos){
            pos.add(new RepositoryPO(vo.getName(),vo.getDescription(),vo.getLanguage(),null,null,null
                    ,vo.getStars(),vo.getFollowers(),vo.getSubs()));
        }

        return pos;
    }

    public static ArrayList<UserPO> convert_users(ArrayList<UserVO> vos){
        ArrayList<UserPO> pos=new ArrayList<UserPO>();

        //只转换字符串
        for(UserVO vo:vos){
            pos.add(new UserPO(vo.getName(),vo.getRegTime(),vo.getFollowers(),vo.getFollowing(),vo.getEmail(),
                    vo.getCompany(),null,null));
        }

        return pos;
    }
}

package vo;

import po.RepositoryPO;
import po.UserPO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/10 0010.
 */
public class PO2VO {
    public static RepositoryVO convert(RepositoryPO po){
        return new RepositoryVO(po.getName(),po.getDescription(),po.getLanguage(),convert_users(po.getContributors()),
                convert_users(po.getContributors()),
                convert_repos(po.getForks()),po.getStars(),po.getFollowers(),po.getSubs());
    }

    public static  UserVO convert (UserPO po){
        return new UserVO(po.getName(),po.getRegTime(),po.getFollowers(),po.getFollowing(),po.getEmail(),po.getCompany()
        ,convert_repos(po.getContribute()),convert_repos(po.getContribute()));
    }
    public static ArrayList<RepositoryVO> convert_repos(ArrayList<RepositoryPO> pos){
        ArrayList<RepositoryVO> vos=new ArrayList<RepositoryVO>();

        //只转换字符串
        for(RepositoryPO po:pos){
            vos.add(new RepositoryVO(po.getName(),po.getDescription(),po.getLanguage(),null,null,null
            ,po.getStars(),po.getFollowers(),po.getSubs()));
        }

        return vos;
    }

    public static ArrayList<UserVO> convert_users(ArrayList<UserPO> pos){
        ArrayList<UserVO> vos=new ArrayList<UserVO>();

        //只转换字符串
        for(UserPO po:pos){
            vos.add(new UserVO(po.getName(),po.getRegTime(),po.getFollowers(),po.getFollowing(),po.getEmail(),
                    po.getCompany(),null,null));
        }

        return vos;
    }
}

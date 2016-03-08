package businesslogicService;

import Util.Repository_Sort;
import Util.User_Sort;
import businesslogic.RepositoryBL.Repository;
import vo.RepositoryVO;
import vo.UserVO;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public interface SortBLService {
    Iterator<UserVO> sort(Iterator<UserVO> itr,User_Sort sort);

    Iterator<RepositoryVO> sort(Iterator<RepositoryVO> itr, Repository_Sort sort);
}

package businesslogicService;

import Util.Repository_Sort;
import Util.User_Sort;
import vo.RepositoryVO;
import vo.UserVO;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public interface SortBLService {

    Iterator<RepositoryVO> sort(Iterator<RepositoryVO> itr, Repository_Sort sort);
}

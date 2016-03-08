package businesslogic.SortBL;

import Util.Repository_Sort;
import Util.User_Sort;
import businesslogicService.SortBLService;
import vo.RepositoryVO;
import vo.UserVO;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public class SortController implements SortBLService {

    Sort sort=new Sort();

    public Iterator<UserVO> sort(Iterator<UserVO> itr, User_Sort feature) {
        return sort.sort(itr, feature);
    }

    public Iterator<RepositoryVO> sort(Iterator<RepositoryVO> itr, Repository_Sort feature) {
        return sort.sort(itr, feature);
    }
}

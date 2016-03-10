package businesslogic.SortBL;

import Util.Repository_Sort;
import Util.User_Sort;
import data.DataFactory;
import dataService.DataFatoryService;
import dataService.RepositoryDataService;
import vo.RepositoryVO;
import vo.UserVO;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public class Sort {
    DataFatoryService dataFactory = new DataFactory();
    RepositoryDataService data = dataFactory.getRepositoryDataService();
    public Iterator<RepositoryVO> sort(Iterator<RepositoryVO> itr, Repository_Sort feature) {
        return null;
    }
}

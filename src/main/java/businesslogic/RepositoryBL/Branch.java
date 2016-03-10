package businesslogic.RepositoryBL;

import Util.BranchInfo;
import data.DataFactory;
import dataService.DataFatoryService;
import po.RepositoryPO;
import po.VO2PO;
import vo.PO2VO;
import vo.RepositoryVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public class Branch {
    DataFatoryService factory=new DataFactory();
    public Iterator<RepositoryVO> getBranches(String userName, String reponame) {
        ArrayList<RepositoryVO> vos=new ArrayList<RepositoryVO>();
        for (RepositoryPO po:factory.getBranchDataService().getBranches(userName, reponame)){
            vos.add(PO2VO.convert(po));
        }
        return vos.iterator();
    }

    public Iterator<String> NamesOfBranches(String userName, String reponame) {

        return factory.getBranchDataService().NamesOfBranches(userName, reponame).iterator();
    }

    public RepositoryVO checkBranch(String userName, String reponame) {
        return null;
    }

    public String BranchInfo(String userName, String reponame, BranchInfo info) {
        return null;
    }
}

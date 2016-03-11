package businesslogic.RepositoryBL;

import Util.RepositoryInfo;
import Util.Repository_Sort;
import data.DataFactory;
import dataService.DataFatoryService;
import po.RepositoryPO;
import vo.PO2VO;
import vo.RepositoryVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class Repository {
    private DataFatoryService factory=new DataFactory();
    public Iterator<RepositoryVO> getRepositories() throws IOException {
        ArrayList<RepositoryVO> vos=new ArrayList<RepositoryVO>();
        for(RepositoryPO po:factory.getRepositoryDataService().getRepositories()){
            vos.add(PO2VO.convert(po));
        }
        return vos.iterator();
    }

    public Iterator<String> getRepositoriesNames() {
        Iterator<String> itr=null;
        try {
            itr=factory.getRepositoryDataService().getRepositoriesNames().iterator();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itr;
    }

    public RepositoryVO checkRepository(String userName, String reponame) throws IOException {
        return PO2VO.convert(factory.getRepositoryDataService().checkRepository(userName, reponame));
    }

    public Map<String, Integer> languagesOfRepository(String userName, String reponame) {
        return factory.getRepositoryDataService().languagesOfRepository(userName, reponame);
    }

    public String RepositoryInfo(String userName, String reponame, RepositoryInfo info) {
        return null;
    }

    public Iterator<RepositoryVO> Search(String name) throws IOException {
        ArrayList<RepositoryPO> pos = factory.getRepositoryDataService().Search(name);
        ArrayList<RepositoryVO> vos = new ArrayList<RepositoryVO>();
        for (RepositoryPO po :
                pos) {
            vos.add(PO2VO.convert(po));
        }
        return vos.iterator();
    }

    public Iterator<RepositoryVO> sort(Repository_Sort repository_sort) throws IOException {
        ArrayList<RepositoryPO> pos = factory.getRepositoryDataService().sort(repository_sort);
        ArrayList<RepositoryVO> vos = new ArrayList<RepositoryVO>();
        for (RepositoryPO po : pos) {
            vos.add(PO2VO.convert(po));
        }
        return vos.iterator();

    }
}

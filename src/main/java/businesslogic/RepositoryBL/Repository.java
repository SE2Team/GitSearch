package businesslogic.RepositoryBL;

import Util.Repository_Sort;
import data.APIConnection;
import data.DataFactory;
import dataService.DataFatoryService;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHSearchBuilder;
import po.RepositoryPO;
import vo.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class Repository {
    private DataFatoryService factory=new DataFactory();
    public Iterator<RepositoryVO> getRepositories() throws IOException {
        ArrayList<RepositoryVO> vos=new ArrayList<RepositoryVO>();
        for(RepositoryPO po:factory.getRepositoryDataService().getRepositories()){
//            System.out.println(po.getName());
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

    public StaStrVO languagesOfRepository(RepositoryVO vo) throws IOException {
        ArrayList<String> x=new ArrayList<>();
        ArrayList<Integer> y=new ArrayList<>();
        for(String key:vo.listLanguage().keySet()){
            x.add(key);
            y.add(Math.toIntExact(vo.listLanguage().get(key)));
        }
        return new StaStrVO(x,y);
    }

    public StaStrVO languagesOfRepository(String userName, String reponame) throws IOException {
		return PO2VO.convert(factory.getRepositoryDataService().languagesOfRepository(userName, reponame));
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
    
    public Iterator<RepositoryVO> screen(ScreenVO vo) throws IOException{
    	ArrayList<RepositoryVO> vos=new ArrayList<RepositoryVO>();
    	ArrayList<RepositoryPO> pos=factory.getRepositoryDataService().screen(VO2PO.convert(vo));
    	for(RepositoryPO po:pos){
    		vos.add(PO2VO.convert(po));
    	}
    	return vos.iterator();
    }
    
//    public Iterator<RepositoryVO> screenLanguage(String language) throws IOException {
//    	ArrayList<RepositoryVO> vos=new ArrayList<RepositoryVO>();
//    	ArrayList<RepositoryPO> pos=factory.getRepositoryDataService().screenLanguage(language);
//    	for(RepositoryPO po:pos){
//    		vos.add(PO2VO.convert(po));
//    	}
//    	return vos.iterator();
//    }
//    
//    public Iterator<RepositoryVO> screenTime(String time) throws IOException{
//    	ArrayList<RepositoryVO> vos=new ArrayList<RepositoryVO>();
//    	ArrayList<RepositoryPO> pos=factory.getRepositoryDataService().screenTime(time);
//    	for(RepositoryPO po:pos){
//    		vos.add(PO2VO.convert(po));
//    	}
//    	return vos.iterator();
//    }
//    
//    public Iterator<RepositoryVO> screenCategory(String key) throws IOException{
//    	ArrayList<RepositoryVO> vos=new ArrayList<RepositoryVO>();
//    	ArrayList<RepositoryPO> pos=factory.getRepositoryDataService().screenCategory(key);
//    	for(RepositoryPO po:pos){
//    		vos.add(PO2VO.convert(po));
//    	}
//    	return vos.iterator();
//    }

    public Iterator<GHRepository> get(String name) {

        GHSearchBuilder<GHRepository> builder=APIConnection.getG().searchRepositories().stars(">=0");
        if(name==""){
            return builder.list().withPageSize(6).iterator();
        }else {
            return builder.q(name).list().withPageSize(6).iterator();
        }

    }
}

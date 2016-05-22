package businesslogic.RepositoryBL;

import businesslogicService.StatisticsBLService;
import vo.RepositoryVO;
import vo.StaIntVO;
import vo.StaStrVO;
import vo.UserVO;

import java.io.IOException;

public class StatisticsController implements StatisticsBLService{
	Statistics statistics=new Statistics();
	public StaStrVO getStar() throws IOException{
		return statistics.getStar();
	}
	
	public StaStrVO getScores(RepositoryVO vo) throws IOException{
		return statistics.getScores(vo);
	}
	
	public StaStrVO getForks() throws IOException{
		return statistics.getForks();
	}
	
	public StaStrVO getRepoCreated() throws IOException{
		return statistics.getRepoCreated();
	}

	public StaStrVO getLanguage() throws IOException{
		return statistics.getLanguage();
	}
	
	public StaStrVO getUserCreated() throws IOException{
		return statistics.getUserCreated();
	}
	
	public StaStrVO getUserType() throws IOException{
		return statistics.getUserType();
	}
	
	public StaIntVO getUserHas(){
		return statistics.getUserHas();
	}
	
	public StaIntVO getUserRelated(){
		return statistics.getUserRelated();
	}
	
	public StaStrVO getCompany() throws IOException{
		return statistics.getCompany();
	}
	
	public Integer getHasNum(String name){
		return statistics.getHasNum(name);
	}

	@Override
	public StaStrVO getCollaborator() {
		return statistics.getCollaborator();
	}

	@Override
	public StaStrVO getContributor() {
		// TODO Auto-generated method stub
		return statistics.getContributor();
	}

	@Override
	public StaStrVO getFollowers() {
		return statistics.getFollowers();
	}

	@Override
	public StaStrVO getAll_RepoCreated() {
		// TODO Auto-generated method stub
		return statistics.getAll_RepoCreated();
	}

	@Override
	public StaStrVO getAll_UserCreated() {
		// TODO Auto-generated method stub
		return statistics.getAll_UserCreated();
	}

	@Override
	public StaStrVO getAll_Star() {
		// TODO Auto-generated method stub
		return statistics.getAll_Star();
	}

	@Override
	public StaStrVO getAll_Fork() {
		// TODO Auto-generated method stub
		return statistics.getAll_Fork();
	}

	@Override
	public StaStrVO getCommit(RepositoryVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaStrVO getUserEvent(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

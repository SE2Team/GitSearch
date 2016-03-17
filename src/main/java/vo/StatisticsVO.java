package vo;
/** 
 * @author 
 * @date 
2016年3月16日 
下午4:26:41 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 *@throws 异常类及抛出条件
 */
public class StatisticsVO {

	double issues_num=0;
	double stars_num=0;
	double forks_num=0;
	double contributors_num=0;
	double collaborators_num=0;	
	
	public StatisticsVO(double issues_num, double stars_num, double forks_num, double contributors_num,
			double collaborators_num){
		this.issues_num=issues_num;
		this.stars_num=stars_num;
		this.forks_num=forks_num;
		this.contributors_num=contributors_num;
		this.collaborators_num=collaborators_num;
	}
	
	public double geIssues_num(){
		return this.issues_num;
	}
	
	public double getStars_num(){
		return this.stars_num;
	}
	
	public double getForks_num(){
		return this.forks_num;
	}
	
	public double getContributors_num(){
		return this.contributors_num;
	}
	
	public double getCollaborators_num(){
		return this.collaborators_num;
	}
}

package po;


public class StatisticsPO {
	// String issues;
	// String stars;
	// String forks;
	// String contributors;
	// String collaborators;
	double issues_num=0;
	double stars_num=0;
	double forks_num=0;
	double contributors_num=0;
	double collaborators_num=0;

	// public StatisticsPO(String issues, String stars, String forks, String
	// contributors, String collaborators,
	// double issues_num, double stars_num, double forks_num, double
	// contributors_num, double collaborators_num){
	// this.issues=issues;
	// this.stars=stars;
	// this.forks=forks;
	// this.contributors_num=contributors_num;
	// this.collaborators=collaborators;
	// this.contributors=contributors;
	// this.forks_num=forks_num;
	// this.issues_num=issues_num;
	// this.stars_num=stars_num;
	// this.collaborators_num=collaborators_num;
	// }

	public StatisticsPO(double issues_num, double stars_num, double forks_num, double contributors_num,
			double collaborators_num) {
		this.contributors_num = contributors_num;
		this.forks_num = forks_num;
		this.issues_num = issues_num;
		this.stars_num = stars_num;
		this.collaborators_num = collaborators_num;
	}

	// public String getCollaborators(){
	// return this.collaborators;
	// }
	//
	//
	//
	// public String getContributors(){
	// return this.contributors;
	// }
	//
	// public String getForks(){
	// return this.forks;
	// }
	//
	// public String getStars(){
	// return this.stars;
	// }
	//
	// public String getIssues(){
	// return this.issues;
	// }

	public double getIssues_num() {
		return this.issues_num;
	}

	public double getStars_num() {
		return this.stars_num;
	}

	public double getForks_num() {
		return this.forks_num;
	}

	public double getContributors_num() {
		return this.contributors_num;
	}

	public double getCollaborators_num() {
		return this.collaborators_num;
	}

}

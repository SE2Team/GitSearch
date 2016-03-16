package po;

public class StatisticsPO {
	String name;
	String number;
	
	public StatisticsPO(	String name,
	String number){
		this.name=name;
		this.number=number;
	}
	
	public String getName(){
		return this.name;
	}
		
	public String getNumber(){
		return this.number;
	}
}

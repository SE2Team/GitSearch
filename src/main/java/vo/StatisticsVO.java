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

	String name;
	String number;
	
	public StatisticsVO(String name,String number){
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

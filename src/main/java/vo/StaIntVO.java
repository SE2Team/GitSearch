package vo;
/** 
 * @author 
 * @date 
2016年3月29日 
下午8:36:32 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 *@throws 异常类及抛出条件
 */
public class StaIntVO {
	Integer integer;
	Integer integer2;
	
	public StaIntVO(Integer integer,Integer integer2){
		this.integer=integer;
		this.integer2=integer2;
	}
	
	public Integer getInt(){
		return this.integer;
	}
	
	public Integer getint2(){
		return this.integer2;
	}
}

package vo;
/** 
 * @author 
 * @date 
2016年3月29日 
下午8:37:06 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 *@throws 异常类及抛出条件
 */
public class StaStrVO {

	String str;
	Integer integer;
	public StaStrVO(String str,
	Integer integer){
		this.str=str;
		this.integer=integer;
	}
	
	public String getStr(){
		return this.str;
	}
	
	public Integer getInt(){
		return this.integer;
	}
}
